package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // Spring 컨테이너를 띄우고 테스트 진행 (통합테스트)
@Transactional // Commit 처리를 안함 (테스트하고 롤백하니까 사후처리 할 필요가 없음)
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    //@Commit
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
//        assertThrows(NullPointerException.class, () -> memberService.join(member2));
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        assertThat(assertThrows(IllegalStateException.class, () -> memberService.join(member2))
                .getMessage()).isEqualTo("이미 존재하는 회원입니다.");



//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }


        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}