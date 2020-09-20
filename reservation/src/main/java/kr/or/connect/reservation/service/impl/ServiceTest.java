package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;

public class ServiceTest {
	
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ReservationService reservationService = ac.getBean(ReservationService.class);
		
		List<Product> list = reservationService.getProduct(1);
		
		for (Product c : list) {
			System.out.println(c.toString());
		}
	}

}
