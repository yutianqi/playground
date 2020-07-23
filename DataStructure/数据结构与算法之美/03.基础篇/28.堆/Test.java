
import java.util.*;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] myArray = {0, 33, 17, 21, 16, 13, 15, 9, 5, 6, 7, 8, 1, 2, 22};
        
        Heap heap = new Heap(myArray.length);
        heap.buildHeap(myArray, myArray.length-1);
        
        
        for (int element: myArray) {
           System.out.println(element);
        }
        
        
        
    }
    
    
    public <T> T getByPath(String path) {
        String str = initPath(path);
        int idx = str.indexOf('.');
        if (idx < 0) {
            return (T) null;
        } else {
            return getByPath(str, idx);
        }
    }
    
    
    
    private <T> T getByPath(String path, int idx) {
        String parentPath = path.substring(0, idx);
        // Object parentObj = data.get(parentPath);
        // if (parentObj instanceof DataService) {
        if (true) {
            
            int dIdx = path.indexOf('\'');
            int nIdx;
            if (dIdx > idx) {
                int endIdx = path.indexOf('\'', dIdx + 1);
                nIdx = path.indexOf('.', endIdx + 1);
            } else {
                nIdx = path.indexOf('.', idx + 1);
            }
            if (nIdx < 0) {
                String leafStr = path.substring(idx + 1);
                /*
                DataService dataService = (DataService) parentObj;
                return (T) dataService.getData(leafStr);
                */
                return null;
            } else {
                String childPath = path.substring(idx + 1, nIdx);
                String leafPath = path.substring(nIdx + 1);
                /*
                DataService dataService = (DataService) parentObj;
                */
                Object childObject = null;
                if (childObject == null) {
                    System.out.println("childObject is null. path=[" + path + "]");
                    return null;
                }
                /*
                if (childObject instanceof Map) {
                    return getForMap(leafPath, (Map<String, Object>) childObject);
                } else {
                    return (T) ognlGetValue(leafPath, childObject);
                }
                */
            }
        } else if (parentObj instanceof Map) {
            String childPath = path.substring(idx + 1);
            //return getForMap(childPath, (Map<String, Object>) parentObj);
            return null;
        } else {
            // return getInnerPath(path);
            return null;
        }
    }
    

}