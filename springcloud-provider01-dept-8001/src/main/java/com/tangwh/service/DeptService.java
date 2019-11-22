package com.tangwh.service;

import com.tangwh.pojo.Dept;


import java.util.List;


public interface DeptService {

    /**
     * 增加
     * @param dept
     * @return
     */
    public  boolean addDept(Dept dept);

    /**
     * 通过部门Id 查询部门信息
     * @param deptId
     * @return
     */
    public Dept queryById(Integer deptId);



    public List<Dept> queryAll();
}
