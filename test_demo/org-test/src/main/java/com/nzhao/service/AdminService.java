package com.nzhao.service;

import com.nzhao.dao.OrgDao;

import java.util.HashMap;
import java.util.HashSet;
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

        System.out.println("------获取Map<站点 Set<人员>> 关系");
        Map<Integer, Set<Integer>> siteIdWithUserIds = new HashMap<>();
        for (Integer orgId : userOrgWhereFiled1.keySet()) {
            // 获取orgId对应的siteId
            Integer siteId = orgDao.getSiteIdWithOrgId(orgId);
            if (siteId == null){
                String orgPath = orgDao.getOrgPath(orgId);
                String[] split = orgPath.split("/");
                for (int i = split.length - 1; i >= 0; i--) {
                    int tempOrgId = Integer.parseInt(split[i]);
                    siteId = orgDao.getSiteIdWithOrgId(tempOrgId);
                    if(siteId != null){
                        break;
                    }
                }
            }
            Set<Integer> userIds = siteIdWithUserIds.containsKey(siteId) ? siteIdWithUserIds.get(siteId) : new HashSet<>();
            userIds.addAll(userOrgWhereFiled1.get(orgId));
            siteIdWithUserIds.put(siteId,userIds);
        }

        for (Integer key : siteIdWithUserIds.keySet()) {
            System.out.println("key = "+key+" value = "+siteIdWithUserIds.get(key).toString());
        }
    }
}
