package sorting;

/**
 * Sort.java
 * @author john Zavidniak
 * Sorts the given array using the specified algorithm
 * @param <T> the type of elements stored in the array to sort
 */

public class Sorter<T extends Comparable<? super T>> implements Runnable
{
    
    public static final int SELECTION_SORT = 0;
    public static final int HEAP_SORT = 1;
    public static final int INSERTION_SORT = 2;
    public static final int BUBBLE_SORT = 3;
    public static final int SHAKER_SORT = 4;
    public static final int SHELL_SORT = 5;
    public static final int COMB_SORT = 6;
    
    private int sort;
    private T[] array;
    
    private boolean sorting;
    
    /**
     * Create a new Sorter Object with the given array
     * @param array the array to sort
     */
    public Sorter(T[] array)
    {
        this.sorting = false;
        this.sort = 0;
        this.array = array;
    }
    
    /**
     * Delay the sort to make it visible when displaying in a gui.
     * NOTE: COMMENT OUT THE BODY OF THIS FUNCTION IN WINDOWS
     * AS WINDOWS IS ALREADY SLOW ENOUGH FOR IT TO NOT MATTER
     * @param delay the amount of time to wait or prints to
     * screen to perform
     * @param useSleep true to sleep for the delay, false to print to screen
     * to delay
     */
    public static void delaySort(int delay, boolean useSleep)
    {
        if (useSleep)
        {
            try
            {
                Thread.sleep(delay);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return;
        }
        else
        {
            for (int i = 0; i < delay; i++)
            {
                System.out.println("Sort");
            }
        }
    }
    
    /**
     * Sort the given array
     */
    public void sort()
    {
        if (sorting)
        {
            return;
        }
        new Thread(this).start();
    }
    
    @Override
    public void run()
    {
        sorting = true;
        System.out.println("PERFORMING SORT!");
        switch(sort)
        {
        case SELECTION_SORT:
            SelectionSort.sort(array);
            break;
        case HEAP_SORT:
            HeapSort.sort(array);
            break;
        case INSERTION_SORT:
            InsertionSort.sort(array);
            break;
        case BUBBLE_SORT:
            BubbleSort.sort(array);
            break;
        case SHAKER_SORT:
            ShakerSort.sort(array);
            break;
        case SHELL_SORT:
            ShellSort.sort(array);
            break;
        case COMB_SORT:
            CombSort.sort(array);
            break;
        default:
            SelectionSort.sort(array);
            break;
        }
        sorting = false;
    }
    
    public String toString()
    {
        switch (sort)
        {
        case SELECTION_SORT:
            return "Selection Sort";
        case HEAP_SORT:
            return "Heap Sort";
        case INSERTION_SORT:
            return "Insertion Sort";
        case BUBBLE_SORT:
            return "Bubble Sort";
        case SHAKER_SORT:
            return "Shaker Sort";
        case SHELL_SORT:
            return "Shell Sort";
        case COMB_SORT:
            return "Comb Sort";
        default:
            return "Selection Sort";
        }
    }
    
    /**
     * Indiciate whether or not a sort is in progress
     * @return true if a sort is in progress, false otherwise
     */
    public boolean isSorting()
    {
        return sorting;
    }
    
    /**
     * Specify the sorting algorithm to use
     * @param state the sorting algorithm to use
     */
    public void setSort(int sort)
    {
        this.sort = sort;
    }
    
    /**
     * Provide the array which is being used for sorting
     * @return the array being used for sorting
     */
    public T[] getArray()
    {
        return array;
    }
    
}