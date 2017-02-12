package com.zihua.dao.entityDao;

import com.zihua.entity.Course;
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
public class CourseDao {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unused")
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public boolean addCourse(Course course) {
        try {
            this.getSession().save(course);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    public boolean deleteCourseByName(String name) {
        int t = this.getSession().createQuery("delete  from Course where name=?")
                .setParameter(0, name).executeUpdate();
        if (t > 0) return true;
        return false;
    }

    public boolean deleteCourseById(int id) {
        int t = this.getSession().createQuery("delete from Course where id=?")
                .setParameter(0, id).executeUpdate();
        if (t > 0) return true;
        return false;
    }

    public List<Course> queryAllCourse() {
        return this.getSession().createQuery("from Course").list();
    }

    public Course queryCourseById(int id) {
        Course course = (Course) this.getSession().createQuery("from Course where id=?")
                .setParameter(0, id).uniqueResult();
        return course;
    }

    public List<Course> queryCourseByName(String name) {
        return this.getSession().createQuery("from Course where name=?")
                .setParameter(0, name).list();
    }


}
