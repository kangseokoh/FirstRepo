package hello.hellospring.Controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
//    @Autowired private final MemberService memberService;
//    필드주입 : 생성시 객체 커스텀을 할 수 없어 추천 X

//    @Autowired // setter 주입 : 중간에 객체가 변경될 우려가 있어 추천 X
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        // 생성자 주입
    }
}
