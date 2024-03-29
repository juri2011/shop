package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/* @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) 
	DB를 설정하지 않았을 때 JPA 설정 묶어두기
*/
@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

}
