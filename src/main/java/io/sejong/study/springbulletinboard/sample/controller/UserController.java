package io.sejong.study.springbulletinboard.sample.controller;

import io.sejong.study.springbulletinboard.sample.entity.Board;
import io.sejong.study.springbulletinboard.sample.entity.User;
import io.sejong.study.springbulletinboard.sample.http.req.UserCreateRequest;
import io.sejong.study.springbulletinboard.sample.http.req.UserUpdateRequest;
import io.sejong.study.springbulletinboard.sample.model.Type;
import io.sejong.study.springbulletinboard.sample.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  /** User 회원가입 http://localhost:8080/sample/sign-up */
  @RequestMapping("/sample/sign-up/create")
  public String createUser(Model model, @ModelAttribute UserCreateRequest request) {
      User user = userService.createUser(request);
      model.addAttribute("u_id", user.getUsId());
      // sample-read-all.ftl 뷰를 반환한다.
      return "redirect:/sample/read-all";
  }
//
//  @RequestMapping("/sample/login")
//  public String Login(Model model, @RequestParam ) {
//    User user = userService.createUser(request);
//    model.addAttribute("u_id", user.getUsId());
//    // sample-read-all.ftl 뷰를 반환한다.
//    return "login";
//  }
//
  /**
   * sample 등록/수정 페이지 요청 http://localhost:8080/sample/write?type=CREATE
   * http://localhost:8080/sample/write?type=UPDATE&sample_id={sample_id}
   */
  @RequestMapping("/sample/sign-up")
  public String sign_up(
          Model model,
          @RequestParam Type type,
          @RequestParam(value = "us_id", required = false) Long usId) {
    User user;
    if (type == Type.UPDATE) {
      user = userService.getOneByUsId(usId);
      model.addAttribute("user", user);
    }
    model.addAttribute("type", type);

    // sample-write.ftl 뷰를 반환한다.
    return "sign-up";
  }

//  /** http://localhost:8080/sample/delete?sample_id={sample_id} */
//  @RequestMapping("/sample/delete")
//  public String deleteBoard(@RequestParam("board_id") Long boardId) {
//    boardService.deleteBoard(boardId);
//    // http://localhost:8080/sample/read-all로 리다이렉션 한다.
//    return "redirect:/sample/read-all";
//  }
}
