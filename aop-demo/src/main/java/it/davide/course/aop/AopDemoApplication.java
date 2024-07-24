package it.davide.course.aop;

import it.davide.course.aop.dao.AccountDao;
import it.davide.course.aop.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AccountDao accountDao,
			MembershipDao membershipDao) {
		return runner -> {
			demoBeforeAdvice(accountDao, membershipDao);
		};
	}

	private void demoBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {
		accountDao.addAccount();
		membershipDao.addAccount();
	}

}
