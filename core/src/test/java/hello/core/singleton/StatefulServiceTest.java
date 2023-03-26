package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자 10000원 주문
        //statefulService1.order("userA",10000);
        // ThreadB : B사용자 20000원 주문
        //statefulService2.order("userB",20000);

        // ThreadA : 사용자A 주문 금액 조회
        int UserAprice = statefulService1.order("userA",10000);
        int UserBprice = statefulService2.order("userB",20000);
        // 필드를 통해 값을 리턴하지 않음 (싱글톤 객체의 필드를 이용하지않음)
        // 그러니까 인스턴스는 같더라도, 받은 파라미터가 다르니까 같은 인스턴스라도 리턴값이 다를수 있는것
        // 왜냐하면 받은 파라미터 자체를 리턴하기때문에

        System.out.println("price = " + UserAprice);
        System.out.println("price = " + UserBprice);

        assertThat(statefulService1.order("userA",10000)).isEqualTo(10000);
        assertThat(statefulService2.order("userB",20000)).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }


}