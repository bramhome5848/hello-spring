package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 자바 코드로 직접 스프링 빈 등록하기
 * 회원 서비스와 회원 리포지토리의 @Service, @Repository, @Autowired 애노테이션을 제거하고 진행
 */
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    //스프링 데이터 JPA가 SpringDataJpaMemberRepository 를 스프링 빈으로 자동 등록해준다.
    //부모형태의 변수이기 때문에 접근에 제한이 생김
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    private DataSource dataSource;
//    private final EntityManager em;
//
//    @Autowired  //Configuration 설정이 된 클래스는 스프링 빈으로 관리됨
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        /**
//         * DataSource 는 데이터베이스 커넥션을 획득할 때 사용하는 객체
//         * 스프링 부트는 데이터베이스 커넥션 정보를 바탕으로 DataSource 를 생성하고 스프링 빈으로 만들어 둠
//         * 그래서 DI를 받을 수 있다.
//         */
//        this.dataSource = dataSource;
//        this.em = em;
//    }
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        /**
//         * 개방-폐쇄 원칙(OCP, Open-Closed Principle) 확장에는 열려있고, 수정, 변경에는 닫혀있음
//         * 스프링의 DI (Dependencies Injection)을 사용하면 기존 코드를 전혀 손대지 않고, 설정만으로 구현 클 래스를 변경할 수 있음
//         */
//        //return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        //return new JpaMemberRepository(em);
//        return
//    }

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
