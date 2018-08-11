package com.fsi.ticket.wechat_pay2.mapper;


import com.fsi.ticket.wechat_pay2.model.UserBuyTicketInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBuyTicketInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBuyTicketInfo record);

    int insertSelective(UserBuyTicketInfo record);

    UserBuyTicketInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBuyTicketInfo record);

    int updateByPrimaryKey(UserBuyTicketInfo record);
}