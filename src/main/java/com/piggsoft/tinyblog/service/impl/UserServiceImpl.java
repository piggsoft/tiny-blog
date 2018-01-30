package com.piggsoft.tinyblog.service.impl;

import com.piggsoft.tinyblog.po.Role;
import com.piggsoft.tinyblog.po.User;
import com.piggsoft.tinyblog.po.UserRole;
import com.piggsoft.tinyblog.service.IUserRoleService;
import com.piggsoft.tinyblog.service.IUserService;
import com.piggsoft.tinyblog.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import com.piggsoft.tinyblog.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserRoleService userRoleService;

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    @Transactional
    public int save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        insert(user);
        List<Role> roles = roleService.findAll();
        List<UserRole> userRoles = new ArrayList<>(roles.size());
        for (Role role : roles) {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(role.getId());
            userRoleService.insert(userRole);
        }
        return 1;
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
    @Cacheable(value = "user", key = "'user'.concat(#username)")
    public User findByUsername(String username) {
        return userDao.findOneByUsername(username);
    }
}
