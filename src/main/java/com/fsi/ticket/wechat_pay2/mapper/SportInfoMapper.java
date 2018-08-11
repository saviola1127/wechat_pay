package com.fsi.ticket.wechat_pay2.mapper;


import com.fsi.ticket.wechat_pay2.model.SportInfo;
import com.fsi.ticket.wechat_pay2.model.SportInfoTicket;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SportInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportInfo record);

    int insertSelective(SportInfo record);

    SportInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportInfo record);

    int updateByPrimaryKey(SportInfo record);

    //new added
    List<SportInfoTicket> getAllSportInfo();

}