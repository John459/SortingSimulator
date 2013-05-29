package graphics;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import sorting.Element;

/**
 * View.java
 * @author John Zavidniak
 * Create a JFrame which shows the contents of both Display and Panel,
 * and contain methods for ordering the array to sort in various ways
 */

public class View extends JFrame
{
    
    /**
     * Create a new View object with the given array
     * @param array the array that will be used for sorting
     */
    public View(Element[] array)
    {
        super("Sorting");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(new Display(500, 500, array), BorderLayout.CENTER);
        this.add(new Panel(array), BorderLayout.NORTH);
        this.setSize(720, 1000);
        this.setVisible(true);
    }
    
    /**
     * Populate the given array so that the elements are shown in order
     * at the beginning of the sort
     * @param array the to populate 
     */
    public static void popArrayOrdered(Element[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != null)
            {
                array[i].setValue(i);
            }
            else
            {
                array[i] = new Element(i);
            }
        }
    }
    
    /**
     * Populate the given array so that the elements are shown in reverse
     * order at the beginning of the sort
     * @param array the array to populate
     */
    public static void popArrayReverseSorted(Element[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != null)
            {
                array[i].setValue(array.length - 1 - i);
            }
            else
            {
                array[i] = new Element(array.length - 1 - i);
            }
        }   
    }
    
    /**
     * Populate the given array so that the elements are shown in random
     * order at the beginning of the sort
     * @param array the array to populate
     */
    public static void popArrayRandom(Element[] array)
    {
        List<Element> list = new ArrayList<Element>();
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != null)
            {
                list.add(array[i]);
            }
            else
            {
                list.add(new Element(i));
            }
        }
        int i = 0;
        while (list.size() > 0)
        {
            array[i] = list.remove((int) (Math.random() * list.size()));
            i++;
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        
        Element[] array = new Element[707];
        popArrayRandom(array);
        View v = new View(array);
        while (true)
        {
            v.repaint();
            try
            {
                Thread.sleep(20);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    
}