package com.piggsoft.tinyblog.service;

import java.util.List;
import com.piggsoft.tinyblog.po.SystemSettings;
public interface SystemSettingsService{

    int insert(SystemSettings systemSettings);

    int insertSelective(SystemSettings systemSettings);

    int insertList(List<SystemSettings> systemSettingss);

    int update(SystemSettings systemSettings);
}
