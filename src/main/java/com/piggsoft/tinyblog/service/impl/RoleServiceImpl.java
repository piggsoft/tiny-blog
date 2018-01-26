package com.piggsoft.tinyblog.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.piggsoft.tinyblog.po.Role;
import com.piggsoft.tinyblog.dao.RoleDao;
import com.piggsoft.tinyblog.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleDao roleDao;

    @Override
    public int insert(Role role){
        return roleDao.insert(role);
    }

    @Override
    public int insertSelective(Role role){
        return roleDao.insertSelective(role);
    }

    @Override
    public int insertList(List<Role> roles){
        return roleDao.insertList(roles);
    }

    @Override
    public int update(Role role){
        return roleDao.update(role);
    }
}
