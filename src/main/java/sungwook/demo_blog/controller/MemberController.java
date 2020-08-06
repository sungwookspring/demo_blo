package sungwook.demo_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sungwook.demo_blog.service.MemberService;

@Controller
public class MemberController {

    private MemberService memberserive;

    @Autowired
    public MemberController(MemberService memberserive) {
        this.memberserive = memberserive;
    }
}
