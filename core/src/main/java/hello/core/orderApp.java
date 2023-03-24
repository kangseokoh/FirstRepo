package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.orderService;

public class orderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        orderService orderService = appConfig.orderService();

        Long MemberId = 1L;
        Member member = new Member(MemberId,"memberA", Grade.VIP);

        memberService.join(member);
        Order order = orderService.createOrder(MemberId,"Item",10000);

        System.out.println("order : " + order);
    }
}
