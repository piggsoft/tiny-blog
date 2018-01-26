package com.piggsoft.tinyblog.service;

import java.util.List;
import com.piggsoft.tinyblog.po.UserRole;
public interface IUserRoleService {

    int insert(UserRole userRole);

    int insertSelective(UserRole userRole);

    int insertList(List<UserRole> userRoles);

    int update(UserRole userRole);
}
