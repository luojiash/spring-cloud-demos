package demo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class MainController {

    @RequestMapping("throwexception")
    public Object throwException() {
        throw new RuntimeException("exception occurred");
    }

    @RequestMapping("senderror")
    public Object sendError(HttpServletResponse response) throws IOException {
        response.sendError(500, "unknown server error");
        return null;
    }
}
