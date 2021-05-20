package com.nzhao.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 11507
 */
public class OrgDao {
    public Map<Integer, Set<Integer>> getUserOrgWhereFiled1(){
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        String sql = "SELECT ou.OrgId, ou.UserId FROM t_user u JOIN t_orguser ou ON u.id = ou.UserId WHERE u.Field1='1'";
        try {
            resultSet = BaseDao.execute(BaseDao.getConnection(), sql, resultSet, preparedStatement);
            while (resultSet !=null && resultSet.next()) {
                int orgId = resultSet.getInt("OrgId");
                int userId = resultSet.getInt("UserId");
                Set<Integer> userIds = map.containsKey(orgId) ? map.get(orgId) : new HashSet<Integer>();
                userIds.add(userId);
                map.put(orgId,userIds);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Integer getSiteIdWithOrgId(Integer orgId){
        String sql = "SELECT siteId FROM T_SITEAUTH_ORG WHERE orgId = ? ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer siteId = null;
        Object[] params = {orgId};
        try{
            resultSet = BaseDao.execute(BaseDao.getConnection(),sql,params,resultSet,preparedStatement);
            while (resultSet !=null && resultSet.next()) {
                siteId = resultSet.getInt("siteid");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return siteId;
    }

    public String getOrgPath(Integer orgId){
        String sql = "SELECT path FROM t_org WHERE id = ? ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String path = null;
        try{
            resultSet = BaseDao.execute(BaseDao.getConnection(),sql,new Object[]{orgId},resultSet,preparedStatement);
            while (resultSet !=null && resultSet.next()) {
                path = resultSet.getString("path");
                // 默认只能得到一个值
                break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return path;
    }



}
