package com.fsi.ticket.wechat_pay2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.fsi.ticket.wechat_pay2.model")
public class WechatPay2Application  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WechatPay2Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WechatPay2Application.class, args);
    }
}
