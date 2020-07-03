package com.example.springbootmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.example.springbootmybatisplus.mapper"})
@SpringBootApplication
public class SpringbootMybatisPlusApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisPlusApplication.class, args);
	}
}
