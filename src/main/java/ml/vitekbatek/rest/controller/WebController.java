package ml.vitekbatek.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.annotation.WebServlet;

@Controller
public class WebController {
    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/")
    public String home(Model model) {
        return "redirect:/index";
    }
}
