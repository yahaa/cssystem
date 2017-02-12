package com.zihua.dao.entityDao;

import com.zihua.entity.Permit;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zihua on 17-1-24.
 * 权限 Permit dao
 * 对权限表 Permit 增删改查
 * addPermit boolean  g
 * deletePermitById boolean  g
 * deletePermitByName boolean g
 */
@Repository
public class PermitDao {
    @Resource
    private SessionFactory sessionFactory;

    @SuppressWarnings("unused")
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * @param permit
     * @return true 成功, false 失败
     */
    public boolean addPermit(Permit permit) {
        try {
            this.getSession().save(permit);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    /**
     * @param id
     * @return 返回布尔值
     */
    public boolean deletePermitById(int id) {
        int t = this.getSession().createQuery("delete from Permit where id=?")
                .setParameter(0, id)
                .executeUpdate();
        if (t > 0) return true;
        return false;

    }

    /**
     * @param name
     * @return 返回布尔值
     */
    public boolean deletePermitByName(String name) {
        int t = this.getSession().createQuery("delete from Permit where name=?")
                .setParameter(0, name)
                .executeUpdate();
        if (t > 0) return true;
        return false;
    }

    /**
     * @return 返回所有权限
     */
    public List<Permit> queryAll() {
        return this.getSession().createQuery("from Permit").list();
    }

    /**
     * 通过 id 查询 权限
     *
     * @param id
     */
    public Permit queryPermitById(int id) {
        Permit permit = (Permit) this.getSession().createQuery("from Permit where id=?")
                .setParameter(0, id).uniqueResult();
        return permit;

    }

    /**
     * 通过名字查询权限
     *
     * @param name
     * @return
     */
    public List<Permit> queryPermitByName(String name) {
        return this.getSession().createQuery("from Permit where name=?")
                .setParameter(0, name).list();
    }


}
