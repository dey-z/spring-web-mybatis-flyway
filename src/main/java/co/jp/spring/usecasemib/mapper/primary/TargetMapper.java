package co.jp.spring.usecasemib.mapper.primary;

import co.jp.spring.usecasemib.model.Target;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TargetMapper {
  List<Target> findAll();

  Target findOne(String projectId);

  void add(Target target);

  void update(Target target);

  void delete(String projecId);
}
