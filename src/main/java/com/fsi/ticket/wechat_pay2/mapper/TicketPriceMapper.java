package com.fsi.ticket.wechat_pay2.mapper;


import com.fsi.ticket.wechat_pay2.model.TicketPrice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TicketPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketPrice record);

    int insertSelective(TicketPrice record);

    TicketPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketPrice record);

    int updateByPrimaryKey(TicketPrice record);
}