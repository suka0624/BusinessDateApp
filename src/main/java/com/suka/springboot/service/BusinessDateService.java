package com.suka.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suka.springboot.domain.BusinessDate;
import com.suka.springboot.repository.BusinessDateRepository;

/**
 * 業務日付に関するサービス
 * 
 * @author s_suka
 */
@Service
public class BusinessDateService {

	/** 業務日付計算用リポジトリ **/
	@Autowired
	private BusinessDateRepository repository;
	
	/**
	 * 業務日付計算用情報を全件取得する
	 * 
	 * @return 業務日付計算用情報一覧
	 */
	public List<BusinessDate> searchAll() {
		return repository.selectAll();
	}
	
	/**
	 * 業務日付計算用情報を取得する
	 * 
	 * @param id 業務日付計算用情報シーケンスID
	 * @return 業務日付計算用情報
	 */
	public Optional<BusinessDate> searchById(int id) {
		return repository.selectById(id);
	}
	
	/**
	 * 業務日付計算用情報を登録する
	 * 
	 * @param businessDate 業務日付計算用情報
	 */
	@Transactional(readOnly = false)
	public void register(BusinessDate businessDate) {
		repository.insert(businessDate);
	}
	
	/**
	 * 業務日付計算用情報を更新する
	 * 
	 * @param businessDate 業務日付計算用情報
	 */
	@Transactional(readOnly = false)
	public void update(BusinessDate businessDate) {
		repository.update(businessDate);
	}
	
	/**
	 * 業務日付計算用情報を削除する
	 * 
	 * @param businessDate 業務日付計算用情報
	 */
	@Transactional(readOnly = false)
	public void delete(BusinessDate businessDate) {
		repository.delete(businessDate);
	}
}
