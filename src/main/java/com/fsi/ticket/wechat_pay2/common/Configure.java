package com.fsi.ticket.wechat_pay2.common;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class Configure {

    private static String token = null;
    private static Date tokenTime = null;
    private static String jsapiTicket = null;
    private static Date jsapiTicketTime = null;

    public static String MD5 = "MD5";
    public static String EMPTY = "";
    public static String SUCCESS = "SUCCESS";
    public static String HEX_FORMAT = "%02x";
    public static String TRADE_TYPE = "JSAPI";
    public static String MIDDLE_LINE = "-";
    public static String CHARTSET_UTF8 = "UTF-8";

    public static String NOTIFY_SUCCESS = "<xml>\n<return_code><![CDATA[SUCCESS]]></return_code>\n<return_msg><![CDATA[OK]]></return_msg>\n</xml>";
    public static String NOTIFY_FAIL = "<xml>\n<return_code><![CDATA[FAIL]]></return_code>\n<return_msg><![CDATA[ERROR]]></return_msg>\n</xml>";

    private static String key = "5KVj6ldxvck2W6PpXamVdB2k8vuYN816";
    // 微信分配的公众号ID（开通公众号之后可以获取到）
    private static String appID = "wxa29362d013ba8ba0";
    private static String appSecret = "7849c8d68986a566a9d128e80498c34f";
    // 微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
    private static String mchID = "1507811021";
    // 机器IP
    private static String ip = "127.0.0.1";

    // 以下是几个API的路径：
    // 统一下单
    public static String UNIFIEDORDER_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    //  access_token API
    public static String TOKEN_API = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
    // 临时票据API
    public static String TICKET_API = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
    // 微信OPENID API
    public static String OPENID_API = "https://api.weixin.qq.com/sns/oauth2/access_token";

    public static void setKey(String key) {
        Configure.key = key;
    }

    public static void setAppID(String appID) {
        Configure.appID = appID;
    }

    public static void setMchID(String mchID) {
        Configure.mchID = mchID;
    }

    public static void setIp(String ip) {
        Configure.ip = ip;
    }

    public static String getKey(){
        return key;
    }

    public static String getAppid(){
        return appID;
    }

    public static String getMchid(){
        return mchID;
    }

    public static String getIP(){
        return ip;
    }

    public static String getAppSecret() {
        return appSecret;
    }

    public static void setAppSecret(String appSecret) {
        Configure.appSecret = appSecret;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Configure.token = token;
        Configure.tokenTime = new Date();
    }

    public static String getJsapiTicket() {
        return jsapiTicket;
    }

    public static void setJsapiTicket(String jsapiTicket) {
        Configure.jsapiTicket = jsapiTicket;
        Configure.jsapiTicketTime = new Date();
    }

    public static boolean checkToken() {
        if (!StringUtils.isEmpty(Configure.token)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tokenTime);
            calendar.add(Calendar.SECOND, 7200);
            return calendar.before(new Date());
        }
        return true;
    }

    public static boolean checkJsapiTicket() {
        if (!StringUtils.isEmpty(Configure.jsapiTicket)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(jsapiTicketTime);
            calendar.add(Calendar.SECOND, 7200);
            return calendar.before(new Date());
        }
        return true;
    }
}