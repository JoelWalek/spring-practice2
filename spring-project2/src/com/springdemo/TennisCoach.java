package com.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("\nInside Default Constructor");
	}
	
	//define post construct
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("\nTennis coach doing post construct stuff");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("\nTennis coach doing destroy stuff");
	}
	
	
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("\nInside setter method");
//		this.fortuneService = fortuneService;
//	}
	
//	@Autowired
//	public void arbitraryMethodName(FortuneService fortuneService) {
//		System.out.println("\nInside custom method");
//		this.fortuneService = fortuneService;
//	}
	
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
