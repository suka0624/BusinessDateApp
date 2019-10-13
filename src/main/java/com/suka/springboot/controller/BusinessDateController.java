package com.suka.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView register(@ModelAttribute("formModel")
		@Validated BusinessDate businessDate,
		BindingResult result, ModelAndView mav) {
		
		/** バリデーションエラー発生時 **/
		if (result.hasErrors()) {
			mav.setViewName("list");
			mav.addObject("errMsg", "Sorry, error is occured...");
			Iterable<BusinessDate> list = service.searchAll();
			mav.addObject("datalist", list);
			return mav;
		}
		
		service.register(businessDate);
		return new ModelAndView("redirect:/");
	}
	
	/**
	 * 業務日付計算用情報編集画面表示
	 * @param businessDate 業務日付計算用情報
	 * @param id 更新対象のID
	 * @param mav ModelAndView
	 * @return 編集画面ModelAndView
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute BusinessDate businessDate,
			@PathVariable int id, ModelAndView mav) {
		mav.setViewName("edit");
		Optional<BusinessDate> data = service.searchById(id);
		mav.addObject("formModel", data.get());
		return mav;
	}
	
	/**
	 * 業務日付計算用情報更新
	 * @param businessDate 業務日付計算用情報
	 * @return 一覧画面(リダイレクト)ModelAndView
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute BusinessDate businessDate) {
		service.update(businessDate);
		return new ModelAndView("redirect:/");
	}
	
	/**
	 * 業務日付計算用情報削除確認画面表示
	 * @param id 削除対象のID
	 * @param mav ModelAndView
	 * @return 削除確認画面ModelAndView
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteConfirm(@PathVariable int id, ModelAndView mav) {
		mav.setViewName("delete");
		Optional<BusinessDate> data = service.searchById(id);
		mav.addObject("formModel",data.get());
		return mav;
	}
	
	/**
	 * 業務日付計算用情報削除
	 * 
	 * @param businessDate 業務日付計算用情報
	 * @return 一覧画面(リダイレクト)ModelAndView
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute BusinessDate businessDate) {
		service.delete(businessDate);
		return new ModelAndView("redirect:/");		
	}
}
