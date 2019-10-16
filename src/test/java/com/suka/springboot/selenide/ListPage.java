package com.suka.springboot.selenide;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;

/**
 * 一覧(/登録)画面
 * 
 * @author s_suka
 */
public class ListPage {

	/** 一覧(/登録)画面URL **/
	private static final String URL = "http://localhost:8888";
	
	/**
	 * 一覧(/登録)画面を開く
	 */
	public static void 一覧画面を表示() {
		Selenide.open(URL);
	}
	
	/**
	 * タイトル取得
	 * @return 画面タイトル
	 */
    public static String タイトル(){
        return Selenide.title();
    }
    
    /**
     * 基準日を取得する
     * 
     * @return 基準日
     */
    public static String 基準日() {
    	return Selenide.$(By.id("base")).getValue();	
    }
    
    /**
     * 登録件数を取得する
     * 
     * @return 登録件数
     */
    public static int 登録件数(){
    	// 最後の「-1」はヘッダ分
        return ( Selenide.$(By.name("formList")).$("table").$$("tr").size() - 1);
    }
    
    /**
     * 登録用に業務日付名を設定する
     * 
     * @param name 業務日付名
     */
    public static void 業務日付名は(String name) {
        Selenide.$(By.name("entryName")).setValue(name);
    }
    
    /**
     * 登録用に加減年を設定する
     * 
     * @param year 加減年
     */
    public static void 加減年は(String year) {
    	Selenide.$(By.name("entryYear")).setValue(year);
    }
    
    /**
     * 登録用に加減月を設定する
     * 
     * @param month 加減月
     */
    public static void 加減月は(String month) {
    	Selenide.$(By.name("entryMonth")).setValue(month);
    }
    
    /**
     * 登録用に加減日を設定する
     * 
     * @param day 加減日
     */
    public static void 加減日は(String day) {
    	Selenide.$(By.name("entryDay")).setValue(day);
    }
    
    /**
     * 業務日付計算用情報を新規に登録する
     */
    public static void で登録する(){
        Selenide.$(By.id("entryBtn")).click();
    }
}
