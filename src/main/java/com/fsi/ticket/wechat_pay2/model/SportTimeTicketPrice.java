package com.fsi.ticket.wechat_pay2.model;

import java.util.Date;
import java.util.List;

public class SportTimeTicketPrice {
    private Integer sportId;
    private Date sportTime;
    private List<TicketPrice> ticketPriceList;

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    public Date getSportTime() {
        return sportTime;
    }

    public void setSportTime(Date sportTime) {
        this.sportTime = sportTime;
    }

    public List<TicketPrice> getTicketPriceList() {
        return ticketPriceList;
    }

    public void setTicketPriceList(List<TicketPrice> ticketPriceList) {
        this.ticketPriceList = ticketPriceList;
    }
}