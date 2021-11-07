/**
 * 
 */
package com.nkt.news.utils;

/**
 * Description: 文本域转换为HTML工具类
 * Program Name: StringUtils.java
 * Date: 2020年4月17日
 * 
 * @author WangXing
 */
public class StringUtils {
	/**
     * 将普通文本转换成html文本，避免html显示错误现象
     * @param str String
     * @return String
     */
    public String toHtml(String str) {
        if(str == null)
            return null;
        StringBuffer sb = new StringBuffer();
        //获取字符串的长度
        int len = str.length();
 
        //转换特殊字符串
        for(int i = 0; i < len; i++) {
            char c = str.charAt(i);
            switch(c) {
            case ' ':
                sb.append("&nbsp;");
                break;
            case '\n':
                sb.append("<br>");
                break;
            case '\r':
                break;
            case '\'':
                sb.append("&#39;");
                break;
            case '<':
                sb.append("&lt;");
                break;
            case '>':
                sb.append("&gt;");
                break;
            case '&':
                sb.append("&amp;");
                break;
            case '"':
                sb.append("&#34");
                break;
            case '\\':
                sb.append("&#92");
                break;
            default:
                sb.append(c);
            }//end switch
        }//end for
 
        return sb.toString();
    }

}
