/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 *
 * 可信考试中使用这种解法超时
 */
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    private int GLOBAL_INDEX = 0;

    /**
     * 获取分组信息
     *
     * @param word 输入字符串
     * @return 分组信息
     */
    public List<Integer> partitionLabels(String word) {
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
        List<Integer> ret = new ArrayList<>();
        for (int index = 0; index < GLOBAL_INDEX; index++) {
            ret.add(list[index].length());
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
