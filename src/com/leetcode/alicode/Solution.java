package com.leetcode.alicode;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author maocg
 * Date：2018/3/27
 * Description：TODO
 */
public class Solution {
    List<User> users = new ArrayList<User>();
    Map<String, User> userIdMap = new HashMap<String, User>();
    private static final String parteen = "+";

    public List<User> findUserByCondition(Map<String, String> params, List<User> data) {
        if (data == null) {
            return null;
        }
        if (params == null || params.size() == 0) {
            return data;
        }
        Map<String, HashSet> indexs = createIndex(data);

        HashSet<String> ids = new HashSet<String>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            String key = param.getKey();
            String value = param.getValue();
            //找到所有ids
        }

        findUserByIds(ids);

        return null;
    }

    public List<User> findUserByIds(HashSet<String> ids) {
        Iterator it = ids.iterator();
        List<User> users = new ArrayList<User>();
        while (it.hasNext()) {
            String id = (String) it.next();
            User u = userIdMap.get(id);
            users.add(u);
        }
        return users;
    }

    /**
     * 根据user信息创建多纬度的索引，公司名，工号，国家，城市，地区，
     * 利用hashmap查找时0（1）的时间复杂度提高效率
     * Map<String,HashSet>，String存key，hashset存对应的userid列表
     * 少了还有userid和数据对应的一个索引
     *
     * @param users
     * @return
     */
    private Map<String, HashSet> createIndex(List<User> users) {
        if (users == null || users.size() == 0) {
            return null;
        }
        Map<String, HashSet> index = new HashMap<String, HashSet>();
        HashSet addressSet = new HashSet();
        HashSet companyNameSet = new HashSet();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            HashSet set = new HashSet();
            String[] address = user.getAddress().split(parteen);
            String[] companyName = user.getAddress().split(parteen);
            for (int j = 0; j < address.length; j++) {
                set.add(user.getUserId());
                index.put(address[i], set);
            }
            for (int k = 0; k < companyName.length; k++) {
                set.add(user.getUserId());
                index.put(companyName[i], set);
            }
        }
        return index;
    }

    public Map<String, User> createUserIdMap(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            userIdMap.put(user.getUserId(), user);
        }
        return userIdMap;
    }

    @Before
    public List<User> createFakeData(List<User> data) {
        for (int i = 0; i < users.size(); i++) {
            //构造数据
        }
        return users;
    }

    @Test
    public void testFindUserByCondition() {

    }


}

class User {
    private String UserId;
    /**
     * 公司名称有两个纬度，名称+工号
     */
    private String CompanyName;
    /**
     * 地址有三个纬度，国家+城市+区域
     */
    private String Address;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}