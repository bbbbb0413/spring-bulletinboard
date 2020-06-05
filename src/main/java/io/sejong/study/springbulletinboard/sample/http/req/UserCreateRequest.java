package io.sejong.study.springbulletinboard.sample.http.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {

  private String userId;
  private String userName;
  private String userPassword;
  private String userGender;
  private String userEmail;
}
