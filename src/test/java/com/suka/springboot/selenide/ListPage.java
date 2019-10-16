package com.suka.springboot.selenide;

import com.codeborne.selenide.Selenide;

/**
 * 一覧(/登録)画面
 * 
 * @author s_suka
 */
public class ListPage {

	/** 一覧(/登録)画面URL **/
	private static final String URL = "http://localhost:8080";
	
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
}
