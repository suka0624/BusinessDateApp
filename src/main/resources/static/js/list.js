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