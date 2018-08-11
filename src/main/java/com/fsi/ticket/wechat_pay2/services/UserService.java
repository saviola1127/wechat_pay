package com.fsi.ticket.wechat_pay2.services;



import com.fsi.ticket.wechat_pay2.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

    List<User> getAllUser();
}
