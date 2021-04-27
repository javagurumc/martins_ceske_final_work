package lv.lu.martins.ceske.finalwork.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class H2Configuration {

    @Bean
    public DataSource dataSource(
            @Value("${datasource.initScript}") String initScript
    ) {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("FINAL_WORK")
                .addScript(initScript)
                .build();
    }

    @Bean
    public Properties hibernateProperties(
            @Value("${hibernate.show_sql}") Boolean showSql,
            @Value("${hibernate.hbm2ddl.auto}") String hbm2ddl,
            @Value("${hibernate.dialect}") String dialect
    ) {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
        properties.put("hibernate.dialect", dialect);
        return properties;
    }

    @Bean
    public SessionFactory sessionFactory(
            @Value("${hibernate.packagesToScan}") String packagesToScan,
            DataSource dataSource,
            Properties hibernateProperties) throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setPackagesToScan(packagesToScan);
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

}
