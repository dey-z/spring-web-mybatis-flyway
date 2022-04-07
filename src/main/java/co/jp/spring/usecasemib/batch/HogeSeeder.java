package co.jp.spring.usecasemib.batch;

import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HogeSeeder {
  public static void main(String[] args) {
    // java -cp target/usecasemib-0.0.1-SNAPSHOT.jar -Dloader.main=co.jp.spring.usecasemib.batch.HogeSeeder org.springframework.boot.loader.PropertiesLauncher
    System.out.println("multi springboot applications for batch requirements");
    Properties props = new Properties();
    props.put("spring.sql.init.mode", "always");
    props.put("spring.sql.init.data-locations", "classpath:db/seed/hoge.sql");
    SpringApplication app =
        new SpringApplication(HogeSeeder.class);
    app.setWebApplicationType(WebApplicationType.NONE);
    app.setDefaultProperties(props);
    ConfigurableApplicationContext ctx = app.run(args);
    ctx.close();
  }
}
