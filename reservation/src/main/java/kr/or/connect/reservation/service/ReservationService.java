package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Category;

public interface ReservationService {
	
	public List<Category> getCategories();
	
}