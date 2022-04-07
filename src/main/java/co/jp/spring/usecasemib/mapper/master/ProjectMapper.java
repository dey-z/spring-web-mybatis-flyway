package co.jp.spring.usecasemib.mapper.master;

import co.jp.spring.usecasemib.model.Project;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

  private final SqlSession sqlSession;
  private final SqlSessionFactory sqlSessionFactory;

  public ProjectMapper(
      @Qualifier("masterSqlSessionTemplate") SqlSession sqlSession,
      @Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
    this.sqlSession = sqlSession;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Project> findAll() {
//    BoundSql boundSql =
//        this.sqlSessionFactory.getConfiguration().getMappedStatement("findAll").getBoundSql(null);
//    System.out.println("Executed SQL" + System.lineSeparator() + boundSql.getSql());
    return this.sqlSession.selectList("findAll");
  }

  public Project findOne(String projectId) {
//    BoundSql boundSql =
//        this.sqlSessionFactory.getConfiguration().getMappedStatement("findOne")
//            .getBoundSql(projectId);
//    System.out.println("Executed SQL" + System.lineSeparator() + boundSql.getSql());
    return this.sqlSession.selectOne("findOne", projectId);
  }
}
