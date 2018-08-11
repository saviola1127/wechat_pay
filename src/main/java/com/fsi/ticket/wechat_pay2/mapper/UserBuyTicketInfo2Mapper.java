package com.fsi.ticket.wechat_pay2.mapper;

import com.fsi.ticket.wechat_pay2.model.UserBuyTicketInfo2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserBuyTicketInfo2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBuyTicketInfo2 record);

    int insertSelective(UserBuyTicketInfo2 record);

    UserBuyTicketInfo2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBuyTicketInfo2 record);

    int updateByPrimaryKey(UserBuyTicketInfo2 record);

    //added
    int updateByOrderNo(@Param("order_no")String order_no, @Param("open_id")String open_id, @Param("status")String status);
}