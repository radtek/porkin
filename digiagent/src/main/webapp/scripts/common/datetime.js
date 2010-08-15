/*!
 * Custom JavaScript Library v0.1
 * http://jquery.com/
 *
 * Copyright 2010, Song jie
 * Dual licensed under the MIT or GPL Version 2 licenses.
 * http://wwww.digiagent.com
 *
 * Includes 
 * xx
 * Copyright 2010, The digiagent 
 * Released under the MIT, BSD, and GPL Licenses.
 *
 * Date: Sun Aug 15 2010 00:47:42 GMT+0800 (China Standard Time)
 */

/**
 * format_cn
 *  number date type - > yyyy/MM/dd hh:mm:ss 
 */
function format_cn(value) {
	var d = new Date(value);
	var year = d.getFullYear();
	var month = d.getMonth();
	if (month < 10)
	{
		month = "0" + month;
	}
	var day = d.getDate();
	if (day < 10)
	{
		day = "0" + day;
	}
	var hour = d.getHours();
	if (hour < 10)
	{
		hour = "0" + hour;
	}
	var minute = d.getMinutes();
	if (minute < 10)
	{
		minute = "0" + minute;
	}
	var second = d.getSeconds();
	if (second < 10)
	{
		second = "0" + second;
	}
	return year + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + second;
}