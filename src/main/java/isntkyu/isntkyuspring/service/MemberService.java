package isntkyu.isntkyuspring.service;

import isntkyu.isntkyuspring.domain.Member;
import isntkyu.isntkyuspring.repository.MemberRepository;
import isntkyu.isntkyuspring.repository.MemoryMemberRepository;
import org.springframework.expression.spel.ast.OpInc;

import java.util.List;
import java.util.Optional;

public class MemberService {
    public final MemberRepository memberRepository;

    public MemberService (MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDublicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDublicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne (Long memberId) {
        return memberRepository.findById(memberId);
    }
}
