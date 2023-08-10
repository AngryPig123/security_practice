package securty.practice.security.config.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import securty.practice.security.config.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/main")
public class MainPageController {

    private final ProductService productService;

    @GetMapping
    public String main(Authentication authentication, Model model) {
        model.addAttribute("username", authentication.getName());
        model.addAttribute("products", productService.findAll());
        return "main";
    }

}
