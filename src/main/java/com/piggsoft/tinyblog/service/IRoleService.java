package com.piggsoft.tinyblog.service;

import java.util.List;
import com.piggsoft.tinyblog.po.Role;
public interface IRoleService {

    int insert(Role role);

    int insertSelective(Role role);

    int insertList(List<Role> roles);

    int update(Role role);

    List<Role> findAll();
}
