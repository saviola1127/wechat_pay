package com.fsi.ticket.wechat_pay2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Setter
@ToString
@EqualsAndHashCode
public class SportInfoTicket  {
    private Integer sportId;

    private String sportName;

    private Integer matchId;



    @JsonIgnore
    private String status;

    private String sportType;

    private List<SportTimeTicketPrice> sportTimeTicketPriceList;

    @JsonIgnore
    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    @JsonIgnore
    public Integer getSportId() {
        return sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public String getStatus() {
        return status;
    }

    public String getSportType() {
        return sportType;
    }

    public List<SportTimeTicketPrice> getSportTimeTicketPriceList() {
        return sportTimeTicketPriceList;
    }
}
