package kr.or.connect.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "kr.or.connect.reservation.service", "kr.or.connect.reservation.dao" })
@Import({ DBConfig.class })
public class ApplicationConfig {  

}
