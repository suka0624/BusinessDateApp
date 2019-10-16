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
     * 
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
     * 
     * @throws Exception
     */
    @Test
    public void 業務日付用計算式を新規に登録する() throws Exception {
    	
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
    	
    	/** 登録内容の確認 **/
    	assertThat(ListPage.名前(4)).isEqualTo("3ヶ月後");
    	assertThat(ListPage.計算式(4)).isEqualTo("0/3/0");
    }
    
    /**
     * 業務日付を計算する
     * 
     * @throws Exception
     */
    @Test
    public void 業務日付を計算する() throws Exception {
    	
    	ListPage.一覧画面を表示();
    	
    	/** IDのもっとも大きいデータ(1日前)を用いて、業務日付を計算する **/
    	ListPage.基準日は("2019/10/10");
    	ListPage.でIDのもっとも大きいデータ_1日前_の業務日付を計算する();
    	
    	/** 計算結果を確認する **/
    	int id = ListPage.登録件数();
    	assertThat(ListPage.計算結果(id)).isEqualTo("2019/10/09");
    }
    
    @Test
    public void 業務日付計算式を更新する() throws Exception {
    	
    	ListPage.一覧画面を表示();
    	
    	/** 業務日付計算式の編集画面に遷移 **/
    	ListPage.編集画面に遷移(1);		// ID:1を指定
    	
    	/** 業務日付計算式を編集する **/
    	EditPage.業務日付名は("1年1ヶ月1日後");
    	EditPage.加減年は("1");
    	EditPage.加減月は("1");
    	EditPage.加減日は("1");
    	EditPage.で更新する();
    	
    	/** 一覧画面に戻るので、更新内容を確認する **/
    	assertThat(ListPage.名前(1)).isEqualTo("1年1ヶ月1日後");
    	assertThat(ListPage.計算式(1)).isEqualTo("1/1/1");    	
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
