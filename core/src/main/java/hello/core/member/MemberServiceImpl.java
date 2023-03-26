package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("memberService2")
//@ComponentScan을 통한 bean 등록 시 이름을 지정할 수 있음
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class) 와 동일한 기능을함
    // @Component 방식으로 등록된 Bean에 DI를 자동으로 해주는 기능
    // @Component - @Autowired는 세트임
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.FindById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
