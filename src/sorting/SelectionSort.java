package sorting;

/**
 * SelectionSort.java
 * @author John Zavidniak
 */

public class SelectionSort
{
    
    /**
     * Sort the given array using the selectionsort algorithm
     * @param a the array to sort
     */
    public static <T extends Comparable<? super T>> void sort(T[] a)
    {
        int i,j;
        int min;
        for (i = 0; i < a.length - 1; i++)
        {
            min = i;
            for (j = i + 1; j < a.length; j++)
            {
                //slow down computation to make the sorting visible
                Sorter.delaySort(3, false);
                if (a[j].compareTo(a[min]) < 0)
                {
                    min = j;
                }
            }
            if (min != i)
            {
                T temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
    
}