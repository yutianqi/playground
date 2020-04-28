/**
 * Quick Sort Test
 *
 * @author y00290641
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] array = {7, 8, 3, 1, 6, 9};
        quickSort(array);
        println(array);
    }
       
    public static void quickSort(int[] array) {
        subQuickSort(array, 0, array.length -1);
    }

    public static void subQuickSort(int[] array, int beginIndex, int endIndex) {
        // 快排递归的终止条件是排序区间的beginIndex大于等于endIndex
        if (beginIndex >= endIndex) {
            return;
        }
        // 找出区间分割点
        int pivotIndex = partion(array, beginIndex, endIndex);
        // 对分割出来的两个区间递归排序
        subQuickSort(array, beginIndex, pivotIndex-1);
        subQuickSort(array, pivotIndex+1, endIndex);        
    }
    
    public static int partion(int[] array, int beginIndex, int endIndex) {
        System.out.println("before:");
        println(array, beginIndex, endIndex);
        // 默认选择排序区间的最后一个元素为pivot
        int pivot = array[endIndex];
        // 设置左区间起始值为第一个值，即默认左区间为空
        int i = beginIndex;
        // 从排序区间第一个数据开始，直到倒数第二个数据，进行分区
        for (int j = beginIndex; j <= endIndex-1; j++) {
            // 当找到小于pivot的元素，通过交换的方式，将其放到左区间，也就是array[i]的位置
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
        System.out.println("after:");
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
 
 
 