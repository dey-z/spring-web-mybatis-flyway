package co.jp.spring.usecasemib.mapper;

import co.jp.spring.usecasemib.model.Target;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TargetMapper {
  List<Target> findAll();

  void add(Target target);

  void update(Target target);

  void delete(String projecId);
}
