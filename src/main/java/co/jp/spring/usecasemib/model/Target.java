package co.jp.spring.usecasemib.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Target implements Serializable {
  private String projectId;
  private String projectName;
  private String region;
  private Date createdAt;
  private Date updatedAt;
}
