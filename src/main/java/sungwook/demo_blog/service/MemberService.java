package sungwook.demo_blog.service;

import sungwook.demo_blog.domain.Member;
import sungwook.demo_blog.repository.MemberRepository;
import sungwook.demo_blog.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /*
        회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복회원 X
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        Optional을 반환하는 것은 좋지 않다.
        checkDuplicateMember(member); //함수로 뺴기: 단축키 ctrl + alt + M

        memberRepository.save(member);
        return member.getId();
    }

    /*
        전체회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /*
        회원 한명 조회
     */
    public Optional<Member> findOne(Long memberID){
        return memberRepository.findById(memberID);
    }

    private void checkDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }
}
