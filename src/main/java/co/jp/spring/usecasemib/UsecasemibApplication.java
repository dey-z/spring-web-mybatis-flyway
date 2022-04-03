package co.jp.spring.usecasemib;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("co.jp.spring.usecasemib")
@SpringBootApplication
public class UsecasemibApplication {
  public static void main(String[] args) {
    SpringApplication.run(UsecasemibApplication.class, args);
  }
}
