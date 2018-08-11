package com.fsi.ticket.wechat_pay2.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsi.ticket.wechat_pay2.common.Configure;
import com.fsi.ticket.wechat_pay2.common.WechatNotify;
import com.fsi.ticket.wechat_pay2.common.WechatUtil;
import com.fsi.ticket.wechat_pay2.model.Result;
import com.fsi.ticket.wechat_pay2.model.UserBuyTicketInfo2;
import com.fsi.ticket.wechat_pay2.services.UserBuyTicketInfoService;
import com.fsi.ticket.wechat_pay2.services.WechatPayService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class WechatPayController {
    private final static Logger logger = LoggerFactory.getLogger(WechatPayController.class);

    @Autowired
    private WechatPayService payService;


    @Autowired
    private UserBuyTicketInfoService userBuyTicketInfo2Service;

    @Autowired

    @RequestMapping("pay_choose")
    public String payChoose(){
        return "/pay_choose.jsp";
    }

    @RequestMapping("success")
    public String success(){
        logger.info("success page");
        return "/success";

    }

    @RequestMapping("fail")
    public String fail(){
        logger.info("fail page");
        return "/fail";

    }

    @RequestMapping("cancel")
    public String cancel(){
        logger.info("cancel page");
        return "/cancel";
    }

    @RequestMapping(value="/payment/wechat_pay")
    public String wechat_pay(){
        logger.info("wechat_pay page");
        return "wechat_pay";
    }


    private UserBuyTicketInfo2 create(HttpServletRequest request){
        UserBuyTicketInfo2 userBuyTicketInfo2 = new UserBuyTicketInfo2();
        userBuyTicketInfo2.setSportName(request.getParameter("sport_name"));
        userBuyTicketInfo2.setSportTime(request.getParameter("sport_time"));
        userBuyTicketInfo2.setUserPrice(request.getParameter("user_price"));
        userBuyTicketInfo2.setTicketNumber(request.getParameter("ticket_number"));
        userBuyTicketInfo2.setOughtAmount(request.getParameter("ought_amount"));
        userBuyTicketInfo2.setUserName(request.getParameter("user_name"));
        userBuyTicketInfo2.setMobilePhone(request.getParameter("mobile_phone"));
        userBuyTicketInfo2.setUserEmail(request.getParameter("user_email"));

        return  userBuyTicketInfo2;
    }
    @RequestMapping(value="/payment/payment")
    @ResponseBody
    public Result payment(Model model, HttpServletRequest request, HttpServletResponse rsp){
        rsp.addHeader("Access-Control-Allow-Origin", "*");
        rsp.setHeader("Content-Type", "application/json;charset=UTF-8");

        UserBuyTicketInfo2 userBuyTicketInfo2=create(request);
        String out_trade_no = System.currentTimeMillis() + "";
        String openId = payService.takeOpenId(request.getParameter("code"));

        userBuyTicketInfo2.setOpenid(openId);
        userBuyTicketInfo2.setOrderNo(out_trade_no);

        userBuyTicketInfo2Service.addTicketInfo(userBuyTicketInfo2);

        System.out.println("code:"+request.getParameter("code"));
        System.out.println("openId:"+openId);
        Result result = new Result("success", "");
        if (StringUtils.isEmpty(openId)) {
            result.setStatus("error");
            result.setMsg("failed to get openid");
            return result;
        }
        String notify = "https://ticket.feisea.cn/mp/notify.htm";
        String body = userBuyTicketInfo2.getSportName();
        String total = String.valueOf(Long.valueOf(userBuyTicketInfo2.getUserPrice())*100); // 单位分
//        String total = "1"; // 单位分

        String ip = request.getRemoteAddr();

        String res = payService.unifiedorder(notify, openId, body, total, out_trade_no, ip);

        //String url = "https://ticket.feisea.cn/mp/payment/wechat_pay.jsp";
        String url = request.getRequestURL().toString();
        payService.wechatPay(model,res,url);
        result.setStart(model.asMap().get("start"));
        result.setPay(model.asMap().get("pay"));
        System.out.println("1234");

        return result;
    }

    /**
     * 微信支付成功后的回调函数
     *
     * @param request
     * @return
     */
    @RequestMapping(value="/notify.htm",method=RequestMethod.POST)
    @ResponseBody
    public String wechatNotify(HttpServletRequest request){
        // 从 request 对象中获取 WechatNotify 对象
        WechatNotify notify = WechatUtil.getNotifyBean(request);
        userBuyTicketInfo2Service.updateOrderStatus(notify.getOut_trade_no(), notify.getOpenid(), notify.getResult_code());
        // 如果 notify 对象不为空 并且 result_code 和 return_code 都为 'SUCCESS' 则表示支付成功
        if (notify != null
                && StringUtils.equals(notify.getResult_code(), Configure.SUCCESS)
                && StringUtils.equals(notify.getReturn_code(), Configure.SUCCESS)) {

            return Configure.NOTIFY_SUCCESS;
        }
        return Configure.NOTIFY_FAIL;
    }
}
