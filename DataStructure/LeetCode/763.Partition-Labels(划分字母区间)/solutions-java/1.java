/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */


class Solution {
    private Map<String, Integer> map = new HashMap<>();

    /**
     * 获取分组信息
     *
     * @param word 输入字符串
     * @return 分组信息
     */
    public int[] getGroups(String word) {
        List<Integer> aList = new ArrayList<>();
        for (int index = 0; index < word.length(); index++) {
            String myChar = String.valueOf(word.charAt(index));
            if (!map.keySet().contains(myChar)) {
                map.put(myChar, index);
                aList.add(index);
            } else {
                aList.add(map.get(myChar));
            }
        }

        List<Integer> ret = new ArrayList<>();
        int index = aList.size()-1;
        while (index >=0) {
            if (aList.get(index) == index) {
                ret.add(0, 1);
                index--;
            } else {
                int range = find(aList,aList.get(index), index);
                ret.add(0, range);
                index = index - range;
            }
        }

        int[] array = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            array[i] = ret.get(i);
        }
        return array;
    }

    private int find(List<Integer> aList, int begin, int end) {
        int index = end;
        while(index >= begin) {
            if (aList.get(index) != index) {
                begin = aList.get(index);
            }
            index -=1;
        }
        int range = end - index;
        return range;
    }
    
    
    
}