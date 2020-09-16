package kr.or.connect.reservation.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.Category;

public class Tests {

	public static void main(String[] args) {


		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
//		GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);
		CategoriesDao categoryDao = ac.getBean(CategoriesDao.class);
		List<Category> list = new ArrayList<Category>();
		list = categoryDao.selectAll();
		System.out.println(list.size());
//		
//		Guestbook guestbook = new Guestbook();
//		guestbook.setName("강경미");
//		guestbook.setContent("반갑습니다. 여러분.");
//		guestbook.setRegdate(new Date());
//		Long id = guestbookDao.insert(guestbook);
//		System.out.println("id : " + id);
		
  
	}

}
