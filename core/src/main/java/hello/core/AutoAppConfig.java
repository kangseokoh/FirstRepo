package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.orderService;
import hello.core.order.orderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.OrderComparator;

@Configuration // @Compnent 어노테이션을 찾아서 해당 클래스를 모두 빈으로 등록해줌
@ComponentScan (
//        basePackages = {"hello.core.member", "hello.core.order"} , // @Compnent를 찾을 위치를 정함
//        basePackageClasses = AutoAppConfig.class , // 대상 클래스의 패키지에서부터 찾음 (여기선 hello.core가 되겠지)
//        base를 지정하지 않는경우엔? @ComponentScan이 붙은 클래스가 시작위치가 된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION ,
                classes = Configuration.class) // 빈 등록을 제외할 클래스를 등록
)

// @Configuraion 자체에 @Component 가 붙어있기 때문에,
// Config 클래스는 제외를 안해주면 충돌날 수 있음
// 필터타입 ANNOTATION은 애노테이션 기준으로 필터한다는 뜻

public class AutoAppConfig {

//    @Autowired MemberRepository memberRepository;
//    @Autowired DiscountPolicy discountPolicy;
//
//    @Bean
//    orderService orderService() {
//        return new orderServiceImpl(memberRepository,discountPolicy);
//    }

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
