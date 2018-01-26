package com.piggsoft.tinyblog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.piggsoft.tinyblog.po.UserRole;

@Mapper
public interface UserRoleDao {
    int insert(@Param("userRole") UserRole userRole);

    int insertSelective(@Param("userRole") UserRole userRole);

    int insertList(@Param("userRoles") List<UserRole> userRoles);

    int update(@Param("userRole") UserRole userRole);

    List<Long> findRoleIdByUserId(@Param("userId") Long userId);

    List<Long> findUserIdByRoleId(@Param("roleId") Long roleId);


}
