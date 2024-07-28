package it.davide.course.aop;

import it.davide.course.aop.dao.AccountDao;
import it.davide.course.aop.dao.MembershipDao;
import it.davide.course.aop.model.Account;
import it.davide.course.aop.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AccountDao accountDao,
			MembershipDao membershipDao,
			TrafficFortuneService trafficFortuneService) {
		return runner -> {
			//demoBeforeAdvice(accountDao, membershipDao);
			//demoAfterReturningAdvice(accountDao);
			//demoAfterThrowingAdvice(accountDao);
			//demoAfterAdvice(accountDao);
			demoAroundAdvice(trafficFortuneService);
		};
	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n\nMain program: demoAroundAdvice");
		System.out.println("Calling getFortune()");
		System.out.println("My fortune is: " + trafficFortuneService.getFortune());
	}

	private void demoAfterAdvice(AccountDao accountDao) {
		List<Account> accounts = null;

		try {
			boolean tripWire = false;
			accounts = accountDao.findAccounts(tripWire);
		}catch (Exception e) {
			System.out.println("\n\nMain program: caught exception: " + e.getMessage());
		}

		System.out.println("\n\nMain program: demoAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(accounts);
	}

	private void demoAfterThrowingAdvice(AccountDao accountDao) {
		List<Account> accounts = null;

		try {
			boolean tripWire = true;
			accounts = accountDao.findAccounts(tripWire);
		}catch (Exception e) {
			System.out.println("\n\nMain program: caught exception: " + e.getMessage());
		}

		System.out.println("\n\nMain program: demoAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(accounts);
	}

	private void demoAfterReturningAdvice(AccountDao accountDao) {
		List<Account> accounts = accountDao.findAccounts();
		System.out.println("\n\nMain program: demoAfterReturningAdvice");
		System.out.println("----");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {
		//Call the business method
		accountDao.addAccount(new Account("Davide", "Strianese"));
		accountDao.doWork();

		//call the accountDao gettere/setter method
//		accountDao.setName("Luca");
//		accountDao.setServiceCode("001122");
//
//		accountDao.getName();
//		accountDao.getServiceCode();
	}

}
