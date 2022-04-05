package co.jp.spring.usecasemib.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = MasterDbConfig.BASE_PACKAGES
    , sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MasterDbConfig {
  public static final String BASE_PACKAGES = "co.jp.spring.usecasemib.mapper.master";
  public static final String MAPPER_XML_PATH =
      "classpath:co/jp/spring/usecasemib/mapper/master/*.xml";

  @Value("${spring.master-datasource.driver-class-name}")
  private String driverClassName;

  @Value("${spring.master-datasource.jdbc-url}")
  private String jdbcUrl;

  @Value("${spring.master-datasource.username}")
  private String username;

  @Value("${spring.master-datasource.password}")
  private String password;


  @Bean(name = "masterDataSource")
  @ConfigurationProperties(prefix = "spring.master-datasource")
  public HikariDataSource dataSource() {
    return DataSourceBuilder
        .create()
        .driverClassName(driverClassName)
        .type(HikariDataSource.class)
        .url(jdbcUrl)
        .username(username)
        .password(password)
        .build();
  }

  @Bean(name = "masterSqlSessionFactory")
  public SqlSessionFactory sqlSessionFactory(
      @Qualifier("masterDataSource") HikariDataSource masterDataSource)
      throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(masterDataSource);
    bean.setMapperLocations(
        new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_PATH));
    // custom Configs as we are customizing mybatis
    org.apache.ibatis.session.Configuration cfg =
        new org.apache.ibatis.session.Configuration();
    cfg.setMapUnderscoreToCamelCase(true);
    bean.setConfiguration(cfg);
    return bean.getObject();
  }

  @Bean(name = "masterSqlSessionTemplate")
  public SqlSessionTemplate sqlSessionTemplate(
      @Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
