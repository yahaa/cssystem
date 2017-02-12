package com.zihua.dao.entityDao;

import com.zihua.entity.Teacher;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zihua on 17-1-25.
 */
@Repository
public class TeacherDao {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unused")
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public boolean addTeacher(Teacher teacher) {
        try {
            this.getSession().save(teacher);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    public boolean deleteTeacherByName(String name) {
        int t = this.getSession().createQuery("delete  from Teacher where name=?")
                .setParameter(0, name).executeUpdate();
        if (t > 0) return true;
        return false;
    }

    public boolean deleteTeacherById(int id) {
        int t = this.getSession().createQuery("delete from Teacher where id=?")
                .setParameter(0, id).executeUpdate();
        if (t > 0) return true;
        return false;
    }

    public List<Teacher> queryAllTeacher() {
        return this.getSession().createQuery("from Teacher").list();
    }

    public Teacher queryTeacherById(int id) {
        Teacher teacher = (Teacher) this.getSession().createQuery("from Teacher where id=?")
                .setParameter(0, id).uniqueResult();
        return teacher;
    }

    public List<Teacher> queryTeacherByName(String name) {
        return this.getSession().createQuery("from Teacher where name=?")
                .setParameter(0, name).list();
    }
}
