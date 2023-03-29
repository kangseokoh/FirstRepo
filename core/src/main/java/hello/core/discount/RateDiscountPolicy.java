package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy // 자체 생성 어노테이션
//@Qualifier("mainDiscountPolicy")
//@Primary // bean 타입이 겹칠경우 주입에 우선순위를 가짐
public class RateDiscountPolicy implements DiscountPolicy{

    private int rateDiscount = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * rateDiscount / 100;
        } else {
            return 0;
        }
    }
}
