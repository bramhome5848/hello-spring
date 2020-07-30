package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");

        // 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리
        // 스프링 부트 템플릿엔진 기본 viewName 매핑
        // resources:templates/ + {ViewName} + .html
        return "hello";
    }

    /**
     * MVC와 템플릿 엔진
     */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    /**
     * API
     * @ResponseBody 를 사용하면 뷰 리졸버( viewResolver )를 사용하지 않음
     * 대신에 HTTP BODY 에 문자 내용을 직접 반환(HTML BODY TAG 를 말하는 것이 아님)
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * @ResponseBody 사용 원리
     * HTTP 의 BODY 에 문자 내용을 직접 반환
     * viewResolver 대신에 HttpMessageConverter 가 동작
     * 기본 문자처리: StringHttpMessageConverter
     * 기본 객체처리: MappingJackson2HttpMessageConverter
     * byte 처리 등등 기타 여러 HttpMessageConverter 가 기본으로 등록되어 있음
     * 참고: 클라이언트의 HTTP Accept 해더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해서 HttpMessageConverter 가 선택됨.
     */
}
