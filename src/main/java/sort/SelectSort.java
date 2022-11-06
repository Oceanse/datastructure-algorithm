package sort;

import org.testng.annotations.Test;

import java.util.Arrays;

import static sort.BubbleSort.bubbleSort;

/**
 * 基本思想为：
 * 第一次从 arr[0]~arr[n-1] 中选取最小值，与 arr[0] 交换
 * 第二次从 arr[1]~arr[n-1] 中选取最小值，与 arr[1] 交换
 * 第 i 次从 arr[i-1]~arr[n-1] 中选取最小值，与 arr[i-1] 交换
 * 依次类图，总共通过 n - 1 次，得到一个按排序码从小到大排列的有序序列
 *
 *
 *
 * 说明：
 * 选择排序一共有数组大小 - 1 轮排序
 * 每 1 轮排序，又是一个循环，循环的规则
 * 先假定当前这个数是最小数
 * 然后和后面每个数进行比较，如果发现有比当前数更小的数，则重新确定最小数，并得到下标
 * 当遍历到数组的最后时，就得到本轮最小的数
 * 交换
 */
public class SelectSort {

    @Test
    public void test() {
        int[] array = {5, 4, 3, 2, 1};
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {//最多array.length-1次最小值

            //每次循环的起点暂时作为最小值
            min = array[i];
            minIndex = i;

            //寻找最小值，并保存其值和索引
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }

            //元素交换
            array[minIndex] = array[i];
            array[i] = min;
            System.out.println("第 " + (i + 1) + " 轮排序后：" + Arrays.toString(array));
        }
    }




    @Test
    public void test2() {
        int[] array = {5, 4, 3, 2, 1};
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            min = array[i];
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            // 第 i 轮结束后，得到了最小值
            // 将这个最小值与 arr[i] 交换
            if (minIndex == i) {
                // 如果最小值未发生改变，则不需要执行后面的交换了
                continue;
            }
            array[minIndex] = array[i];
            array[i] = min;
            System.out.println("第 " + (i + 1) + " 轮排序后：" + Arrays.toString(array));

        }
    }


    /**
     * 选择排序算法封装
     * @param array
     */
    public void selectSort(int array[]) {
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            min = array[i];
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            // 第 i 轮结束后，得到了最小值
            // 将这个最小值与 arr[i] 交换
            if (minIndex == i) {
                // 如果最小值未发生改变，则不需要执行后面的交换了
                continue;
            }
            array[minIndex] = array[i];
            array[i] = min;
        }
    }


    @Test
    public void test3(){
        int[] arr = {3, 9, -1, 10, 20};
        System.out.println("排序前：" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }



    /**
     * 大量数据排序时间测试
     */
    @Test
    public void test4(){
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=arr.length-i;
        }

        long startTime = System.currentTimeMillis();
        selectSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序共耗时 "+(endTime-startTime)+" ms");

    }

}