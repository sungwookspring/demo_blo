package sungwook.demo_blog.service;

import org.assertj.core.api.Assert;
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
    void 중복회원가입() {
        Member member1 = new Member();
        member1.setName("test1");
        memberservice.join(member1);

        Member member2 = new Member();
        member2.setName("test1");

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberservice.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

    }

    @Test
    void findOne() {
    }
}