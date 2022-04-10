package co.jp.spring.usecasemib.batch;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@SpringBootApplication
public class HogeSeeder {
  @Value("${custom.property.seed.init}")
  private Boolean seedInit;

  public static void main(String[] args) {
    // java -cp target/usecasemib-0.0.1-SNAPSHOT.jar -Dloader.main=co.jp.spring.usecasemib.batch.HogeSeeder org.springframework.boot.loader.PropertiesLauncher
    System.out.println("multi springboot applications for batch requirements");
    SpringApplication app =
        new SpringApplication(HogeSeeder.class);
    app.setWebApplicationType(WebApplicationType.NONE);
    ConfigurableApplicationContext ctx = app.run(args);
    ctx.close();
  }

  @Bean
  public DataSourceInitializer dataSourceInitializer(
      @Qualifier("primaryDataSource") HikariDataSource dataSource) {
    if (seedInit) {
      ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
      resourceDatabasePopulator.addScript(new ClassPathResource("db/seed/hoge.sql"));
      resourceDatabasePopulator.setContinueOnError(true);
      DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
      dataSourceInitializer.setDataSource(dataSource);
      dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
      return dataSourceInitializer;
    } else {
      return null;
    }
  }
}
