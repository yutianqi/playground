import java.util.List;
import java.util.ArrayList;

public class Test {
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
}


