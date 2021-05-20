package com.nzhao.service;

import com.nzhao.dao.OrgDao;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author 11507
 */
public class AdminService {
    public static void main(String[] args) {
        OrgDao orgDao = new OrgDao();
        Map<Integer, Set<Integer>> userOrgWhereFiled1 = orgDao.getUserOrgWhereFiled1();
        for (Integer key : userOrgWhereFiled1.keySet()) {
            System.out.println("key = "+key+" value = "+userOrgWhereFiled1.get(key).toString());
        }
    }
}
