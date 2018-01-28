package com.piggsoft.tinyblog.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.piggsoft.tinyblog.po.SystemSettings;
import com.piggsoft.tinyblog.dao.SystemSettingsDao;
import com.piggsoft.tinyblog.service.SystemSettingsService;

@Service
public class SystemSettingsServiceImpl implements SystemSettingsService{

    @Resource
    private SystemSettingsDao systemSettingsDao;

    @Override
    public int insert(SystemSettings systemSettings){
        return systemSettingsDao.insert(systemSettings);
    }

    @Override
    public int insertSelective(SystemSettings systemSettings){
        return systemSettingsDao.insertSelective(systemSettings);
    }

    @Override
    public int insertList(List<SystemSettings> systemSettingss){
        return systemSettingsDao.insertList(systemSettingss);
    }

    @Override
    public int update(SystemSettings systemSettings){
        return systemSettingsDao.update(systemSettings);
    }
}
