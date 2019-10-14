package com.suka.springboot.repository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.dao.DataIntegrityViolationException;
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
	
	@Test
	public void ID指定した1件が取得できること() throws Exception {
		Optional<BusinessDate> data = businessDateRepository.selectById(3);
		
		assertThat(data.get().getName()).isEqualTo("1日前");
		assertThat(data.get().getYear()).isEqualTo(0);
		assertThat(data.get().getMonth()).isEqualTo(0);
		assertThat(data.get().getDay()).isEqualTo(-1);
	}
	
	@Test
	public void 存在しないデータを検索すると結果がOputional_emptyとなること() throws Exception {
		Optional<BusinessDate> data = businessDateRepository.selectById(4);
		
		assertThat(data).isEqualTo(Optional.empty());
	}

	@Test
	public void 新規登録ができること() throws Exception {
		BusinessDate registerData = createBusinessDate(4,"6ヶ月後",0,6,0);
		
		businessDateRepository.insert(registerData);
		Optional<BusinessDate> data = businessDateRepository.selectById(4);
		
		assertThat(data.get().getId()).isEqualTo(4);
	}
	
	@Test
	public void 指定の1件が更新できること() throws Exception {
		BusinessDate updateData = createBusinessDate(1,"6ヶ月前",0,-6,0);
		
		businessDateRepository.update(updateData);
		Optional<BusinessDate> data = businessDateRepository.selectById(1);
		
		assertThat(data.get().getId()).isEqualTo(1);
		assertThat(data.get().getName()).isEqualTo("6ヶ月前");
		assertThat(data.get().getYear()).isEqualTo(0);
		assertThat(data.get().getMonth()).isEqualTo(-6);
		assertThat(data.get().getDay()).isEqualTo(0);		
	}
	
	@Test
	public void 指定の1件が削除できること() throws Exception {
		Optional<BusinessDate> data = businessDateRepository.selectById(1);
		businessDateRepository.delete(data.get());
		
		List<BusinessDate> list = businessDateRepository.selectAll();
		
		assertThat(list.size()).isEqualTo(2);
	}

	@Test
	public void NULLで登録しようとするとDataIntegrityViolationExceptionとなる事() throws Exception {

		assertThatThrownBy(() -> {
			businessDateRepository.insert(null);
		}).isInstanceOf(DataIntegrityViolationException.class);
	}
	
	private BusinessDate createBusinessDate(long id, String name, int year, int month, int day) {
		BusinessDate businessDate = new BusinessDate();
		businessDate.setId(id);
		businessDate.setName(name);
		businessDate.setYear(year);
		businessDate.setMonth(month);
		businessDate.setDay(day);
		return businessDate;
	}
}
