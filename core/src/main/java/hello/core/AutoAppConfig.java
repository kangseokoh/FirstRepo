package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

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


}
