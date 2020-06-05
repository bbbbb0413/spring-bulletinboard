package io.sejong.study.springbulletinboard.sample.http.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardUpdateRequest {
  private Long boardId;
  private Long usId;
  private String boardTitle;
  private String boardContent;
  private Integer boardCount;
  private Integer boardPrivate;

}
