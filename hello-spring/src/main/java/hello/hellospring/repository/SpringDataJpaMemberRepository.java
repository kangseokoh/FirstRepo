package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
    // JPQL select m from Member m where m.name = ?
    // findBy"Name"And"Id"(String name, Long Id); 메서드명으로 쿼리지정가능
}
