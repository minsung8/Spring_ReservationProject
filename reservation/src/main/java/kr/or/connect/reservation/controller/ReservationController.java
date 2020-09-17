package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping(path="/list")
	public String list(ModelMap model) {
		
		List<Category> list = reservationService.getCategories();
		
		model.addAttribute("list", list);
		
		return "list";
		
	}

}
