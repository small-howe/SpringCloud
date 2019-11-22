package com.tangwh.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration  //1.第一步 这个类对应的是原来的Xml
public class DruidConfig {
    //    绑定yml配置文件 属性
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    // 后台监控功能  固定代码 web.xml ServletRegistrationBean
    //因为SpringBoot 内置servlet 容器 所以没有web.xml 替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statisticsServlet() {

        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台需要有人登录  账号密码需要设置
        HashMap<String, String> initParameters = new HashMap<>();
        //loginUsername 是固定的  登录的key 是固定的
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");


        // 允许谁可以访问
        initParameters.put("allow", "");
        //禁止访问  initParameters.put("","192.168.91.128")


        bean.setInitParameters(initParameters);// 设置初始化参数

        return bean;
    }


    /**
     * 同上配置 过滤器
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        // 设置过滤器
        bean.setFilter(new WebStatFilter());
        // 可以过滤哪些请求？
        HashMap<String, String> initParameters = new HashMap<>();
        // 排除  这些东西不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/**");



        bean.setInitParameters(initParameters);
        return bean;
    }
}
