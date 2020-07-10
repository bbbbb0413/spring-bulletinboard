package io.sejong.study.springbulletinboard.sample.service;

import io.sejong.study.springbulletinboard.sample.entity.Reply;
import io.sejong.study.springbulletinboard.sample.http.req.ReplyCreateRequest;
import io.sejong.study.springbulletinboard.sample.http.req.ReplyUpdateRequest;
import io.sejong.study.springbulletinboard.sample.repository.ReplyRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReplyService {

  private final ReplyRepository replyRepository;

  /** 생성자 의존관계 주입(DI, AOP 알아보기) 이외에도 @Autowired를 이용한 필드주입, setter 주입이 있다. */
  public ReplyService(ReplyRepository replyRepository) {

    this.replyRepository = replyRepository;
  }

  @Transactional
  public Reply getOneByReplyId(Long replyId) {

    Reply reply = replyRepository.findByReplyId(replyId);

    return reply;
  }

  public Reply createReply(ReplyCreateRequest request) {
    Reply reply =
        new Reply(
                request.getBoard(), request.getReplyContent(), request.getReplyWriter(), request.getUsId());
    return replyRepository.save(reply);
  }

  public Reply updateReply(ReplyUpdateRequest request) {
    Reply reply = replyRepository.findByReplyId(request.getReplyId());
    reply.setReplyWriter(request.getReplyWriter());
    reply.setReplyContent(request.getReplyContent());
    reply.setUsId(request.getUsId());

    return replyRepository.save(reply);
  }

  public void deleteReply(Long replyId) {
    replyRepository.deleteById(replyId);
  }
}
