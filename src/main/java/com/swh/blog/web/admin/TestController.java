package com.swh.blog.web.admin;

import com.swh.blog.po.User;
import com.swh.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/type-input")
    public String toType_Input(){
        return "admin/types-input";
    }

}
