package com.piggsoft.tinyblog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.piggsoft.tinyblog.po.SystemSettings;

@Mapper
public interface SystemSettingsDao {
    int insert(@Param("systemSettings") SystemSettings systemSettings);

    int insertSelective(@Param("systemSettings") SystemSettings systemSettings);

    int insertList(@Param("systemSettingss") List<SystemSettings> systemSettingss);

    int update(@Param("systemSettings") SystemSettings systemSettings);

    SystemSettings findOneByKey(@Param("key")String key);


}
