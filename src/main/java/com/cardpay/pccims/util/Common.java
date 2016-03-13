/**
 * 
 * @author licho
 * 
 */
package com.cardpay.pccims.util;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

public class Common {

	// 后台访问
	public static final String BACKGROUND_PATH = "WEB-INF/jsp";
	
	// 默认除法运算精度
	private static final int DEF_DIV_SCALE = 10;
	
	public static boolean isNullOrEmpty(String s) {
		if(null == s || s.trim().isEmpty()) {
			return true;
		}else{
			return false;
		}				
	}
	
	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 获取登录账号的对象	
	 * @param request
	 * @return
	 */
	public static Object findUserSession(HttpServletRequest request) {
		return (Object) request.getSession().getAttribute("userSession"); 
	}
	
	/**
	 * html转议
	 * 
	 * @descript
	 * @param content
	 * @return
	 * @author licho
	 * @date 
	 * @version 1.0
	 */
	public static String stringtohtml(String content) {
		if (content == null)
			return "";
		String html = content;
		html = html.replace("&apos;", "'");
		html = html.replaceAll("&amp;", "&");
		html = html.replace("&quot;", "\""); // "
		html = html.replace("&nbsp;&nbsp;", "\t");// 替换跳格
		html = html.replace("&nbsp;", " ");// 替换空格
		html = html.replace("&lt;", "<");
		html = html.replaceAll("&gt;", ">");

		return html;
	}
}
