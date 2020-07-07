class Solution {



    private int global_index = 0;

    public int[] getGroups(String word) {
        Set<String> set = new HashSet<>();
        String[] list = new String[word.length()+2];

        for (int i = 0; i < word.length(); i++) {
            String c = String.valueOf(word.charAt(i));

            if(!set.contains(c)) {
                set.add(c);
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
        int[] ret = new int[global_index];

        for (int i = 0; i < global_index; i++) {
            ret[i] = list[i].length();
        }

        return ret;
    }


    private void print(String[] items) {
        StringBuilder sb = new StringBuilder();
        for (String item: items) {
            sb.append(item).append(",");
        }
        System.out.println(sb.toString());
    }


    public void addItemToList(String[] list, String c) {
        for (int i = 0; list[i] != null; i++) {
            String old = list[i];

            if (!old.contains(c)) {
                continue;
            }
            list[i] = getMergedStr(list, i, c);
        }
    }


    public String getMergedStr(String[] list, int index, String c) {
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