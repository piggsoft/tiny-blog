/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2018/1/22                           Create
 */
package com.piggsoft.tinyblog.dto;

import com.piggsoft.tinyblog.validater.PropertyScriptAssert;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author piggsoft
 * @version 1.0
 * @create 2018/1/22
 * @since 1.0
 */
@PropertyScriptAssert(lang = "javascript", script = "_this.passwordConfirm == _this.password", message = "{passwordConfirm.not.same}", property = "passwordConfirm")
public class UserForm {

    private Long id;
    @NotBlank
    @Length(min = 6, max = 32)
    private String username;
    @NotBlank
    @Length(min = 8, max = 32)
    private String password;
    private String passwordConfirm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
