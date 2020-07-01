package io.sejong.study.springbulletinboard.sample.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long boardId;

  private Long usId;
  private String boardTitle;
  private String boardContent;
  private Integer boardCount;
  private Integer boardPrivate;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private LocalDateTime boardMakeDate;

  @UpdateTimestamp
  @Column(nullable = false)
  private LocalDateTime boardFixDate;

  public Board(String boardTitle, Integer boardCount, String boardContent, Integer boardPrivate, Long usId) {
    this.usId = usId;
    this.boardTitle = boardTitle;
    this.boardCount = boardCount;
    this.boardContent = boardContent;
    this.boardPrivate = boardPrivate;
  }

}
