package sungwook.demo_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sungwook.demo_blog.domain.Member;
import sungwook.demo_blog.service.MemberService;

import java.util.List;

@Controller
public class MemberController {

    private MemberService memberserive;

    @Autowired
    public MemberController(MemberService memberserive) {
        this.memberserive = memberserive;
    }

    /*
        회원가입 폼
    */
    @GetMapping("/member/new")
    public String CreateForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/member/new")
    public String createUser(MemberForm memberform){
        Member member = new Member();
        member.setName(memberform.getName());
        
        //회원가입
        //이미 회원이 있는 경우 에러 페이지 이동
        try{
            memberserive.join(member);
        }catch(IllegalStateException e){
            boolean result = e.getMessage().equals("이미 존재하는 회원입니다");
            if(result==true){
                System.out.println("이미 존재하는 회원");
                return "members/joinerror.html";
            }
        }

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members =  memberserive.findMembers();
        model.addAttribute("members", members);

        return "members/memberlist";
    }
}
