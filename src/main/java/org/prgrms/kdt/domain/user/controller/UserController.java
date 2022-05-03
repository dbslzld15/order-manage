package org.prgrms.kdt.domain.user.controller;

import org.prgrms.kdt.domain.user.entity.User;
import org.prgrms.kdt.domain.user.request.UserCreateRequest;
import org.prgrms.kdt.domain.user.request.UserLoginRequest;
import org.prgrms.kdt.domain.user.request.UserPwResetRequest;
import org.prgrms.kdt.domain.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public String joinUser(@RequestBody UserCreateRequest createRequest) {
        userService.save(createRequest);
        return "redirect:/users";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest loginRequest, HttpSession session) {
        User user = userService.getUserByLogin(loginRequest);
        session.setAttribute("userId", user.getUserId());
        return "menu";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/users";
    }

    @PostMapping("/reset")
    public String resetPassword(@RequestBody UserPwResetRequest resetRequest){
        userService.updatePassword(resetRequest);
        return "redirect:/users";
    }
}
