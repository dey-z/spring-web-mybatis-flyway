package co.jp.spring.usecasemib.mapper.master;

import co.jp.spring.usecasemib.model.Project;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProjectMapper {
  @Select("select * from V_PJ_Foo")
  List<Project> findAll();

  @Select("select * from V_PJ_Foo where ProjectId=#{projectId}")
  Project findOne(String projectId);
}
