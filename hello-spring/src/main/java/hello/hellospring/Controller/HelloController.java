package hello.hellospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    // => GetMapping은 url의 주소에 입력한 값을 찾아감 main/hello면 hello 찾아감
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        return "hello";
        // return => templates의 hello.html을 실행시켜라
        // templates에 없으면 화면 못찾는 에러발생
    }
}
