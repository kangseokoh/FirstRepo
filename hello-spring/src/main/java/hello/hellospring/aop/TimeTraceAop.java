package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    // PKG 하위에 모두적용
    @Around("execution(* hello.hellospring..*(..))")
    /* Service 하위 패키지만
     @Around("execution(* hello.hellospring.Service..*(..))") */
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {

            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END :" + joinPoint.toString() + " " + timeMs + "ms");

        }



    }
}

