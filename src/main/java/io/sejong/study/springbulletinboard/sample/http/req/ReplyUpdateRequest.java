package io.sejong.study.springbulletinboard.sample.http.req;

import io.sejong.study.springbulletinboard.sample.entity.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyUpdateRequest {
  private Long replyId;
  private Long usId;
  private String replyWriter;
  private String replyContent;
  private Board board;
}
