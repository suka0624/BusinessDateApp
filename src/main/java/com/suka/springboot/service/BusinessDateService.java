package com.suka.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	/** 業務日付計算式の全件取得 **/
	public List<BusinessDate> searchAll() {
		return repository.selectAll();
	}
}
