package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	PromotionDao promotionDao;
	
	@Override
	@Transactional
	public List<Category> getCategories() {
		List<Category> list = categoryDao.selectAll();
		return list;
	}

	@Override
	public List<Product> getProducts() {
		List<Product> list = productDao.selectProducts();
		return list;
	}

	@Override
	public List<Promotion> getPromotions() {
		List<Promotion> list = promotionDao.selectPromotions();
		return list;
	}

	@Override
	public List<Product> getProduct(int displayId) {
		List<Product> list = productDao.selectProduct(displayId);
		return list;
	}



}
