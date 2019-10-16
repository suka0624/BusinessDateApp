package com.suka.springboot.selenide;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.suka.springboot.BusinessDateAppApplication;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 業務日付管理画面テスト
 * 
 * @author s_suka
 */
public class BusinessDateSelenideTest {
	
	/**
	 * テスト前処理
	 */
	@BeforeClass
	public static void setUpClass() {
		
		/** テスト対象アプリの起動 **/
		BusinessDateAppApplication.main(new String[] {
                "--server.port=8888",
                "--spring.profiles.active=test"
		});
		
		/** ブラウザの指定(Chrome) **/
		/** (何も指定しないとFirefoxになる模様) **/
		Configuration.browser = WebDriverRunner.CHROME;
	}
	
	/**
	 * テスト後処理
	 */
    @AfterClass
    public static void tearDownClass() {
    	
    	/** ブラウザを閉じる **/
        WebDriverRunner.closeWebDriver();
    }
    
    /**
     * 一覧画面の表示内容を確認する
     * @throws Exception
     */
    @Test
    public void 一覧画面表示時のUI確認() throws Exception {
    	
    	ListPage.一覧画面を表示();
    	
    	/** 画面タイトルが”業務日付管理”であることをテスト **/
    	assertThat(ListPage.タイトル()).isEqualTo("業務日付管理");
    	
    	/** デフォルトの基準日が現在日であることをテスト **/
    	assertThat(ListPage.基準日()).isEqualTo(getCurrent());
    }
    
    /**
     * 業務日付用計算式を新規登録する
     * @throws Exception
     */
    @Test
    public void 業務日付用計算式() throws Exception {
    	
    	ListPage.一覧画面を表示();
    	
    	/** 登録前の件数確認 **/
    	assertThat(ListPage.登録件数()).isEqualTo(3);
    	
    	/** 業務日付用計算式の新規登録 **/
    	ListPage.業務日付名は("3ヶ月後");
    	ListPage.加減年は("0");
    	ListPage.加減月は("3");
    	ListPage.加減日は("0");
    	ListPage.で登録する();
    	
    	/** 登録後の件数確認 **/
    	assertThat(ListPage.登録件数()).isEqualTo(4);    	
    }
    
    /**
     * 現在日をYYYY/MM/DD形式で返却する
     * 
     * @return 現在日(YYYY/MM/DD形式)
     */
    private String getCurrent() {
    	LocalDateTime now = LocalDateTime.now();
    	DateTimeFormatter dfNow = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	return now.format(dfNow);
    }
}
