package io.sejong.study.springbulletinboard.sample.http.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyCreateRequest {

  private Long usId;
  private String replyWriter;
  private String replyContent;
  private Long board_id;

}
