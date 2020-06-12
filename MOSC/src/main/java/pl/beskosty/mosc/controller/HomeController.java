package pl.beskosty.mosc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Przemek
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String showPage(Model model) {

        return "index";
    }

}
