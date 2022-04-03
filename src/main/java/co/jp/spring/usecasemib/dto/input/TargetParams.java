package co.jp.spring.usecasemib.dto.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TargetParams {
  @NotNull
  private String projectId;
  @NotBlank
  private String projectName;
  @NotBlank
  private String region;
}
