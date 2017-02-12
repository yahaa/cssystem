package com.zihua.dao.systemDao;

import com.zihua.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.zihua.tools.Tools.*;

/**
 * Created by zihua on 17-1-26.
 */
@Repository
public class QueryDao {
    @Autowired
    private SessionFactory sessionFactory;


    @SuppressWarnings("unused")
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * @param id 通过id 查询用户的 信息
     * @return 返回json 格式数据
     */
    public String getUserJsonById(int id) {
        User u = this.getSession().get(User.class, id);
        return getUserJson(u);
    }


    /**
     * @param id
     * @return 返回角色json 格式的信息
     */
    public String getRoleJsonById(int id) {

        Role role = this.getSession().get(Role.class, id);
        return getRoleJson(role);
    }


    /**
     * @param userId 通过id 获取用户的所有权限
     * @return 返回json 格式数据
     */
    public String getUserOfPermitJsonById(int userId) {
        List<Integer> roleIds = this.getSession().createSQLQuery("select role_id from " +
                "user_role where user_id=?").setParameter(0, userId).list();
        Set<Permit> permits = new HashSet<Permit>();
        for (Integer i : roleIds) {
            Role t = this.getSession().get(Role.class, i);
            permits.addAll(t.getPermits());
        }
        return getPermitJson(permits);
    }

    /**
     * @param userId 通过 id 获取用户的角色
     * @return 返回json 格式数据
     */
    public String getUserOfRoleJsonById(int userId) {
        User t = this.getSession().get(User.class, userId);
        return getRoleJson(t.getRoles());
    }

    /**
     * 检查用户是否存在
     *
     * @param userId
     * @param password
     * @return
     */
    public boolean checkUserExist(int userId, String password) {
        password = md5(password);
        User t = this.getSession().get(User.class, userId);
        if (t != null) {
            System.out.println("llll");
            createRolesInstance(t);
        }
        if (t == null) return false;
        if (!t.getPassword().equals(password)) return false;
        return true;
    }


    /**
     * 创建用户对应的角色的实例
     *
     * @param user
     * @return
     */
    public boolean createRolesInstance(User user) {
        Set<Role> roles = user.getRoles();
        int userId = user.getId();
        String name = user.getName();
        for (Role a : roles) {
            int roleId = a.getId();
            String table = null;
            //写死了,后期维护再修改
            if (roleId == 1) {
                continue;
            } else if (roleId == 2) {
                table = "Teacher";
            } else if (roleId == 3) {
                table = "Student";
            }
            if (table == null) continue;
            if (canFindInTable(userId, table)) continue;
            insertIntoTable(table, userId, name);
        }
        return true;
    }

    /**
     * 用 SQL 语句往 table表 插入 数据
     *
     * @param table
     * @param userId
     * @param name
     */
    public void insertIntoTable(String table, int userId, String name) {
        this.getSession().createSQLQuery("insert into " + table + " value(?,?)")
                .setParameter(0, userId).setParameter(1, name).executeUpdate();
    }

    /**
     * 否能在table 中 找到 id的对象
     *
     * @param id
     * @param table
     * @return
     */
    public boolean canFindInTable(int id, String table) {
        Object object = null;
        if (table.equals("Student")) {
            object = this.getSession().get(Student.class, id);
        } else {
            object = this.getSession().get(Teacher.class, id);
        }
        if (object == null) return false;
        return true;
    }

    /**
     * 获取获取教师，包括教师开的所有课程的json 数据
     *
     * @param teacherId
     * @return
     */
    public String getTeacherJsonById(int teacherId) {
        Teacher teacher = this.getSession().get(Teacher.class, teacherId);
        return getTeacherJson(teacher);
    }

    /**
     * 通过名字查询老师，可能有多个同名教师
     *
     * @param teacherName
     * @return
     */
    public String getTeachersJsonByName(String teacherName) {
        Query query = this.getSession().createQuery("from Teacher where name=?")
                .setParameter(0, teacherName);
        return getTeacherJson(query.list());
    }

    /**
     * 获取课程，包括课程所对应的教师的json数据
     *
     * @param courseId
     * @return
     */
    public String getCourseJsonById(int courseId) {
        Course course = this.getSession().get(Course.class, courseId);
        return getCourseJson(course);
    }

    /**
     * 获取课程json
     *
     * @param courseName
     * @return
     */
    public String getCoursesJsonByName(String courseName) {
        Query query = this.getSession().createQuery("from Course where name=?")
                .setParameter(0, courseName);
        return getCourseJson(query.list());
    }

    public String queryCourse(String courseId, String teacherId, String courseName, String teacherName) {
        courseId = delespace(courseId);
        teacherId = delespace(teacherId);
        courseName = delespace(courseName);
        teacherName = delespace(teacherName);
        if (courseId.length() > 0) {
            try {
                int id = Integer.valueOf(courseId);
                return getCourseJsonById(id);
            } catch (Exception e) {

            }
        }

        if (courseName.length() > 0) {
            return getCoursesJsonByName(courseName);
        }
        return "";
    }


}
