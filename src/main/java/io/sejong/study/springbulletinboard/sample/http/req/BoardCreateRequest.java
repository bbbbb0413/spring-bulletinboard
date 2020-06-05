package io.sejong.study.springbulletinboard.sample.http.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCreateRequest {

  private Long usId;
  private String boardTitle;
  private String boardContent;
  private Integer boardCount = 0;
  private Integer boardPrivate = 0;

}
