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
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long usId;

  private String userId;

  private String userName;
  private String userPassword;
  private String userGender;
  private String userEmail;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private LocalDateTime userMakeDate;
  @UpdateTimestamp
  @Column(nullable = false)
  private LocalDateTime userFixDate;

  public User(String userId, String userName, String userPassword, String Gender, String userEmail) {

    this.userId = userId;
    this.userName = userName;
    this.userPassword = userPassword;
    this.userGender = userGender;
    this.userEmail = userEmail;
  }

}
