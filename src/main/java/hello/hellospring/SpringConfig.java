package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 자바 코드로 직접 스프링 빈 등록하기
 * 회원 서비스와 회원 리포지토리의 @Service, @Repository, @Autowired 애노테이션을 제거하고 진행
 */
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    /**
     * 참고1: XML로 설정하는 방식도 있지만 최근에는 잘 사용하지 않으므로 생략

     * 참고2: DI에는 필드,주입 setter 주입(set 메서드로 주입), 생성자 주입 이렇게 3가지 방법이 있음.
     * 의존관계가 실행중에 동적으로 변하는 경우는 없으므로 생성자 주입을 권장
     * setter 주입의 경우 public으로 열려 있기 때문에 아무 개발자나 호출할 수 있기 때문에 변경될 가능성이 큼

     * 참고3: 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용
     * 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록

     * 주의: @Autowired 를 통한 DI는 helloConroller , memberService 등과 같이 스프링이 관리하는 객체에서만 동작
     * 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않음
     */
}
