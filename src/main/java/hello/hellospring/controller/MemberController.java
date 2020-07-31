package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    /**
     * 생성자에 @Autowired 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어줌
     * 이렇게 객체 의존관계를 외부에서 넣어주는 것을 DI (Dependency Injection), 의존성 주입이라고 함
     * 이전 테스트에서는 개발자가 직접 주입했고, 여기서는 @Autowired에 의해 스프링이 주입해줌
     * @Controller 가 있으면 스프링 빈으로 자동 등록 자동 등록됨
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 스프링 빈을 등록하는 2가지 방법
     * - 컴포넌트 스캔과 자동 의존관계 설정
     * - 자바 코드로 직접 스프링 빈 등록하기

     * 컴포넌트 스캔 원리
     * - @Component 애노테이션이 있으면 스프링 빈으로 자동 등록
     * - @Controller 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문임
     * - @Component 를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록
     * - @Controller, @Service, @Repository
     * - 컴포넌트 스캔의 범위는 시작 함수가 포함된 패키지 포함한 하위들은 스프링이 뒤져서 빈으로 등록함

     * 생성자에 @Autowired 를 사용하면 객체 생성 시점에 스프링 컨테이너에서 해당 스프링 빈을 찾아서 주입
     * 생성자가 1개만 있으면 @Autowired 는 생략할 수 있음

     * 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록(유일하게 하나만 등록해서 공유)
     * 따라서 같은 스프링 빈이면 모두 같은 인스턴스
     * 설정으로 싱글톤이 아니게 설정할 수 있지만, 특별한 경우를 제외하면 대부분 싱글톤을 사용
     */
}
