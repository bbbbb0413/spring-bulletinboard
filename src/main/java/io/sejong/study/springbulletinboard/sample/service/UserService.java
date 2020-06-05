package io.sejong.study.springbulletinboard.sample.service;

import io.sejong.study.springbulletinboard.sample.entity.User;
import io.sejong.study.springbulletinboard.sample.http.req.UserCreateRequest;
import io.sejong.study.springbulletinboard.sample.http.req.SampleUpdateRequest;
import io.sejong.study.springbulletinboard.sample.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;

  /** 생성자 의존관계 주입(DI, AOP 알아보기) 이외에도 @Autowired를 이용한 필드주입, setter 주입이 있다. */
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getOneByUsId(Long usId) {

    return userRepository.findByUsId(usId);
  }

  public User createUser(UserCreateRequest request) {
    User user =
        new User(
            request.getUserId(), request.getUserPassword(), request.getUserName(), request.getUserGender(), request.getUserEmail());

    return userRepository.save(user);
  }
//
//  public Sample updateSample(SampleUpdateRequest request) {
//    Sample sample = sampleRepository.findBySampleId(request.getSampleId());
//    sample.setName(request.getName());
//    sample.setAge(request.getAge());
//    sample.setBirthday(request.getBirthday());
//    sample.setAddress(request.getAddress());
//
//    return sampleRepository.save(sample);
//  }
//
//  public void deleteSample(Long sampleId) {
//    sampleRepository.deleteById(sampleId);
//  }
}
