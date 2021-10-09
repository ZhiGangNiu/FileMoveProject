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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = HWXTProjectDbConfig.PACKAGE, sqlSessionFactoryRef = "hwxtprojectSqlSessionFactory")
@SuppressWarnings("all")
public class HWXTProjectDbConfig {
    private Logger logger = LoggerFactory.getLogger(HWXTProjectDbConfig.class);
    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.backend.file.mapper.project";
    private static final String MAPPER_LOCATION = "classpath*:mapper/hwxtproject/*.xml";
    private static final String DOMAIN_PACKAGE = "com.backend.file.pojo";

    @Value("${spring.datasource.hwxtproject.url}")
    private String dbUrl;

    @Value("${spring.datasource.hwxtproject.username}")
    private String username;

    @Value("${spring.datasource.hwxtproject.password}")
    private String password;

    @Value("${spring.datasource.hwxtproject.driver-class-name}")
    private String driverClassName;


    @Bean(name = "hwxtprojectDataSource")   //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource hwxtprojectDataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        return datasource;
    }

    @Bean(name = "hwxtprojectTransactionManager")
    @Primary
    public DataSourceTransactionManager hwxtprojectTransactionManager() {
        return new DataSourceTransactionManager(hwxtprojectDataSource());
    }

    @Bean(name = "hwxtprojectSqlSessionFactory")
    @Primary
    public SqlSessionFactory hwxtprojectSqlSessionFactory(@Qualifier("hwxtprojectDataSource") DataSource hwxtprojectDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(hwxtprojectDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(HWXTProjectDbConfig.MAPPER_LOCATION));
        sessionFactory.setTypeAliasesPackage(DOMAIN_PACKAGE);
        //mybatis 数据库字段与实体类属性驼峰映射配置
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }
}