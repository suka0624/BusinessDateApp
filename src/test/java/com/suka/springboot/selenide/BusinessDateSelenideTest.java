package com.suka.springboot.selenide;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.suka.springboot.BusinessDateAppApplication;

import static org.assertj.core.api.Assertions.assertThat;

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
    
    @Test
    public void 一覧画面表示時のUI確認() throws Exception {
    	
    	ListPage.一覧画面を表示();
    	
    	assertThat(ListPage.タイトル()).isEqualTo("業務日付管理");
    	
    }
}
