package com.wjy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 搜索简单分词
 */
public class SearchSimpleSplitWordUtil {

    /**
     * 获取传入字符串的所有单个字符数组，仅对数字特殊处理。
     * 初始会对字符串的特殊字符进行去除，如空格，-，_等
     *
     * @param str
     * @return
     */
    public static List<String> splitWord(String str) {
        List<String> list = new ArrayList<>();
        String[] regs = new String[]{" ", "-", "_"};
        for (String reg : regs) {
            str = str.replaceAll(reg, "");
        }
        String num = "";
        for (int i = 0; i < str.length(); i++) {
            String x = str.charAt(i) + "";
            if (isNumberic(x)) {
                num += x;
            } else {
                if (!num.equals("")) {
                    list.add(num);
                    num = "";
                }
                list.add(x);
            }
        }
        if (!num.equals("")) {
            list.add(num);
        }
        return list;
    }

    /**
     * 判断是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumberic(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

}
