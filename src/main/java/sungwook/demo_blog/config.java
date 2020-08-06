package sungwook.demo_blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sungwook.demo_blog.repository.MemberRepository;
import sungwook.demo_blog.repository.MemoryMemberRepository;
import sungwook.demo_blog.service.MemberService;

@Configuration
public class config {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
