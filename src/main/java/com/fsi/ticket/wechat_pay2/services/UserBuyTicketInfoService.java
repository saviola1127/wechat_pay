package com.fsi.ticket.wechat_pay2.services;

import com.fsi.ticket.wechat_pay2.model.UserBuyTicketInfo2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserBuyTicketInfoService {
    int addTicketInfo(UserBuyTicketInfo2 userBuyTicketInfo2);

    List<UserBuyTicketInfo2> findAllUser(String phone_number);

    int updateOrderStatus(String order_no, String open_id, String status);
}
