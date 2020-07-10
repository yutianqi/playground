import java.util.List;
import java.util.ArrayList;


/**
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */


public class Test {
    /*
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> ret = solution.partitionLabels("ababcbacadefegdehijhklij");
        print(ret);
    }

    private static void print(List<Integer> arr) {
        for(int item: arr) {            
            System.out.println(item);
        }
    }
    */
    
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ret = solution.getGroups("ababcbacadefegdehijhklij");
        print(ret);
    }

    private static void print(int[] arr) {
        for(int item: arr) {            
            System.out.println(item);
        }
    }
    
    
}


