package securty.practice.security.config.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class AuthorityController {

    @GetMapping
    public String helloUsername(Authentication a) {

        StringBuffer stringBuffer = new StringBuffer("hello! ");
        return stringBuffer.append(a.getName()).toString();

    }

}
