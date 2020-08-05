package sungwook.demo_blog.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sungwook.demo_blog.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    void save() {
        Member member = new Member();
        member.setName("test");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //검증
//        System.out.println(result == member);
        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);

    }

    @Test
    void findByName() {
        Member member = new Member();
        member.setName("test1");

        repository.save(member);

        Member member2 = new Member();
        member2.setName("test2");

        repository.save(member2);

        Member result = repository.findByName("test1").get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findAll() {
        Member member = new Member();
        member.setName("test1");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}