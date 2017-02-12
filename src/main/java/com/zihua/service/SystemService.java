package com.zihua.service;

import com.zihua.dao.entityDao.UserDao;
import com.zihua.dao.systemDao.QueryDao;
import com.zihua.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zihua on 17-2-5.
 */
@Service
public class SystemService {
    @Autowired
    private QueryDao queryDao;
    @Autowired
    private UserDao userDao;

    public boolean check(int userId, String password) {
        return queryDao.checkUserExist(userId, password);
    }

    public String getUserInfoById(int id) {
        return queryDao.getUserJsonById(id);
    }

    public String getUserPermitsById(int id) {
        return queryDao.getUserOfPermitJsonById(id);
    }

    public String getUserRolesById(int id) {
        return queryDao.getUserOfRoleJsonById(id);
    }

    /**
     * 返回所有用户
     *
     * @return list
     */
    public String queryAllUserJson() {
        return userDao.queryAllUser();
    }


    public String queryCourses(String courseId, String teacherId, String courseName, String teacherName) {
        return queryDao.queryCourse(courseId, teacherId, courseName, teacherName);
    }


    public String getTeacherById(int id) {
        return queryDao.getTeacherJsonById(id);
    }

    public String getTeachersByName(String name) {
        return queryDao.getTeachersJsonByName(name);
    }

    public String getCourseById(int id) {
        return queryDao.getCourseJsonById(id);
    }

    public String getCoursesByName(String name) {
        return queryDao.getCoursesJsonByName(name);
    }


}
