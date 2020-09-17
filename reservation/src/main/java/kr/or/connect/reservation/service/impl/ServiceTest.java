package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.ReservationService;

public class ServiceTest {
	
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ReservationService reservationService = ac.getBean(ReservationService.class);
		
		List<Category> list = reservationService.getCategories();
		
		for (Category c : list) {
			System.out.println(c.getName());
		}
	}

}
