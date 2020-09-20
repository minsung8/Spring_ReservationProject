package kr.or.connect.reservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;

@Repository
public class ProductDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	
	public ProductDao(DataSource dataSource) {
		
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("product")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<Product> selectProducts() {
		
		String sql = "select distinct(P.id),  C.id, P.id as displayInfoId, C.name, P.description, P.content, P.event, D.opening_hours, D.place_name\r\n" + 
				", D.place_lot, D.place_street, D.tel, D.homepage, D.email, D.create_Date, D.modify_Date, P_I.file_id\r\n" + 
				"from display_info D\r\n" + 
				"left join product P on D.product_id = P.id\r\n" + 
				"left join product_image P_I on P.id = P_I.product_id\r\n" + 
				"left join category C on P.category_id = C.id\r\n" + 
				"group by D.id\r\n" + 
				"having C.id = 3 and D.id <= 24";
		
		return jdbc.query(sql, rowMapper);
	}

	public List<Product> selectProduct(int displayId) {
		
		String sql = "select distinct(P.id),  C.id as categoryId, P.id as displayInfoId, C.name, P.description, P.content, P.event, D.opening_hours, D.place_name\r\n" + 
				"				, D.place_lot, D.place_street, D.tel, D.homepage, D.email, D.create_Date, D.modify_Date, P_I.file_id \r\n" + 
				"				from display_info D\r\n" + 
				"				left join product P on D.product_id = P.id\r\n" + 
				"				left join product_image P_I on P.id = P_I.product_id\r\n" + 
				"				left join category C on P.category_id = C.id\r\n" + 
				"				group by D.id\r\n" + 
				"                having D.id=:D.id\r\n" + 
				"";
		String temp = Integer.toString(displayId);
		SqlParameterSource param = new MapSqlParameterSource("D.id", temp);

		return jdbc.query(sql, param, rowMapper);
	}



}
