package co.jp.spring.usecasemib.service;

import co.jp.spring.usecasemib.mapper.master.ProjectMapper;
import co.jp.spring.usecasemib.mapper.primary.TargetMapper;
import co.jp.spring.usecasemib.model.Project;
import co.jp.spring.usecasemib.model.Target;
import java.util.Date;
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
    targetMapper.add(withCreatedAtUpdatedAt(target));
  }

  public void addAsTarget(String projectId) {
    Project project = projectMapper.findOne(projectId);
    Target target = new Target();
    if ((project != null) && (targetMapper.findOne(projectId) == null)) {
      target.setProjectId(project.getProjectId());
      target.setProjectName(project.getProjectName());
      target.setRegion(null);
      targetMapper.add(withCreatedAtUpdatedAt(target));
    }
  }

  public void update(Target target) {
    targetMapper.update(withUpdatedAt(target));
  }

  public void delete(String projectId) {
    targetMapper.delete(projectId);
  }

  // TODO: need to move common stuff to utils
  private Target withCreatedAtUpdatedAt(Target target) {
    Date now = new Date();
    target.setCreatedAt(now); // currently not UTC so needs refactor
    target.setUpdatedAt(now); // currently not UTC so needs refactor
    return target;
  }

  // TODO: need to move common stuff to utils
  private Target withUpdatedAt(Target target) {
    target.setUpdatedAt(new Date()); // currently not UTC so needs refactor
    return target;
  }
}
