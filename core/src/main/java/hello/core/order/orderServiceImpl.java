package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class orderServiceImpl implements orderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    // 필드주입 (권장하지 않음 - 테스트 어려움/외부에서 값 변경이 절대 불가함)
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

//    //수정자 (Setter)
//    @Autowired(required = false) // 필수아님, 중간에 인스턴스 변경가능
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

//    //일반 메서드 주입 (setter 주입이랑 거의 똑같음)
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Autowired
    // 생성자가 하나일때는 Autowired 제외해도 됨
    public orderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        //System.out.println("memberRepository = " + memberRepository + ", discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.FindById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
    public DiscountPolicy getDiscountPolicy() { return discountPolicy; }

}
