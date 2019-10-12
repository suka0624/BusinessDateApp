package com.suka.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.suka.springboot.domain.BusinessDate;
import com.suka.springboot.service.BusinessDateService;

/**
 * 業務日付計算式のCRUDコントローラ
 * 
 * @author s_suka
 */
@Controller
public class BusinessDateController {

	/** 業務日付関連サービス **/
	@Autowired
	private BusinessDateService service;
	
	/**
	 * 一覧(初期)画面表示用Action
	 * @param mav ModelAndView
	 * @return 一覧画面ModelAndView
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView view(ModelAndView mav) {
		mav.setViewName("list");
		Iterable<BusinessDate> list = service.searchAll();
		mav.addObject("datalist", list);
		return mav;
	}
}
