package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.orderService;
import hello.core.order.orderServiceImpl;

public class orderApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        orderService orderService = new orderServiceImpl();
        MemberRepository memberRepository = new MemoryMemberRepository();
        DiscountPolicy discountPolicy = new FixDiscountPolicy();

        Long MemberId = 1L;
        Member member = new Member(MemberId,"memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(MemberId,"Item",10000);
        //Member member1 = memberRepository.FindById(MemberId);
        int discountPrice = order.calculatePrice();

        System.out.println(discountPrice);

    }
}
