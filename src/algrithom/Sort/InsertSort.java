package algrithom.Sort;

//排序第一种
//插入排序
//《数据结构与算法》P.272-273
public class InsertSort {
    public static <AnyType extends Comparable<? super AnyType>> void insertSort(AnyType[] a)
    {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            //将i处的值存储在tmp中
            AnyType tmp = a[i];
            //将a[i]的值不断向左移动知道到达正确的位置，所有更大的元素都右移一个位置
            for (j = i; j > 0 && tmp.compareTo(a[j - 1]) < 0 ; j--) {
                a[j] = a[j - 1];
            }
            //最后将tmp放到正确的位置上，与实现二叉堆用到了相同的技巧
            a[j] = tmp;
        }
    }
}
