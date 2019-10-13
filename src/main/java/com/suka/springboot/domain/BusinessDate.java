package com.suka.springboot.domain;

import javax.validation.constraints.NotEmpty;

/**
 * 業務日付計算用
 * 
 * @author s_suka
 */
public class BusinessDate {
	
	/** 業務日付計算式ID **/
    private Long id;
    /** 業務日付計算式名 **/
    @NotEmpty
    private String name;
    /** 加減年 **/
    private int year;
    /** 加減月 **/
    private int month;
    /** 加減日 **/
    private int day;
 
    /**
     * 業務日付計算式ID取得
     * 
     * @return 業務日付計算式ID
     */
	public Long getId() {
		return id;
	}
	
	/**
	 * 業務日付計算式ID設定
	 * 
	 * @param id 業務日付計算式ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 業務日付計算式名取得
	 * 
	 * @return 業務日付計算式名
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 業務日付計算式名設定
	 * 
	 * @param name 業務日付計算式名
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 加減年取得
	 * 
	 * @return 加減年
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * 加減年設定
	 * 
	 * @param year 加減年
	 */
	public void setYear(int year) {
		this.year = year;
	}
 
	/**
	 * 加減月取得
	 * 
	 * @return 加減月
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * 加減月設定
	 * 
	 * @param month 加減月
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * 加減日取得
	 * 
	 * @return 加減日
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * 加減日設定
	 * 
	 * @param day 加減日
	 */
	public void setDay(int day) {
		this.day = day;	
	}
}
