package com.suka.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	/**
	 * 指定の業務日付計算式取得
	 * @param id 業務日付計算式のシーケンスID
	 * @return 業務日付計算式
	 */
	@Select("SELECT * FROM business_date WHERE id = #{id}")
	Optional<BusinessDate> selectById(int id);
	
	/**
	 * 業務日付計算式の登録
	 * 
	 * @param businessDate 業務日付計算式
	 */
	@Insert("INSERT INTO business_date (`name`, `year`, `month`, `day`) VALUES (#{name}, #{year}, #{month}, #{day})")
	void insert(BusinessDate businessDate);
	
	/**
	 * 業務日付計算式の更新
	 * 
	 * @param businessDate 業務日付計算式
	 */
	@Update("UPDATE business_date SET name = #{name}, year = #{year}, month = #{month}, day = #{day} WHERE id = #{id}")
	void update(BusinessDate businessDate);
}
