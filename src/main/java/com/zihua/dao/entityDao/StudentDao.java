package com.zihua.dao.entityDao;

import com.zihua.entity.Student;
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
public class StudentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unused")
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public boolean addStudent(Student student) {
        try {
            this.getSession().save(student);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    public boolean deleteStudentByName(String name) {
        int t = this.getSession().createQuery("delete  from Student where name=?")
                .setParameter(0, name).executeUpdate();
        if (t > 0) return true;
        return false;
    }

    public boolean deleteStudentById(int id) {
        int t = this.getSession().createQuery("delete from Student where id=?")
                .setParameter(0, id).executeUpdate();
        if (t > 0) return true;
        return false;
    }

    public List<Student> queryAllStudent() {
        return this.getSession().createQuery("from Student").list();
    }

    public Student queryStudentById(int id) {
        Student student = (Student) this.getSession().createQuery("from Student where id=?")
                .setParameter(0, id).uniqueResult();
        return student;
    }

    public List<Student> queryStudentByName(String name) {
        return this.getSession().createQuery("from Student where name=?")
                .setParameter(0, name).list();

    }
}
