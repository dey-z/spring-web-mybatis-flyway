package co.jp.spring.usecasemib.service;

import co.jp.spring.usecasemib.mapper.master.ProjectMapper;
import co.jp.spring.usecasemib.mapper.primary.TargetMapper;
import co.jp.spring.usecasemib.model.Project;
import co.jp.spring.usecasemib.model.Target;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TargetService {
  private final TargetMapper targetMapper;

  private final ProjectMapper projectMapper;

  public TargetService(TargetMapper targetMapper,
                       ProjectMapper projectMapper) {
    this.targetMapper = targetMapper;
    this.projectMapper = projectMapper;
  }

  public List<Target> findAll() {
    return targetMapper.findAll();
  }

  public List<Project> findAllFromMaster() {
    return projectMapper.findAll();
  }

  public void add(Target target) {
    targetMapper.add(target);
  }

  public void addAsTarget(String projectId) {
    Project project = projectMapper.findOne(projectId);
    Target target = new Target();
    if ((project != null) && (targetMapper.findOne(projectId) == null)) {
      target.setProjectId(project.getProjectId());
      target.setProjectName(project.getProjectName());
      target.setRegion(null);
      targetMapper.add(target);
    }
  }

  public void update(Target target) {
    targetMapper.update(target);
  }

  public void delete(String projectId) {
    targetMapper.delete(projectId);
  }
}
