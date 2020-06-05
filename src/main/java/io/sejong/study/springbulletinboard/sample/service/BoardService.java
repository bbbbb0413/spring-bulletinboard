package io.sejong.study.springbulletinboard.sample.service;

import io.sejong.study.springbulletinboard.sample.entity.Board;
import io.sejong.study.springbulletinboard.sample.http.req.BoardCreateRequest;
import io.sejong.study.springbulletinboard.sample.http.req.BoardUpdateRequest;
import io.sejong.study.springbulletinboard.sample.repository.BoardRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

  private final BoardRepository boardRepository;

  /** 생성자 의존관계 주입(DI, AOP 알아보기) 이외에도 @Autowired를 이용한 필드주입, setter 주입이 있다. */
  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  public List<Board> getAll() {

    return boardRepository.findAll();
  }

  public Board getOneByBoardId(Long boardId) {
    return boardRepository.findByBoardId(boardId);
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
