public class Test {
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








 