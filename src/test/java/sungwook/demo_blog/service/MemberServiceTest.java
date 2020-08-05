package sungwook.demo_blog.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import sungwook.demo_blog.domain.Member;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberservice = new MemberService();

    @Test
    void 회원가입() {
        //given:상황
        Member member = new Member();
        member.setName("test1");

        //when:무엇을
        Long saveID = memberservice.join(member);

        //then:검증 -> 저장되었는지 ID로 검사
        //step1: 서비스객체에 구현된 함수 사용
        Member findmember =  memberservice.findOne(saveID).get();

        Assertions.assertThat(member.getName()).isEqualTo(findmember.getName());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}