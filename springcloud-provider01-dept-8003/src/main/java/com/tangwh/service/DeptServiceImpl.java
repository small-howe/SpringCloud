package com.tangwh.service;

import com.tangwh.mapper.DeptMapper;
import com.tangwh.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {


    @Autowired
    DeptMapper deptMapper;


    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept queryById(Integer deptId) {
        return deptMapper.queryById(deptId);
    }

    @Override
    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }
}
