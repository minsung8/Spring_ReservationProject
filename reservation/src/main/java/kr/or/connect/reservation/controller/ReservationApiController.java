package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	
	@Autowired
	ReservationService reservationService;

	@GetMapping("/categories")
	public Map<String, Object> list() {
		
		List<Category> list = reservationService.getCategories();
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("size", list.size());
		map.put("items", list);
		
		return map;
	}
	
	@GetMapping("/displayinfos")
	public Map<String, Object> displayinfos() {
		
		List<Product> list = reservationService.getProducts();
		List<Category> c_list = reservationService.getCategories();
		
		
		Map<String, Object> map = new HashMap<>();


		map.put("totalCount", c_list.get(2).getCnt());
		map.put("productCount", list.size());
		map.put("products", list);
		
		return map;
	}
	
	@GetMapping("/promotions")
	public Map<String, Object> promotions() {
		
		List<Promotion> list = reservationService.getPromotions();		
		
		Map<String, Object> map = new HashMap<>();


		map.put("size", list.size());
		map.put("items", list);
		
		return map;
	}
	
	@GetMapping("/displayinfos2/{displayId}")
	
    public Map<String, Object> displayinfo(@RequestParam("displayId")int displayId){

		List<Product> list = reservationService.getProduct(displayId);
		
		Map<String, Object> map = new HashMap<>();

		map.put("items", list);
		
		return map;
    }
	
	
	
	
}
