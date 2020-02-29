import java.util.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class Test {
    private static List<Double> numList = new ArrayList<>();
    private static List<String> operatorList = new ArrayList<>();

    private static Map<String, Integer> priorityMap = new HashMap<>();
    
    private static String currentOperator = "";

    static {
        priorityMap.put("",  0);
        priorityMap.put("(", 0);
        priorityMap.put("+", 2);
        priorityMap.put("-", 2);
        priorityMap.put("*", 3);
        priorityMap.put("/", 3);
        priorityMap.put(")", 4);
    }

    public static void main(String[] args) {
        String expr;
        expr = "3+5*8-6";
        expr = "10-3-4";
        expr = "10-3*4+20-10-4*3/2";
        expr = "10-(12-8+3)*2";
        // expr = "10-3*4+(20-10-4)*3/2";
        

        System.out.println(solution(expr));
    }

    private static double solution(String listNode) {
        double num = 0.0;
        boolean afterK = false;
        for (int i = 0; i < listNode.length(); i++) {
            char c = listNode.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                currentOperator = String.valueOf(c);
                
                if (afterK) {
                    afterK = false;
                }
                else if (!currentOperator.equals("(")) {
                    System.out.println("-> " + num);
                    numList.add(num);
                    System.out.println("numList: " + numList);
                    System.out.println("operatorList: " + operatorList);               
                    num = 0.0;                    
                }

                System.out.println("-> " + currentOperator);
                if (!currentOperator.equals(")")) {
                    clearList();
                    operatorList.add(currentOperator);
                }
                else {
                    clearParentheses();
                    afterK = true;
                }
                
                System.out.println("numList: " + numList);
                System.out.println("operatorList: " + operatorList);               
            }
        }
        numList.add(num);

        fianlClearList();

        return numList.remove(0);
    }

    private static void fianlClearList() {
        System.out.println("Begin to final clear list");
        System.out.println("numList: " + numList);
        System.out.println("operatorList: " + operatorList);

        while (numList.size() > 1) {
            Double num1 = numList.remove(numList.size() - 1);
            Double num2 = numList.remove(numList.size() - 1);
            String stackOperator = operatorList.remove(operatorList.size() - 1);
            Double result = calculate(num2, stackOperator, num1);
            System.out.println(num2 + stackOperator + num1 + "=" + result);
            numList.add(result);    
        }
    }
    
    private static void clearParentheses() {
        System.out.println("--> 清空括号");
        String stackOperator = operatorList.remove(operatorList.size() - 1);
        while (!stackOperator.equals("(")) {
            Double num1 = numList.remove(numList.size() - 1);
            Double num2 = numList.remove(numList.size() - 1);
            Double result = calculate(num2, stackOperator, num1);
            System.out.println(num2 + stackOperator + num1 + "=" + result);
            numList.add(result);    
            stackOperator = operatorList.remove(operatorList.size() - 1);
        }
    }
    
    /**
     * 清数据
     *
     * 有两种方式：
     *   1.清空全栈数据：这种方式带来的问题是比较操作符的时候是否要带上=
     *     如包含=，5+4*3/2-1，在/2的时候会先运算5+4*3，导致运算优先级错误。
     *     如不包含=，5-4-3，最终运算对象为[5,4,3]，[-,-]，运算过程为4-3=1，5-1=4，对于-的操作会存在问题
     *     综上，全表清是不行的
     *
     *   2.只清空操作优先级比当前操作符高的数据
     *     连续比较操作符优先级清空，比较操作符的时候带上=
     */
    private static void clearList() {

        while (!operatorList.isEmpty() && numList.size() > 1 && isHigherPriority(operatorList.get(operatorList.size() - 1), currentOperator)) {
            String stackOperator = operatorList.remove(operatorList.size() - 1);
            
            System.out.println("堆栈操作符 " + stackOperator + "优先级高于当前操作符 " + currentOperator + ". Clear.");

            /*
            if (stackOperator.equals("(")) {
                inParentheses = false;
                numList.remove(numList.size() - 1);
                continue;
            }
            */

            Double num1 = numList.remove(numList.size() - 1);
            Double num2 = numList.remove(numList.size() - 1);
            Double result = calculate(num2, stackOperator, num1);
            System.out.println(num2 + stackOperator + num1 + "=" + result);
            numList.add(result);
        }
    }

    /**
     * 操作符优先级比较，比较操作符的时候带上=
     */
    private static boolean isHigherPriority(String stackOperator, String currentOperator) {
        return priorityMap.get(stackOperator) >= priorityMap.get(currentOperator);
    }

    /**
     * 四则运算
     */
    private static Double calculate(Double leftNum, String operator, Double rightNum) {
        switch(operator) {
            case "+" :
                return leftNum + rightNum;
            case "-":
                return leftNum - rightNum;
            case "*":
                return leftNum * rightNum;
            case "/":
                return leftNum / rightNum;
            default:
                return 0.0;
        }
    }

}