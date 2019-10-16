package com.suka.springboot.selenide;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;

public class EditPage {

    /**
     * 変更用に業務日付名を設定する
     * 
     * @param name 業務日付名
     */
    public static void 業務日付名は(String name) {
        Selenide.$(By.name("name")).setValue(name);
    }
    
    /**
     * 変更用に加減年を設定する
     * 
     * @param year 加減年
     */
    public static void 加減年は(String year) {
    	Selenide.$(By.name("year")).setValue(year);
    }
    
    /**
     * 変更用に加減月を設定する
     * 
     * @param month 加減月
     */
    public static void 加減月は(String month) {
    	Selenide.$(By.name("month")).setValue(month);
    }
    
    /**
     * 変更用に加減日を設定する
     * 
     * @param day 加減日
     */
    public static void 加減日は(String day) {
    	Selenide.$(By.name("day")).setValue(day);
    }

    /**
     * 業務日付計算式を更新する
     */
    public static void で更新する(){
        Selenide.$(By.id("updateBtn")).click();
    }
}
