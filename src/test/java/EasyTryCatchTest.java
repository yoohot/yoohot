import java.util.ArrayList;

import java.util.List;

 

/**

 * 使用预热模式 JVM参数：-XX:PrintCompilation

 * 目标：测试在循环中使用try/catch对性能的影响

 *

 * @author 范芳铭

 */

public class EasyTryCatchTest {

    List<String>aList = new ArrayList<String>();

    private static final ArrayList<String> s =new ArrayList<String>(1);
    
    
    public static void main(String[] args) throws Exception {
    	ArrayList<String> o=s;
    	o.add("1");
    	System.out.println(s.get(0));
    	
    	
    	
    	
    	

        int warmUpCycles = 10000000; // 预热次数

        int testCycles   = 50000000; // 正式执行次数

 

        EasyTryCatchTest se = new EasyTryCatchTest();

 

        System.out.println("...预热循环开始 ...");

        long catchTime = se.runCatchLoop(warmUpCycles);

        long notcatchTime = se.runCatchNotLoop(warmUpCycles);

        System.out.println("...预热结束");

        System.out.println("...预热阶段,try/catch在循环中耗时: " + catchTime);

        System.out.println("...预热阶段,try/catch不在循环中耗时: " + notcatchTime);

 

        System.out.println("...进入正式循环 ...");

        catchTime =se.runCatchLoop(testCycles);

        notcatchTime= se.runCatchNotLoop(testCycles);

        System.out.println("...正式运行阶段,try/catch在循环中耗时: " + catchTime);

        System.out.println("...正式运行阶段,try/catch不在循环中耗时: " + notcatchTime);

 

    }

   

    public EasyTryCatchTest(){

        aList.add("0");

    }

 

    // try / catch 在具体的循环体（内圈 循环 ）中

    private long runCatchLoop(int iterations) {

        // 开始计时

        long startTime = System.nanoTime();

 

        for (int loop = 0; loop < iterations; loop++) {

            try {

                String temp = aList.get(0);

            } catch(Exception e) {}

        }

 

        // 计时完成

        long elapsedTime = System.nanoTime();

        return(elapsedTime - startTime);

    }

 

    // try / catch 在不在具体的循环体（内圈 循环 ）中

    public long runCatchNotLoop(int iterations) {

        // 开始计时

        long startTime = System.nanoTime();

 

        try {

            for (int loop = 0; loop < iterations; loop++) {

                String temp = aList.get(0);

            }

 

        } catch(Exception e) {}

 

        // 计时完成

        long elapsedTime = System.nanoTime();

        return(elapsedTime - startTime);

    }

 

}