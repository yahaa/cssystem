package com.zihua.dao.entityDao;

import com.sun.xml.internal.ws.handler.HandlerException;
import com.zihua.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zihua on 17-1-25.
 */
@Repository
public class RoleDao {
    @Resource
    private SessionFactory sessionFactory;

    @SuppressWarnings("unused")
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public boolean addRole(Role role) {
        try {
            this.getSession().save(role);
            return true;
        } catch (HandlerException e) {
            return false;
        }

    }

    public boolean deleteRoleByName(String name) {
        int t = this.getSession().createQuery("delete from Role where name=?")
                .setParameter(0, name).executeUpdate();
        if (t <= 0) return false;
        return true;
    }

    public boolean deleteRoleById(int id) {
        int t = this.getSession().createQuery("delete from Role where id=?")
                .setParameter(0, id).executeUpdate();
        if (t <= 0) return false;
        return true;
    }

    public List<Role> getALLRole() {
        return this.getSession().createQuery("from Role").list();
    }

    public List<Role> queryRoleByName(String name) {
        return this.getSession().createQuery("from Role where name=?")
                .setParameter(0, name).list();
    }

    public Role queryRoleById(int id) {
        Role role = (Role) this.getSession().createQuery("from Role where id=?")
                .setParameter(0, id).uniqueResult();
        return role;
    }


}
