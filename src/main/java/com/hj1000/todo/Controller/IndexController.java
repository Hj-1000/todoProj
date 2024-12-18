package com.hj1000.todo.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class IndexController {
    @GetMapping({"/" , "/index"})
    public String index(){
        return "index";
        //이게 주석
    }
}
