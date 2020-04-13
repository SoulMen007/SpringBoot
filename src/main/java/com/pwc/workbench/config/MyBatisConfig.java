package com.pwc.workbench.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageHelper;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan
public class MyBatisConfig {
	
	@Autowired
    private DataSource dataSource;
	
    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;
    
    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;
    
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(applicationContext.getResources(mapperLocations));
        sessionFactory.setTypeAliasesPackage(typeAliasesPackage);
        Interceptor[] plugins =  new Interceptor[]{pageHelper()};
        sessionFactory.setPlugins(plugins);
        return sessionFactory;
    }
    
    private PageHelper pageHelper(){
        PageHelper ph=new PageHelper();
        Properties pr=new Properties();
        pr.setProperty("dialect", "postgresql");
        ph.setProperties(pr);
        return ph;
    }
	

}
