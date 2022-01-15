package isntkyu.isntkyuspring;

import isntkyu.isntkyuspring.repository.JpaMemberRepository;
import isntkyu.isntkyuspring.repository.MemberRepository;
import isntkyu.isntkyuspring.repository.MemoryMemberRepository;
import isntkyu.isntkyuspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private final DataSource dataSource;
    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
//        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
}
