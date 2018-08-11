package com.fsi.ticket.wechat_pay2.services.impl;


import com.fsi.ticket.wechat_pay2.mapper.SportInfoMapper;
import com.fsi.ticket.wechat_pay2.model.SportInfoTicket;
import com.fsi.ticket.wechat_pay2.services.SportInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service(value = "sportInfoService")
public class SportInfoServiceImpl implements SportInfoService {

    @Autowired
    private SportInfoMapper sportInfoMapper;

    @Override
    public List<SportInfoTicket> getAllSportInfo() {
        List<SportInfoTicket> sportInfoTicketList = sportInfoMapper.getAllSportInfo();

        List<SportInfoTicket> resultSportInfoTicket = new ArrayList<>();

        for (SportInfoTicket sportInfoTicket: sportInfoTicketList){
            boolean found = false;
            SportInfoTicket tmpSportInfoTicket = null;
            for (SportInfoTicket finalResult: resultSportInfoTicket){
                if (finalResult.getSportName().equals(sportInfoTicket.getSportName()) &&
                        finalResult.getSportType().equals(sportInfoTicket.getSportType())){
                    found = true;
                    tmpSportInfoTicket = finalResult;
                    break;
                }
            }

            if (!found){
                resultSportInfoTicket.add(sportInfoTicket);
            }else{
                tmpSportInfoTicket.getSportTimeTicketPriceList().addAll(sportInfoTicket.getSportTimeTicketPriceList());
            }
        }
        return resultSportInfoTicket;
    }
}
