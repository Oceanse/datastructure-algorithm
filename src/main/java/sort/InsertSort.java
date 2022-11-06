package sort;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 1 把 n 个待排序的元素分成两组：有序表和无序表
 * 2 最开始时，有序表中只包含第一个元素，无序表中包含有 n-1 个元素； 排序过程中每次从无序表中取出第一个元素，向有序表中插入
 * 3 插入过程： 倒叙有序表，依次和待插入的元素进行大小比较，将它插入到有序表中的适当位置(插入的过程本质上可以使用类似与冒泡排序，后面比前面
 * 大则交换位置，如果遇到后面比前面大则停止交换，这样就实现了把一个数插入到有序列表的目的)
 */
public class InsertSort {
    @Test
    public void test() {
        int[] array = {5, 4, 3, 2, 1};
        int tmp;
        for (int i = 1; i < array.length; i++) {//一开始array[0]是有序列表，所以从index=1开始遍历
            for (int j = i; j >0 ; j--) { //把一个数array[j=i]插入到有序列表array[0]~array[i]中，倒叙冒泡排序
                if(array[j]<array[j-1]){
                    tmp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                }else{
                    break;//因为是把一个数插入到有序列表，所以一旦遇到后面比前面大则停止交换，此时已经插入到了合适的位置
                }

            }
            System.out.println("第 " + i + " 轮排序后：" + Arrays.toString(array));
        }

    }

    /**
     * 选择排序算法封装
     * @param array
     */
    public void insertSort(int array[]) {
        int tmp;
        for (int i = 1; i < array.length; i++) {//一开始array[0]是有序列表，所以从index=1开始遍历
            for (int j = i; j >0 ; j--) { //把一个数array[j=i]插入到有序列表array[0]~array[i]中，无序列表中的第一个值，与有序列表中的最后一个值开始比较，倒叙冒泡排序
                if(array[j]<array[j-1]){
                    tmp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                }else{
                    break;//因为是把一个数插入到有序列表，所以一旦遇到后面比前面大则停止交换，此时已经插入到了合适的位置
                }
            }
        }

    }

    @Test
    public void test3(){
        int[] arr = {3, 9, -1, 10, 20};
        System.out.println("排序前：" + Arrays.toString(arr));
        insertSort(arr);
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
        insertSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序共耗时 "+(endTime-startTime)+" ms");

    }




}
