/**
 * Find the nth number test
 *
 * @author y00290641
 */
public class FindTheNthNum {
    public static void main(String[] args) {
        int[] array = {7, 8, 3, 1, 6, 9};
        int n = 3;
        int nthNum = findTheNthNum(array, n, 0, array.length-1);
        System.out.println("The " + n + "th num is " + nthNum); 
        
    }

    public static int findTheNthNum(int[] array, int n, int beginIndex, int endIndex) {
        int pivotIndex = partion(array, beginIndex, endIndex);
        
        while (pivotIndex != n) {
            if (pivotIndex > n) {
                pivotIndex = partion(array, beginIndex, pivotIndex-1);
            } else if (pivotIndex < n) {
                pivotIndex = partion(array, pivotIndex+1, endIndex);
            }
        }
        return array[pivotIndex];
    }
    
    public static int partion(int[] array, int beginIndex, int endIndex) {
        int pivot = array[endIndex];

        int i = beginIndex;

        for (int j = beginIndex; j <= endIndex-1; j++) {
            if (array[j]<pivot) {
                int tmp1 = array[i];
                array[i] = array[j];
                array[j] = tmp1;
                i += 1;
            }            
        }
        int tmp2 = array[i];
        array[i] = array[endIndex];
        array[endIndex] = tmp2;
        
        System.out.println("privot:" + pivot + " index:" + i);
        println(array, beginIndex, endIndex);
        return i;
    }
    
    
    public static void println(int[] a) {
        for (int i = 0; i < a.length; i++) {
        System.out.println(a[i]);            
        }
    } 

    public static void println(int[] a, int beginIndex, int endIndex) {
        for (int i = beginIndex; i <=endIndex; i++) {
            System.out.print(a[i]);            
            System.out.print(" ");
        }
        System.out.println("");            
    }    
}
 
 
 