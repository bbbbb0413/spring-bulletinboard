package io.sejong.study.springbulletinboard.sample.repository;

import io.sejong.study.springbulletinboard.sample.entity.Sample;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Long> {
  List<Sample> findAll();


  Sample findBySampleId(Long sampleId);

}
