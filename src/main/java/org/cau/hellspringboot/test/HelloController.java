package org.cau.hellspringboot.test;

import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@ToString
@Setter
class HelloDto {

    private String name;
    private String hello;
}
@Controller
public class HelloController {

    @ResponseBody
    @PostMapping("/hello")
    public String hello(@RequestBody HelloDto helloDto) {
        System.out.println(helloDto);
        return helloDto.toString();
    }
}
