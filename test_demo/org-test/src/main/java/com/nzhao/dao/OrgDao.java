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
            resultSet = BaseDao.excute(BaseDao.getConnection(), sql, resultSet, preparedStatement);
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

}
