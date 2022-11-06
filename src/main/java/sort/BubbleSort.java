package sort;

import org.testng.annotations.Test;

import java.time.Instant;
import java.util.Arrays;


/**
 * 1： 共进行(数组大小 -1)趟循环(外循环)
 * 2： 每一趟排序交换的次数在逐渐的减少，第一趟交换的次数是(数组大小 -1)
 * 3：如果发现在某趟排序中，没有发生一次交换，则可以提前结束冒泡排序。
 */
public class BubbleSort {

    /**
     *先演示冒泡排序的演变过程
     */
    @Test
    public void test(){
        //第一趟进行(arr.length-1=5-1=4次交换)
        int[] array=new int[]{8,1,6,9,5};
        for (int i = 0; i < array.length-1; i++) {
            int tmp;
            if(array[i]>array[i+1]){
                tmp=array[i];
                array[i]=array[i+1];
                array[i+1]=tmp;
            }
        }
        System.out.println(Arrays.toString(array));//[1, 6, 8, 5, 9]



        //第二趟进行(arr.length-2=5-2=3次交换)
        for (int i = 0; i < array.length-2; i++) {
            int tmp;
            if(array[i]>array[i+1]){
                tmp=array[i];
                array[i]=array[i+1];
                array[i+1]=tmp;
            }
        }
        System.out.println(Arrays.toString(array));//[1, 6, 5, 8, 9]


        //第三趟进行(arr.length-3=5-3=2次交换)
        for (int i = 0; i < array.length-3; i++) {
            int tmp;
            if(array[i]>array[i+1]){
                tmp=array[i];
                array[i]=array[i+1];
                array[i+1]=tmp;
            }
        }
        System.out.println(Arrays.toString(array));//[1, 5, 6, 8, 9]

        //第四趟进行(arr.length-4=5-4=1次交换)
        for (int i = 0; i < array.length-4; i++) {
            int tmp;
            if(array[i]>array[i+1]){
                tmp=array[i];
                array[i]=array[i+1];
                array[i+1]=tmp;
            }
        }
        System.out.println(Arrays.toString(array));//[1, 5, 6, 8, 9]
    }


    /**
     * 输出：
     * 第1趟排序后： [1, 6, 8, 5, 9]
     * 第2趟排序后： [1, 6, 5, 8, 9]
     * 第3趟排序后： [1, 5, 6, 8, 9]
     * 第4趟排序后： [1, 5, 6, 8, 9]
     *
     * 可以看出第四次排序是多余的；
     * 如果发现在某趟排序中，没有发生一次交换，则可以提前结束冒泡排序。
     */
    @Test
    public void test2(){
        int[] array=new int[]{8,1,6,9,5};
        int tmp;
        for (int i = 0; i < array.length-1; i++) {//最多array.length-1趟排序
            for (int j = 0; j < array.length-1-i; j++) {//每趟需要进行 array.length-1-i 次交换
                if(array[j]>array[j+1]){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序后： "+Arrays.toString(array));
        }
    }


    /**
     * 设置一个flag表示有没发生过交换，如果flag=true表示这趟排序发生过交换；
     * 如果flag=false,说明这趟排序没有发生过交换，数组已经是一个有序数组，可以提前结束冒泡排序。
     */
    @Test
    public void test3(){

        int[] array=new int[]{8,1,6,9,5};
        int tmp;
        boolean flag;
        for (int i = 0; i < array.length-1; i++) {
            flag=false;  //每趟排序之前flag设置为false
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    flag=true; //这趟排序发生过交换,则设置flag=true
                }
            }

            //如果flag=false,说明这趟排序没有发生过交换，那么提前结束排序
            if(!flag){
                break;
            }

            System.out.println("第"+(i+1)+"趟排序后： "+Arrays.toString(array));
        }
    }


    /**
     * 封装算法
     * @param array
     */
    public static void bubbleSort(int[] array){
        int tmp;
        boolean flag;
        for (int i = 0; i < array.length-1; i++) {
            flag=false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
    }



    @Test
    public void test4(){
        int[] arr = {3, 9, -1, 10, 20};
        System.out.println("排序前：" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }


    /**
     * 大量数据排序时间测试
     */
    @Test
    public void test5(){
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=arr.length-i;
        }

        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序共耗时 "+(endTime-startTime)+" ms");
    }

}
