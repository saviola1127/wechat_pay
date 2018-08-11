package com.fsi.ticket.wechat_pay2.services;


import com.fsi.ticket.wechat_pay2.model.SportInfoTicket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SportInfoService {
    List<SportInfoTicket> getAllSportInfo();
}
