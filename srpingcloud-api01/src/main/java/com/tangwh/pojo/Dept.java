package com.tangwh.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


import java.io.Serializable;

/**
 * 实体类
 * 第一步 实现序列化
 */
@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //链式写法 :

public class Dept implements Serializable {
    /**
     * 链式写法
     * Dept dept = new Dept();
     *  dept.setDeptId(11).setDeptName("AAA").setdbSource('001');
     */


  // 类表关系映射
    private Integer dept_id; //主键
    private String dept_name; //名称

    // 这个数据库存在哪个数据库中的字段  一个服务对应一个数据库  同一个信息 可能存在不同的数据库
    private String db_source;

    public Dept(String dept_name) {
        this.dept_name = dept_name;
    }
}
