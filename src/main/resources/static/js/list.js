/**
 * 一覧画面用JavaScriptファイル
 */

/**
 * ページ読み込み時処理
 */
$(document).ready( function(){
	/** 現在日を基準日のデフォルト値に設定 **/
	var currentDay = new Date();
	var year = currentDay.getFullYear();
	var month = currentDay.getMonth()+1;
	var day = currentDay.getDate();
	var currentDayStr = year + '/' + month + '/' + day;
	$('#base').val(currentDayStr);
});

/**
 * 基準日を元に業務日付を計算する
 * @param obj 業務日付計算用オブジェクト
 */
function calc(obj) {
	/** 計算式を`/(スラッシュ)`で分割 **/
	var formula = obj.parentNode.parentNode.cells[2].innerText;
	var splitFormula = formula.split("/");

	/** 基準日に計算式の値を加減 **/
	var base = new Date($('#base').val());
	base.setFullYear(base.getFullYear() + parseInt(splitFormula[0]));
	base.setMonth(base.getMonth() + parseInt(splitFormula[1]));
	base.setDate(base.getDate() + parseInt(splitFormula[2]));
	
	/** 計算結果に値を設定 **/
	obj.parentNode.parentNode.cells[4].innerText = getYMD(base);
}

/**
 * 引数で指定された日付をYYYY/MM/DD形式の文字列に変換する
 * @param date
 * @returns YYYY/MM/DD形式の日付文字列
 */
function getYMD(date){
	var y = date.getFullYear();
	var m = ("00" + (date.getMonth()+1)).slice(-2);
	var d = ("00" + date.getDate()).slice(-2);
	var result = y + "/" + m + "/" + d;
	return result;
}