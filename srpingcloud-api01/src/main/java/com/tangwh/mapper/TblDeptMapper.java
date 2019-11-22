package com.tangwh.mapper;

import com.tangwh.pojo.TblDept;

public interface TblDeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblDept record);

    int insertSelective(TblDept record);

    TblDept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblDept record);

    int updateByPrimaryKey(TblDept record);
}