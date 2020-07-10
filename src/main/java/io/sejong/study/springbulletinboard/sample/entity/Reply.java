package io.sejong.study.springbulletinboard.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Reply {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long replyId;

  private Long usId;

  @ManyToOne
  @JoinColumn(name="board_id")
  private Board board;

  private String replyWriter;
  private String replyContent;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private LocalDateTime replyMakeDate;

  @UpdateTimestamp
  @Column(nullable = false)
  private LocalDateTime replyFixDate;

  public Reply(Board board, String replyWriter, String replyContent, Long usId) {
    this.usId = usId; // 로그인 한 사용자의 usId
    this.board = board; // 댓글이 작성된 게시글의 Id
    this.replyWriter = replyWriter; // 로그인 한 사용자의 이름을 사용할 예정
    this.replyContent = replyContent; // 게시글 내용

  }


}
