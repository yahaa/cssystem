package com.zihua.controller;

import com.google.gson.Gson;
import com.zihua.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zihua on 17-1-23.
 */
@Controller
@RequestMapping("/home")
public class SystemController {
    @Autowired
    private SystemService service;
    private Gson gson = new Gson();

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/user_infos", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getUserInfo(@CookieValue("loginCookie") String cookie) {
        int id = Integer.valueOf(cookie);
        return service.getUserInfoById(id);
    }

    @RequestMapping(value = "/user_permits", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getUserPermits(@CookieValue("loginCookie") String cookie) {
        int id = Integer.valueOf(cookie);
        return service.getUserPermitsById(id);
    }

    @RequestMapping(value = "/user_roles", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getUserRoles(@RequestParam int id) {
        return service.getUserRolesById(id);
    }

    @RequestMapping(value = "/m_permit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllUserJson() {
        return service.queryAllUserJson();
    }

    @RequestMapping(value = "/query_course", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getCourse(String courseId, String teacherId, String courseName, String teacherName) {
        return service.queryCourses(courseId, teacherId, courseName, teacherName);
    }


}
