package com.piggsoft.tinyblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author piggsoft
 * @version 1.0
 * @create 2018/1/29
 * @since 1.0
 */
@Controller
@RequestMapping("/admin")
public class IndexController {

    @GetMapping
    public String index() {
        return "admin/index";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "admin/login";
    }

}
