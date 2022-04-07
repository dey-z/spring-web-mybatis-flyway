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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = PrimaryDbConfig.BASE_PACKAGES
    , sqlSessionTemplateRef = "primarySqlSessionTemplate")
public class PrimaryDbConfig {
  public static final String BASE_PACKAGES = "co.jp.spring.usecasemib.mapper.primary";
  public static final String MAPPER_XML_PATH =
      "classpath:co/jp/spring/usecasemib/mapper/primary/*.xml";

  @Value("${spring.datasource.driver-class-name}")
  private String driverClassName;

  @Value("${spring.datasource.url}")
  private String jdbcUrl;

  @Value("${spring.datasource.username}")
  private String username;

  @Value("${spring.datasource.password}")
  private String password;

  @Value("${spring.datasource.maximum-pool-size}")
  private Integer maxPoolSize;

  @Primary
  @Bean(name = "primaryDataSource")
  @ConfigurationProperties(prefix = "spring.datasource")
  public HikariDataSource dataSource() {
    final HikariDataSource ds = DataSourceBuilder
        .create()
        .driverClassName(driverClassName)
        .type(HikariDataSource.class)
        .url(jdbcUrl)
        .username(username)
        .password(password)
        .build();
    ds.setMaximumPoolSize(maxPoolSize);
    return ds;
  }

  @Primary
  @Bean(name = "primarySqlSessionFactory")
  public SqlSessionFactory sqlSessionFactory(
      @Qualifier("primaryDataSource") HikariDataSource primaryDataSource)
      throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(primaryDataSource);
    bean.setMapperLocations(
        new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_PATH));
    // custom Configs as we are customizing mybatis
    org.apache.ibatis.session.Configuration cfg =
        new org.apache.ibatis.session.Configuration();
    cfg.setMapUnderscoreToCamelCase(true);
    bean.setConfiguration(cfg);
    return bean.getObject();
  }

  @Bean(name = "primarySqlSessionTemplate")
  public SqlSessionTemplate sqlSessionTemplate(
      @Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
