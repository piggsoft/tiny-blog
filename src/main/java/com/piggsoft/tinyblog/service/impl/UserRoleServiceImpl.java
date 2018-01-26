package com.piggsoft.tinyblog.service.impl;

import com.piggsoft.tinyblog.po.UserRole;
import com.piggsoft.tinyblog.dao.UserRoleDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.piggsoft.tinyblog.service.IUserRoleService;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public int insert(UserRole userRole){
        return userRoleDao.insert(userRole);
    }

    @Override
    public int insertSelective(UserRole userRole){
        return userRoleDao.insertSelective(userRole);
    }

    @Override
    public int insertList(List<UserRole> userRoles){
        return userRoleDao.insertList(userRoles);
    }

    @Override
    public int update(UserRole userRole){
        return userRoleDao.update(userRole);
    }
}
