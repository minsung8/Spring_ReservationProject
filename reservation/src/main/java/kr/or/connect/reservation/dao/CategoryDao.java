package kr.or.connect.reservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;

@Repository
public class CategoryDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	
	public CategoryDao(DataSource dataSource) {
		
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("category")
				.usingGeneratedKeyColumns("id");
				
	}
	
	public List<Category> selectAll() {
		
		String sql = "select C.id, C.name, count(*) as cnt\r\n" + 
				"from display_info D\r\n" + 
				"join product P on D.product_id = P.id\r\n" + 
				"join category C on P.category_id = C.id\r\n" + 
				"group by C.id\r\n";
		
		
		return jdbc.query(sql, rowMapper);
	}

}
