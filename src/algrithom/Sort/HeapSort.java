package algrithom.Sort;

//堆排序
public class HeapSort {
        private static int leftChild(int i)
        {
            return 2 * i + 1;
        }

    private static <AnyType extends Comparable<? super AnyType>> void percolateDown(AnyType[] a, int i, int n){
        int child;
        AnyType tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child)
        {
            child = leftChild(i);
            if(child != n - 1 && a[child].compareTo(a[child + 1]) < 0)
            {
                child++;
            }
            if(a[child].compareTo(tmp) > 0)
            {
                a[i] = a[child];
            }
            else break;
        }
        a[i] = tmp;
    }
    public static <AnyType extends Comparable<? super AnyType>> void heapsort(AnyType[] a)
    {
        for (int i = a.length / 2 - 1; i >= 0 ; i--) {
            percolateDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0 ; i--) {
            SwapReferences(a, 0, i);
            percolateDown(a, 0 ,i);
        }
    }
    public static <AnyType extends Comparable<? super AnyType>> void SwapReferences(AnyType[] a,int left,int right){
        AnyType p;
        p=a[left];
        a[left]=a[right];
        a[right]=p;
    }
}
