package com.backend.file.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 从数据源配置
 * 若需要配置更多数据源 , 直接在yml中添加数据源配置再增加相应的新的数据源配置类即可
 */
@Configuration
@MapperScan(basePackages = HWXTLogDbConfig.PACKAGE, sqlSessionFactoryRef = "hwxtLogSqlSessionFactory")
@SuppressWarnings("all")
public class HWXTLogDbConfig {
    private Logger logger = LoggerFactory.getLogger(HWXTLogDbConfig.class);
    // 精确到 hwxtLog 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.backend.file.mapper.log";
    private static final String MAPPER_LOCATION = "classpath*:mapper/hwxtlog/*.xml";
    private static final String DOMAIN_PACKAGE = "com.backend.file.pojo";

    @Value("${spring.datasource.hwxtlog.url}")
    private String dbUrl;

    @Value("${spring.datasource.hwxtlog.username}")
    private String username;

    @Value("${spring.datasource.hwxtlog.password}")
    private String password;

    @Value("${spring.datasource.hwxtlog.driver-class-name}")
    private String driverClassName;


    @Bean(name = "hwxtLogDataSource")   //声明其为Bean实例
    public DataSource hwxtLogDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        return datasource;
    }

    @Bean(name = "hwxtLogTransactionManager")
    public DataSourceTransactionManager hwxtLogTransactionManager() {
        return new DataSourceTransactionManager(hwxtLogDataSource());
    }

    @Bean(name = "hwxtLogSqlSessionFactory")
    public SqlSessionFactory hwxtLogSqlSessionFactory(@Qualifier("hwxtLogDataSource") DataSource hwxtLogDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(hwxtLogDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(HWXTLogDbConfig.MAPPER_LOCATION));
        sessionFactory.setTypeAliasesPackage(DOMAIN_PACKAGE);
        //mybatis 数据库字段与实体类属性驼峰映射配置
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }
}