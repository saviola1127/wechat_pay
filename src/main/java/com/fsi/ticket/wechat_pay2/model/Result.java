package com.fsi.ticket.wechat_pay2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class Result {
    private String msg;
    private String status;
    private Object start;
    private Object pay;

    public Result(String msg, String status) {
        this.msg = msg;
        this.status = status;
    }
}
