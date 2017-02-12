package com.zihua.service;

import com.zihua.dao.entityDao.*;
import com.zihua.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zihua on 17-1-26.
 */
@Service
public class OptService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private PermitDao permitDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private UserDao userDao;

    /**
     * 添加课程
     *
     * @param course
     * @return
     */
    public boolean addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    /**
     * 通过名字删除课程
     *
     * @param name
     * @return
     */
    public boolean deleteCourseByName(String name) {
        return courseDao.deleteCourseByName(name);
    }

    /**
     * 通过id删除课程
     *
     * @param id
     * @return
     */
    public boolean deleteCourseById(int id) {
        return courseDao.deleteCourseById(id);
    }

    /**
     * 查询所有课程
     *
     * @return
     */
    public List<Course> queryAllCourse() {
        return courseDao.queryAllCourse();
    }

    /**
     * 通过 id 查询课程
     *
     * @param id
     * @return
     */
    public Course queryCourseById(int id) {
        return courseDao.queryCourseById(id);
    }

    /**
     * 通过名字查询课程
     *
     * @param name
     * @return
     */
    public List<Course> queryCourseByName(String name) {
        return courseDao.queryCourseByName(name);
    }

    /**
     * @param permit
     * @return true 成功，false 失败
     */
    public boolean addPermit(Permit permit) {
        return permitDao.addPermit(permit);
    }

    /**
     * @param id
     * @return true 成功，false 失败
     */
    public boolean deletePermitById(int id) {
        return permitDao.deletePermitById(id);
    }

    /**
     * @param name
     * @return true 成功，false 失败
     */
    public boolean deletePermitByName(String name) {
        return permitDao.deletePermitByName(name);
    }

    /**
     * @return 返回所有权限
     */
    public List<Permit> queryAllPermit() {
        return permitDao.queryAll();
    }

    /**
     * 通过 id 查询权限
     *
     * @param id
     * @return
     */
    public Permit queryPermitById(int id) {
        return permitDao.queryPermitById(id);
    }

    /**
     * 通过名字查询权限
     *
     * @param name
     * @return
     */
    public List<Permit> queryPermitByName(String name) {
        return permitDao.queryPermitByName(name);
    }

    /**
     * @param role
     * @return true 成功, false 失败
     */
    public boolean addRole(Role role) {
        return roleDao.addRole(role);
    }

    /**
     * @param id
     * @return true 成功,false 失败
     */
    public boolean deleteRoleById(int id) {
        return roleDao.deleteRoleById(id);
    }

    /**
     * @param name
     * @return true 成功,false 失败
     */
    public boolean deleteRoleByName(String name) {
        return roleDao.deleteRoleByName(name);
    }

    /**
     * @return 返回所有角色
     */
    public List<Role> queryAllRole() {
        return roleDao.getALLRole();
    }

    /**
     * @param name
     * @return 返回一个角色
     */
    public List<Role> queryRoleByName(String name) {
        return roleDao.queryRoleByName(name);
    }

    /**
     * @param id
     * @return 返回一个角色
     */
    public Role queryRoleById(int id) {
        return roleDao.queryRoleById(id);
    }

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    /**
     * 通过名字删除学生
     *
     * @param name
     * @return
     */
    public boolean deleteStudentByName(String name) {
        return studentDao.deleteStudentByName(name);
    }

    /**
     * 通过id 删除学生
     *
     * @param id
     * @return
     */
    public boolean deleteStudentById(int id) {
        return studentDao.deleteStudentById(id);
    }

    /**
     * 返回所有学生
     *
     * @return
     */
    public List<Student> queryAllStudent() {
        return studentDao.queryAllStudent();
    }

    /**
     * 通过id 查询学生
     *
     * @param id
     * @return
     */
    public Student queryStudentById(int id) {
        return studentDao.queryStudentById(id);
    }

    /**
     * 通过名字查询学生
     *
     * @param name
     * @return
     */
    public List<Student> queryStudentByName(String name) {
        return studentDao.queryStudentByName(name);
    }

    /**
     * 添加老师
     *
     * @param teacher
     * @return
     */

    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    /**
     * 通过名字 删除老师
     *
     * @param name
     * @return
     */
    public boolean deleteTeacherByName(String name) {
        return teacherDao.deleteTeacherByName(name);
    }


    /**
     * 通过id 删除老师
     *
     * @param id
     * @return
     */
    public boolean deleteTeacherById(int id) {
        return teacherDao.deleteTeacherById(id);
    }

    /**
     * 查询所有老师
     *
     * @return
     */
    public List<Teacher> queryAllTeacher() {
        return teacherDao.queryAllTeacher();
    }

    /**
     * 通过id 查询老师
     *
     * @param id
     * @return
     */
    public Teacher queryTeacherById(int id) {
        return teacherDao.queryTeacherById(id);
    }

    /**
     * 通过名字查询老师
     *
     * @param name
     * @return
     */
    public List<Teacher> queryTeacherByName(String name) {
        return teacherDao.queryTeacherByName(name);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return boolean
     */
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    /**
     * 通过 id 删除用户
     *
     * @param id
     * @return boolean
     */
    public boolean deteleUserById(int id) {
        return userDao.deleteUserById(id);
    }

    /**
     * 通过名字删除用户
     *
     * @param name
     * @return boolean
     */
    public boolean deleteUserByName(String name) {
        return userDao.deleteUserByName(name);
    }

    /**
     * 通过 id 查询用户
     *
     * @param id
     * @return user
     */
    public User queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    /**
     * 通过名字查询用户
     *
     * @param name
     * @return user
     */
    public List<User> queryUserByName(String name) {
        return userDao.queryUserByName(name);
    }



}
