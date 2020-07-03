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

  public List<Reply> getAll(int curpage) {
    int size;
    int start;
    size = 5;
    start = (curpage*size);
    return replyRepository.findAll();
//  }
//  public List<Integer> getCount(){
//
//    return replyRepository.findpaging();
//  }
//
//  @Transactional
//  public Board getOneByBoardId(Long boardId) {
//
//    Board board = boardRepository.findByBoardId(boardId);
//    Hibernate.initialize(board.getReplies());
//
//    return board;
//  }
//
//  public Board createBoard(BoardCreateRequest request) {
//    Board board =
//        new Board(
//            request.getBoardTitle(), request.getBoardCount(), request.getBoardContent(), request.getBoardPrivate(), request.getUsId());
//    return boardRepository.save(board);
//  }
//
//  public Board updateBoard(BoardUpdateRequest request) {
//    Board board = boardRepository.findByBoardId(request.getBoardId());
//    board.setBoardTitle(request.getBoardTitle());
//    board.setBoardContent(request.getBoardContent());
//    board.setBoardCount(request.getBoardCount());
//    board.setBoardPrivate(request.getBoardPrivate());
//    board.setUsId(request.getUsId());
//    board.setUsId(request.getUsId());
//
//    return boardRepository.save(board);
//  }
//
//  public void deleteBoard(Long boardId) {
//    boardRepository.deleteById(boardId);
//  }
}
