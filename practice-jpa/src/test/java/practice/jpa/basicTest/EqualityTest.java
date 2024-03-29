package practice.jpa.basicTest;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import practice.PracticeJpaApplication;
import practice.jpa.test.basic.entity.member.Member;
import practice.jpa.test.basic.entity.uuid.UUIDMember;
import practice.jpa.test.basic.repository.UUIDMember.UUIDMemberRepository;
import practice.jpa.test.basic.repository.member.MemberRepository;

@DisplayName("JPA 엔티티 동등성 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DataJpaTest
@ContextConfiguration(classes = PracticeJpaApplication.class)
@Rollback(value = false)
public class EqualityTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    UUIDMemberRepository uuidMemberRepository;

    @Test
    void 저장_조회_시_엔티티_불일치() {
        // given
        final String name = "testMember";

        Member member = new Member();
        member.setName("testMember");
        memberRepository.save(member);

        // when
        Optional<Member> findMemberOptional = memberRepository.findByName(name);
        Member findMember = findMemberOptional.orElseThrow();

        // then
        Assertions.assertThat(findMember).isEqualTo(member);
    }

    @Test
    @Transactional
    void Transactional_저장_조회_시_엔티티_일치() {
        // given
        final String name = "testMember2";

        Member member = new Member();
        member.setName("testMember2");
        memberRepository.save(member);

        // when
        Optional<Member> findMemberOptional = memberRepository.findByName(name);
        Member findMember = findMemberOptional.orElseThrow();

        // then
        Assertions.assertThat(findMember).isEqualTo(member);
    }


    @Test
    void Transactional_EqualsAndHashCode_저장_조회_시_엔티티_일치() {
        // given
        final String username = "uuidMember1";

        UUIDMember uuidMember = new UUIDMember();
        uuidMember.setName(username);

        uuidMemberRepository.save(uuidMember);

        // when
        Optional<UUIDMember> findMemberOptional = uuidMemberRepository.findByName(username);
        UUIDMember findMember = findMemberOptional.orElseThrow();

        // then
        Assertions.assertThat(findMember).isEqualTo(uuidMember);
    }
}
