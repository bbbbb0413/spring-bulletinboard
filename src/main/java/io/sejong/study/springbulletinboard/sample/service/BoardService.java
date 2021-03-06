package io.sejong.study.springbulletinboard.sample.service;

import io.sejong.study.springbulletinboard.sample.entity.Board;
import io.sejong.study.springbulletinboard.sample.http.req.BoardCreateRequest;
import io.sejong.study.springbulletinboard.sample.http.req.BoardUpdateRequest;
import io.sejong.study.springbulletinboard.sample.repository.BoardRepository;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardService {

  private final BoardRepository boardRepository;

  /** 생성자 의존관계 주입(DI, AOP 알아보기) 이외에도 @Autowired를 이용한 필드주입, setter 주입이 있다. */
  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  public List<Board> getAll(int curpage) {
    int size;
    int start;
    size = 5;
    start = (curpage*size);
    return boardRepository.findSomeCase(start,size);
  }
  public List<Integer> getCount(){
    return boardRepository.findpaging();
  }

  @Transactional
  public Board getOneByBoardId(Long boardId) {
    Board board = boardRepository.findByBoardId(boardId);
    //board 조회수 증가 후 DB 저장
    board.setBoardCount(board.getBoardCount()+1);
    boardRepository.save(board);
    // replies를 veiw에서 사용하기 위해서 초기화.
    Hibernate.initialize(board.getReplies());

    return board;
  }

  public Board createBoard(BoardCreateRequest request) {
    Board board =
        new Board(
            request.getBoardTitle(), request.getBoardCount(), request.getBoardContent(), request.getBoardPrivate(), request.getUsId());
    return boardRepository.save(board);
  }


  public Board updateBoard(BoardUpdateRequest request) {
    Board board = boardRepository.findByBoardId(request.getBoardId());
    board.setBoardTitle(request.getBoardTitle());
    board.setBoardContent(request.getBoardContent());
    board.setBoardCount(request.getBoardCount());
    board.setBoardPrivate(request.getBoardPrivate());
    board.setUsId(request.getUsId());

    return boardRepository.save(board);
  }

  public void deleteBoard(Long boardId) {

    boardRepository.deleteById(boardId);
  }
}
