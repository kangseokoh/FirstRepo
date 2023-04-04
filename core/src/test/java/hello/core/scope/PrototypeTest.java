package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class); // 클래스를 직접 지정하면 @Component를 하지 않아도 Bean으로 등록함
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        ac.close();
        // 스프링 컨테이너를 종료해도 destory 메서드가 실행되지 않는다. (prototype이기 때문)
        prototypeBean1.destory();
        prototypeBean2.destory();
    }

    @Scope("prototype")
    static class PrototypeBean {

            @PostConstruct
            public void init() {
                System.out.println("PrototypeBean.init");
            }

            @PreDestroy
            public void destory() {
                System.out.println("PrototypeBean.destroy");
            }
    }

}
