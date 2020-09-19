package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path="/api/show")
public class ReservationApiController {
	
	@Autowired
	ReservationService reservationService;

	@GetMapping("/categories")
	public Map<String, Object> list() {
		
		List<Category> list = reservationService.getCategories();
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("list", list);
		
		return map;
	}
}
