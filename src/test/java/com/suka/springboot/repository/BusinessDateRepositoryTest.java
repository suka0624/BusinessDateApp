package com.suka.springboot.repository;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.suka.springboot.domain.BusinessDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@MybatisTest
public class BusinessDateRepositoryTest {
	
	@Autowired
	private BusinessDateRepository businessDateRepository;

	@Test
	public void 全件検索してリストが取得できること() throws Exception {
		List<BusinessDate> list = businessDateRepository.selectAll();
		
		assertThat(list.size()).isEqualTo(3);
	}
	
	

}
