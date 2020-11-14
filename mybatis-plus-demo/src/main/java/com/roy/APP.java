package com.roy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description： MP初步集成，兴建一个扫描到的接口、实体类即可
 * author：dingyawu
 * date：created in 13:09 2020/11/12
 * history:
 */
@SpringBootApplication
@MapperScan("com.roy.mapper")
public class APP {

	public static void main(String[] args) {
		SpringApplication.run(APP.class, args);
	}

}
