package isntkyu.isntkyuspring;

import isntkyu.isntkyuspring.repository.MemberRepository;
import isntkyu.isntkyuspring.repository.MemoryMemberRepository;
import isntkyu.isntkyuspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
