package kr.or.connect.reservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;

@Repository
public class PromotionDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Promotion> rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);
	
	public PromotionDao(DataSource dataSource) {
		
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("Promotion")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<Promotion> selectPromotions() {
		
		String sql = "select distinct(P.id), p.product_id, P2.category_id, C.name as category_name, P2.description, P3.file_id\r\n" + 
				"from promotion P\r\n" + 
				"left join product P2 on P.product_id = P2.id\r\n" + 
				"left join category C on P2.category_id = C.id\r\n" + 
				"left join product_image P3 on P2.id = P3.product_id\r\n" + 
				"where P3.type = 'ma'\r\n" + 
				"group by P.id";
		
		return jdbc.query(sql, rowMapper);
	}

}
