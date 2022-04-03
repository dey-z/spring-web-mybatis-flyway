package co.jp.spring.usecasemib.controller;

import co.jp.spring.usecasemib.dto.input.TargetParams;
import co.jp.spring.usecasemib.model.Target;
import co.jp.spring.usecasemib.service.TargetService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/targets")
public class TargetController {
  private final TargetService targetService;

  public TargetController(TargetService targetService) {
    this.targetService = targetService;
  }

  @GetMapping
  public ResponseEntity<List<Target>> getAllTargets() {
    return new ResponseEntity<>(targetService.findAll(), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Target> addTarget(@ModelAttribute @Validated TargetParams params) {
    Target newTarget = new Target();
    newTarget.setProjectId(params.getProjectId());
    newTarget.setProjectName(params.getProjectName());
    newTarget.setRegion(params.getRegion());
    targetService.add(newTarget);
    return new ResponseEntity<>(newTarget, HttpStatus.OK);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Target> updateTarget(@PathVariable("id") String id,
                                             @ModelAttribute Target target) {
    target.setProjectId(id);
    targetService.update(target);
    return new ResponseEntity<>(target, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteTarget(@PathVariable("id") String id) {
    targetService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
