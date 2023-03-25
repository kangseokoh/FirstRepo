package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.orderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class orderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        orderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        orderService orderService = ac.getBean("orderService", orderService.class);

        Long MemberId = 1L;
        Member member = new Member(MemberId,"memberA", Grade.VIP);

        memberService.join(member);
        Order order = orderService.createOrder(MemberId,"Item",20000);

        System.out.println("order : " + order);
    }
}
