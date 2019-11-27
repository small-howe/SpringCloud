package com.tangwh.mapper;

import com.tangwh.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
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


    /**
     * 查询所有
     * @return
     */
    public List<Dept> queryAll();
}
