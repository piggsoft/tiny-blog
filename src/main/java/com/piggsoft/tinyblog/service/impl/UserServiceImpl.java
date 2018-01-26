package com.piggsoft.tinyblog.service.impl;

import com.piggsoft.tinyblog.po.User;
import com.piggsoft.tinyblog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

import com.piggsoft.tinyblog.dao.UserDao;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    public int save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        /*user.setRoles(new HashSet<>(roleRepository.findAll()));*/
        return insert(user);
    }

    @Override
    public int insertSelective(User user) {
        return userDao.insertSelective(user);
    }

    @Override
    public int insertList(List<User> users) {
        return userDao.insertList(users);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findOneByUsername(username);
    }
}
