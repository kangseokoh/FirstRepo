package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.order.orderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.*;

@Configuration
@ComponentScan (
        excludeFilters = @ComponentScan.Filter
                (type = FilterType.ANNOTATION ,
                classes = Configuration.class )
)
public class AutoAppConfigTest {

    @Test
    void basicScan() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        orderServiceImpl bean = ac.getBean(orderServiceImpl.class);

        MemberRepository memberRepository = bean.getMemberRepository();
        DiscountPolicy discountPolicy = bean.getDiscountPolicy();

        System.out.println("memberRepository =" + memberRepository);
        System.out.println("discountPolicy =" + discountPolicy);
    }
}
