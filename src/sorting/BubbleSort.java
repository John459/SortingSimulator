package sorting;

/**
 * BubbleSort.java
 * @author John Zavidniak
 */

public class BubbleSort
{
    
    /**
     * Sort the given array using the bubblesort algorithm
     * @param a the array to sort
     */
    public static <T extends Comparable<? super T>> void sort(T[] a)
    {
        boolean swapped = true;
        while (swapped)
        {
            swapped = false;
            for (int i = 1; i < a.length; i++)
            {
                //slow down computation to make the sorting visible
                Sorter.delaySort(2, false);
                if (a[i-1].compareTo(a[i]) > 0)
                {
                    T temp = a[i-1];
                    a[i-1] = a[i];
                    a[i] = temp;
                    swapped = true;
                }
            }
        }
    }
    
}