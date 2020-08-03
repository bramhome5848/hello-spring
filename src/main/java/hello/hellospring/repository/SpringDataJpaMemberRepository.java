package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * interface 다중 상속 가능
 * interface 자체는 객체를 만들 수 없지만, 해당 인터페이스의 바디를 함께 구현하면 객체를 사용할 수 있음
 */

/**
 * 인터페이스 다중 상속의 경우 이름이 같더라도 구현체가 없기 때문에 실제 구현체는 1개만 구현됨
 * 하지만 상속 받을 인터페이스의 구현체가 존재할 경우 상속 충돌로 인한 문제가 발생할 수 있음 ex) MemberRepositoryImpl 에서 함수를 구현한 경우
 * 접근 할 수 있는 메서드 범위 -> 상속 구조이기 때문에 부모 변수형태로 자식 객체를 가지고 있다고 해도 부모형에서 선언한 메서드만 접근 가능
 * SpringDataJpaMemberRepository 형의 변수로 service 에서 접근할 경우 JpaRepository 와 MemberRepository 에 공통으로 존재하는
 * 함수에 대해 어떤 함수를 접근할 것인지에 대한 에러또한 발생할 수 있음
 * 일반 자바에서는 인터페이스 객체 생성을 위해서는 반드시 함수를 구현해야 하기 때문에 문제가 되지 않을 수 있지만
 * JPA의 경우 구현체가 실행시에 생성되어 동작하기 떄문에 어떤 함수를 사용할 것인지를 명확히 지정해야 함, 함수 명은 겹치지 않도록 해야함..
 */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //기본형을 제외한 함수형태 작성
    //2개의 interface 에서 이름이 같은 메서드의 경우 하나의 구현체로 구현됨 -> findById, findAll
//    @Override
//    Optional<Member> findByName(String name);
}
