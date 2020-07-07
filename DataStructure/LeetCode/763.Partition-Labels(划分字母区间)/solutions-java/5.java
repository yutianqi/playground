/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

/*
测评链接:https://e.leetcode-cn.com/assessment/huawei-0441
测评账号:A5276
密  码:eA6OvkA60k
*/

import java.util.*;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {


        getGroups("ijddacfafh");

    }


    public static int[] getGroups(String word) {
        Set<String> set = new HashSet<>();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            String c = String.valueOf(word.charAt(i));

            if(!set.contains(c)) {
                set.add(c);
                list.push(c);
            } else {
                addItemToList(list, c);
            }
        }

        System.out.println(list);

        return null;
    }


    public static void addItemToList(LinkedList<String> list, String c) {
        for (int i = 0; i < list.size(); i++) {
            String old = list.get(i);

            if (!old.contains(c)) {
                continue;
            }
            getMergedStr(list, i, c);
        }
    }


    public static String getMergedStr(LinkedList<String> list, int index, String c) {
        String ret = c;
        for (int i = list.size()-1; i >= index; i++) {
            String old = list.pop();
            ret = old+ ret;
        }
        return ret;
    }

}