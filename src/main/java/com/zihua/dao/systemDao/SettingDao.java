package com.zihua.dao.systemDao;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by zihua on 17-1-27.
 */
@Repository
public class SettingDao {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unused")
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 给用户设定角色
     *
     * @param userId
     * @param roleId
     * @return
     */
    public boolean addRoleToUser(int userId, int roleId) {
        try {
            this.getSession().createSQLQuery("insert into user_role(user_id,role_id) " +
                    "value(?,?)").setParameter(0, userId).setParameter(1, roleId).executeUpdate();
            return true;
        } catch (HandlerException e) {
            return false;
        }
    }



    /**
     * 删除用户的角色
     *
     * @param userId
     * @param roldId
     * @return
     */
    public boolean deleteUserOfRole(int userId, int roldId) {
        try {
            this.getSession().createSQLQuery("delete from user_role where user_id=? and role_id=?")
                    .setParameter(0, userId).setParameter(1, roldId).executeUpdate();
            return true;
        } catch (HandlerException e) {
            return false;
        }
    }

    /**
     * 给角色设定权限
     *
     * @param roleId
     * @param permitId
     * @return 返回是否成功
     */
    public boolean addPermitToRole(int roleId, int permitId) {
        try {
            this.getSession().createSQLQuery("insert into role_permit(role_id,permit_id) " +
                    "value(?,?)").setParameter(0, roleId).setParameter(1, permitId).executeUpdate();
            return true;
        } catch (HandlerException e) {
            return false;
        }
    }

    /**
     * 删除角色的权限
     *
     * @param roleId
     * @param permitId
     * @return 返回是否成功
     */
    public boolean deleteRoleOfPermit(int roleId, int permitId) {
        try {
            this.getSession().createSQLQuery("delete from role_permit where role_id=? and permit_id=?")
                    .setParameter(0, roleId).setParameter(1, permitId).executeUpdate();
            return true;
        } catch (HandlerException e) {
            return false;
        }
    }


}
