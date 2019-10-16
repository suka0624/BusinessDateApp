package com.suka.springboot.selenide;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;

public class DeletePage {

    /**
     * 業務日付計算式を削除する
     */
    public static void 削除(){
        Selenide.$(By.id("deleteBtn")).click();
    }

}
