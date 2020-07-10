package io.sejong.study.springbulletinboard.sample.repository;

import io.sejong.study.springbulletinboard.sample.entity.Board;
import io.sejong.study.springbulletinboard.sample.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {


  List<Reply> findAll();
  Reply findByReplyId(Long replyId);

}
