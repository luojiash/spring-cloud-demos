package demo.security.controller;

import demo.security.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        if (SecurityUtils.isLogin()) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
