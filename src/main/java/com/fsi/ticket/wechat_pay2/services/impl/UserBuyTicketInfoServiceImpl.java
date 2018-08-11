package com.fsi.ticket.wechat_pay2.services.impl;

import com.fsi.ticket.wechat_pay2.mapper.UserBuyTicketInfo2Mapper;
import com.fsi.ticket.wechat_pay2.model.UserBuyTicketInfo2;
import com.fsi.ticket.wechat_pay2.services.UserBuyTicketInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userBuyTicketInfo2Service")
public class UserBuyTicketInfoServiceImpl implements UserBuyTicketInfoService {

    @Autowired
    private UserBuyTicketInfo2Mapper userBuyTicketInfo2Mapper;

    @Override
    public int addTicketInfo(UserBuyTicketInfo2 userBuyTicketInfo2) {
        userBuyTicketInfo2Mapper.insert(userBuyTicketInfo2);
        return 0;
    }

    @Override
    public List<UserBuyTicketInfo2> findAllUser(String phone_number) {
        return null;
    }

    @Override
    public int updateOrderStatus(String order_no, String open_id, String status) {
        if (status.equals("SUCCESS")){
            status="PAID";
        }else{
            status="FAILED";
        }
        return userBuyTicketInfo2Mapper.updateByOrderNo(order_no,open_id, status);
    }
}
