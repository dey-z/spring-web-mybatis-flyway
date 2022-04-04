package co.jp.spring.usecasemib.batch;

import co.jp.spring.usecasemib.service.TargetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "co.jp.spring.usecasemib")
public class Extraction {
  public static void main(String[] args) {
    // TODO:　this is just example,run the batch using following command after mvn clean compile
    // java -cp target/usecasemib-0.0.1-SNAPSHOT.jar -Dloader.main=co.jp.spring.usecasemib.batch.Extraction org.springframework.boot.loader.PropertiesLauncher
    System.out.println("multi springboot applications for batch requirements");
    SpringApplication app = new SpringApplication(Extraction.class);
    app.setWebApplicationType(WebApplicationType.NONE);
    ConfigurableApplicationContext ctx = app.run(args);
    TargetService targetService = ctx.getBean(TargetService.class);
    System.out.println(targetService.findAll());
    ctx.close();
  }
}
