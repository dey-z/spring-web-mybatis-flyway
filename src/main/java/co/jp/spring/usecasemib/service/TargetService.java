package co.jp.spring.usecasemib.service;

import co.jp.spring.usecasemib.mapper.primary.TargetMapper;
import co.jp.spring.usecasemib.model.Target;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TargetService {
  private final TargetMapper targetMapper;

  public TargetService(TargetMapper targetMapper) {
    this.targetMapper = targetMapper;
  }

  public List<Target> findAll() {
    return targetMapper.findAll();
  }

  public void add(Target target) {
    targetMapper.add(withCreatedAtUpdatedAt(target));
  }

  public void update(Target target) {
    targetMapper.update(withUpdatedAt(target));
  }

  public void delete(String projectId) {
    targetMapper.delete(projectId);
  }

  // TODO: need to move common stuff to utils
  private Target withCreatedAtUpdatedAt(Target target) {
    target.setCreatedAt(new Date()); // currently not UTC so needs refactor
    target.setUpdatedAt(new Date()); // currently not UTC so needs refactor
    return target;
  }

  // TODO: need to move common stuff to utils
  private Target withUpdatedAt(Target target) {
    target.setUpdatedAt(new Date()); // currently not UTC so needs refactor
    return target;
  }
}
