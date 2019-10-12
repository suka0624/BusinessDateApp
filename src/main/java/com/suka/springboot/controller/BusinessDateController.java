package com.suka.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	 * 一覧(初期)画面表示
	 * 
	 * @param businessDate 業務日付計算用情報
	 * @param mav ModelAndView
	 * @return 一覧画面ModelAndView
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView view(@ModelAttribute("formModel") BusinessDate businessDate, ModelAndView mav) {
		mav.setViewName("list");
		Iterable<BusinessDate> list = service.searchAll();
		mav.addObject("datalist", list);
		return mav;
	}
	
	/**
	 * 業務日付計算用情報登録
	 * @param businessDate 業務日付計算用情報
	 * @return 一覧画面(リダイレクト)ModelAndView
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("formModel") BusinessDate businessDate) {
		service.register(businessDate);
		return new ModelAndView("redirect:/");
	}
}
