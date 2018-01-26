package com.piggsoft.tinyblog.service;

import java.util.List;
import com.piggsoft.tinyblog.po.User;
public interface IUserService {

    int insert(User user);

    int insertSelective(User user);

    int insertList(List<User> users);

    int update(User user);

    User findByUsername(String username);
}
