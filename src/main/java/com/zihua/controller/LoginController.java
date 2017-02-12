package com.zihua.controller;

import com.zihua.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by zihua on 17-2-5.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private SystemService service;

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam Integer userId, String password,
                        HttpServletResponse response) {
        boolean ok = service.check(userId, password);
        if (ok) {
            Cookie loginCookie = new Cookie("loginCookie", userId.toString());
            loginCookie.setMaxAge(60 * 10*10);
            response.addCookie(loginCookie);
            return "redirect:/home/";
        } else {
            return "redirect:/";
        }
    }


}
