package com.edu.mybatis.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class C3P0DataSourceFactory extends UnpooledDataSourceFactory {
    /**
     * C3P0与MyBatis兼容使用的数据源工常类
     */
    public C3P0DataSourceFactory(){
        this.dataSource = new ComboPooledDataSource();
    }
}
