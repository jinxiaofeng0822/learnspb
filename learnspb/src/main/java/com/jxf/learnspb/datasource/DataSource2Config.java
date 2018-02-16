package com.jxf.learnspb.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.jxf.learnspb.dao.mapper.spb2", sqlSessionTemplateRef  = "spb2SqlSessionTemplate")
public class DataSource2Config {

    @Bean(name = "spb2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.spb2")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "spb2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("spb2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mappers/ds2/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "spb2TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("spb2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "spb2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("spb2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
