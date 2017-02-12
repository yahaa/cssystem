package com.zihua.dao.entityDao;

import com.zihua.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.zihua.tools.Tools.*;

/**
 * Created by zihua on 17-1-25.
 */
@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unused")
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public boolean addUser(User user) {
        try {
            this.getSession().save(user);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    public boolean deleteUserByName(String name) {
        int t = this.getSession().createQuery("delete  from Role where name=?")
                .setParameter(0, name).executeUpdate();
        if (t > 0) return true;
        return false;
    }

    public boolean deleteUserById(int id) {
        int t = this.getSession().createQuery("delete from Role where id=?")
                .setParameter(0, id).executeUpdate();
        if (t > 0) return true;
        return false;
    }

    /**
     * 返回所有用户的json数据
     * @return
     */
    public String queryAllUser() {
        return getUserJson(this.getSession().createQuery("from User").list());
    }

    public User queryUserById(int id) {
        User user = (User) this.getSession().createQuery("from User where id=?")
                .setParameter(0, id).uniqueResult();
        return user;
    }

    public List<User> queryUserByName(String name) {
        return this.getSession().createQuery("from User where name=?")
                .setParameter(0, name).list();
    }
}
