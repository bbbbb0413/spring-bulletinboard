package io.sejong.study.springbulletinboard.sample.http.req;

import io.sejong.study.springbulletinboard.sample.entity.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyCreateRequest {

  private Long usId;
  private String replyWriter;
  private String replyContent;
  private Board board;


}
