package io.sejong.study.springbulletinboard.sample.controller;

import io.sejong.study.springbulletinboard.sample.entity.Sample;
import io.sejong.study.springbulletinboard.sample.entity.Board;
import io.sejong.study.springbulletinboard.sample.http.req.BoardCreateRequest;
import io.sejong.study.springbulletinboard.sample.http.req.BoardUpdateRequest;
import io.sejong.study.springbulletinboard.sample.http.req.SampleCreateRequest;
import io.sejong.study.springbulletinboard.sample.http.req.SampleUpdateRequest;
import io.sejong.study.springbulletinboard.sample.model.Type;
import io.sejong.study.springbulletinboard.sample.service.SampleService;
import io.sejong.study.springbulletinboard.sample.service.BoardService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

  private final BoardService boardService;

  public SampleController(BoardService boardService) {
    this.boardService = boardService;
  }

  /** sample 전체 조회 http://localhost:8080/sample/read-all*/
  @RequestMapping("/sample/read-all")
  public String getBoardsAll(Model model, @RequestParam(value = "curpage", required = false, defaultValue = "0") int curpage) {
    List <Integer> count = boardService.getCount();
    int startpage , endpage, cnt;
    startpage = 0;

    cnt = count.get(0);
    endpage = (cnt / 5);

    List<Board> boardList = boardService.getAll(curpage);

    model.addAttribute("boardList", boardList);
    model.addAttribute("startpage", startpage);
    model.addAttribute("endpage", endpage);
    // sample-read-all.ftl 뷰를 반환한다.
    return "sample-read-all";
  }

  /** sample 단건 조회 http://localhost:8080/sample/read-one?sample_id={sample_id} */
  @RequestMapping("/sample/read-one")
  public String getBoardOne(Model model, @RequestParam("board_id") Long boardId) {
    Board board = boardService.getOneByBoardId(boardId);
    model.addAttribute("board", board);

    // sample-read-one.ftl 뷰를 반환한다.
    return "sample-read-one";
  }

  /** sample 등록 http://localhost:8080/sample/create */
  @PostMapping("/sample/create")
  public String createBoard(Model model, @ModelAttribute BoardCreateRequest request) {
    Board board = boardService.createBoard(request);
    model.addAttribute("board_id", board.getBoardId());

    // http://localhost:8080/sample/read-one으로 리다이렉션 한다.
    return "redirect:/sample/read-one";
  }

  /** sample 수정 http://localhost:8080/sample/update */
  @PostMapping("/sample/update")
  public String updateBoard(Model model, @ModelAttribute BoardUpdateRequest request) {
    Board board = boardService.updateBoard(request);
    model.addAttribute("board_id", board.getBoardId());

    // http://localhost:8080/sample/read-one으로 리다이렉션 한다.
    return "redirect:/sample/read-one";
  }

  /**
   * sample 등록/수정 페이지 요청 http://localhost:8080/sample/write?type=CREATE
   * http://localhost:8080/sample/write?type=UPDATE&sample_id={sample_id}
   */
  @RequestMapping("/sample/write")
  public String writeBoard(
          Model model,
          @RequestParam Type type,
          @RequestParam(value = "board_id", required = false) Long boardId) {
    Board board;
    if (type == Type.UPDATE) {
      board = boardService.getOneByBoardId(boardId);
      model.addAttribute("board", board);
    }
    model.addAttribute("type", type);

    // sample-write.ftl 뷰를 반환한다.
    return "sample-write";
  }

  /** http://localhost:8080/sample/delete?sample_id={sample_id} */
  @RequestMapping("/sample/delete")
  public String deleteBoard(@RequestParam("board_id") Long boardId) {
    boardService.deleteBoard(boardId);
    // http://localhost:8080/sample/read-all로 리다이렉션 한다.
    return "redirect:/sample/read-all";
  }
}
