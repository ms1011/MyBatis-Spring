package com.ohgiraffers.mybatisspring.config;

import com.ohgiraffers.mybatisspring.section01.factorybean.MenuMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class MybatisConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.jdbc-url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        /* 설명. 데이터베이스에 연결을 시도할 때 타임아웃 값을 설정(연결 시도 가능시간 설정) */
        dataSource.setConnectionTimeout(30000);     // 30초
        
        /* 설명. 데이터베이스 연결이 유휴상태로 유지될 수 있는 최대 시간 설정(쿼리를 보내거나 데이터를 업데이트 하지 않는 시간) */
        dataSource.setIdleTimeout(600000);          // 10분

        /* 설명. 데이터베이스 연결이 최대로 유지될 수 있는 시간 설정 */
        dataSource.setMaxLifetime(1800000);         // 30분

        /* 설명. 미리 준비하는 커넥션 풀 설정 */
        dataSource.setMaximumPoolSize(50);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        org.apache.ibatis.session.Configuration configuration
                = new org.apache.ibatis.session.Configuration();
        configuration.addMapper(MenuMapper.class);

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());        // 접속 할 DB 정보
        factoryBean.setConfiguration(configuration);    // 활용할 mapper 정보(쿼리 정보)

        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }
}
