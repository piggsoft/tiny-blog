/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2018/1/22                           Create
 */
package com.piggsoft.tinyblog.validater;

import com.piggsoft.tinyblog.dto.UserForm;
import com.piggsoft.tinyblog.po.User;
import com.piggsoft.tinyblog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author piggsoft
 * @version 1.0
 * @create 2018/1/22
 * @since 1.0
 */
@Component
public class UserNameValidator implements Validator {

    @Autowired
    private IUserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(UserForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm user = (UserForm) target;
        User dbUser = userService.findByUsername(user.getUsername());
        if (dbUser != null) {
            errors.rejectValue("username", "username.already.exist");
        }
    }
}
