package io.sejong.study.springbulletinboard.sample.http.req;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleCreateRequest {
  private String name;
  private Integer age;
  private LocalDateTime birthday;
  private String address;


}
