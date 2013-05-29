package sorting;

/**
 * HeapSort.java
 * @author John Zavidniak
 */

public class HeapSort
{
    
    /**
     * Swap two elements in the given array
     * @param a the array containing the elements to swap
     * @param posA the position of the first element
     * @param posB the position of the second element
     */
    private static <T extends Comparable<? super T>> void swap(T[] a, int posA, int posB)
    {
        T temp = a[posA];
        a[posA] = a[posB];
        a[posB] = temp;
    }
    
    /**
     * Sort the given array using the heapsort algorithm
     * @param a the array to sort
     * @param count the number of elements in the array
     */
    private static <T extends Comparable<? super T>> void heapsort(T[] a, int count)
    {
        heapify(a, count);
        int end = count - 1;
        while (end > 0)
        {
            swap(a, end, 0);
            end--;
            siftDown(a, 0, end);
        }
    }
    
    /**
     * Heapify the array, placing the largest element on top
     * @param a the array to heapify
     * @param count the number of elements in the array
     */
    private static <T extends Comparable<? super T>> void heapify(T[] a, int count)
    {
        int start = (count - 1) / 2;
        while (start >= 0)
        {
            siftDown(a, start, count - 1);
            start--;
        }
    }
    
    /**
     * Heapify a subportion of the original array
     * @param a the array to heapify
     * @param start the start index to heapify from
     * @param end the end index to heapify to
     */
    private static <T extends Comparable<? super T>> void siftDown(T[] a, int start, int end)
    {
        int root = start;
        int lChild;
        while ((lChild = root * 2 + 1) <= end)
        {
            //slow down computation to make the sorting visible
            Sorter.delaySort(1, true);
            int swap = root;
            if (a[swap].compareTo(a[lChild]) < 0)
            {
                swap = lChild;
            }
            if (lChild + 1  <= end && a[swap].compareTo(a[lChild + 1]) < 0)
            {
                swap = lChild + 1;
            }
            if (swap != root)
            {
                swap(a, root, swap);
                root = swap;
            }
            else
            {
                return;
            }
        }
    }
    
    /**
     * Sort the given array using the heapsort algorithm
     * @param a the array to sort
     */
    public static <T extends Comparable<? super T>> void sort(T[] a)
    {
        heapsort(a, a.length);
    }
    
}