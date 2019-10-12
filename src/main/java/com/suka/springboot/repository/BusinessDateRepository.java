package com.suka.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.suka.springboot.domain.BusinessDate;

/**
 * 業務日付計算用リポジトリ
 * 
 * @author s_suka
 */
@Mapper
public interface BusinessDateRepository {
	
	/**
	 * 業務日付計算式の全件取得
	 * 
	 * @return 業務日付計算式の一覧
	 */
	@Select("SELECT * FROM business_date")
	List<BusinessDate> selectAll();
}
