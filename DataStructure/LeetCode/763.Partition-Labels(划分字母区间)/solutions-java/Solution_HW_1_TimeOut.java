/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */
import java.util.Set;
import java.util.HashSet;

class Solution {
    private int GLOBAL_INDEX = 0;

    /**
     * 获取分组信息
     *
     * @param word 输入字符串
     * @return 分组信息
     */
    public int[] getGroups(String word) {
        Set<String> set = new HashSet<>();
        String[] list = new String[word.length() + 2];

        for (int index = 0; index < word.length(); index++) {
            String myChar = String.valueOf(word.charAt(index));
            if (!set.contains(myChar)) {
                set.add(myChar);
                list[GLOBAL_INDEX] = myChar;
                GLOBAL_INDEX += 1;
            } else {
                addItemToList(list, myChar);
                GLOBAL_INDEX += 1;
            }
        }
        int[] ret = new int[GLOBAL_INDEX];
        for (int index = 0; index < GLOBAL_INDEX; index++) {
            ret[index] = list[index].length();
        }
        return ret;
    }

    private void addItemToList(String[] list, String c) {
        for (int index = 0; list[index] != null; index++) {
            String old = list[index];

            if (!old.contains(c)) {
                continue;
            }
            list[index] = getMergedStr(list, index, c);
        }
    }

    private String getMergedStr(String[] list, int index, String c) {
        StringBuilder ret = new StringBuilder();
        for (int i = index; list[i] != null; i++) {
            GLOBAL_INDEX -= 1;
            String old = list[i];
            ret.append(old);
            list[i] = null;
        }
        ret.append(c);
        return ret.toString();
    }

}
