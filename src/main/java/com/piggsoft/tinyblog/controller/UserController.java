package com.piggsoft.tinyblog.controller;

import com.piggsoft.tinyblog.dto.UserForm;
import com.piggsoft.tinyblog.po.User;
import com.piggsoft.tinyblog.security.SecurityService;
import com.piggsoft.tinyblog.service.IUserService;
import com.piggsoft.tinyblog.validater.UserNameValidator;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserNameValidator userNameValidator;

    @Autowired
    private Mapper mapper;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserForm());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid UserForm userForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        ValidationUtils.invokeValidator(userNameValidator, userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        User user = mapper.map(userForm, User.class);

        userService.insert(user);

        securityService.autologin(user.getUsername(), user.getPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
