/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

/*
测评链接:https://e.leetcode-cn.com/assessment/huawei-0441
测评账号:A5276
密  码:eA6OvkA60k
*/

import java.util.*;

public class Test {

    private static int global_index = 0;
    public static void main(String[] args) {
        System.out.println(getGroups("ijddacfafh"));

    }

    public static int[] getGroups(String word) {
        Set<String> set = new HashSet<>();
        // LinkedList<String> list = new LinkedList<>();
        String[] list = new String[word.length()];

        for (int i = 0; i < word.length(); i++) {
            String c = String.valueOf(word.charAt(i));

            if(!set.contains(c)) {
                set.add(c);
                // list.push(c);
                list[global_index] = c;
                global_index += 1;
            } else {
                System.out.println("发现重复的字符" + c);
                addItemToList(list, c);
                global_index += 1;
            }
            print(list);
        }

        System.out.println("finish");
        print(list);
        int[] ret = new int[global_index-1];

        for (int i = 0; i < global_index-1; i++) {
            ret[i] = list[i].length();
        }

        return ret;
    }


    private static void print(String[] items) {
        StringBuilder sb = new StringBuilder();
        for (String item: items) {
            sb.append(item).append(",");
        }
        System.out.println(sb.toString());
    }


    public static void addItemToList(String[] list, String c) {
        for (int i = 0; list[i] != null; i++) {
            String old = list[i];

            if (!old.contains(c)) {
                continue;
            }
            list[i] = getMergedStr(list, i, c);
        }
    }


    public static String getMergedStr(String[] list, int index, String c) {
        StringBuilder ret = new StringBuilder();
        for (int i = index; list[i] != null; i++) {
            global_index -= 1;
            String old = list[i];
            ret.append(old);
            list[i] = null;
        }
        ret.append(c);
        return ret.toString();
    }

}