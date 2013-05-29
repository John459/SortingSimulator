package sorting;

import java.awt.Color;

/**
 * Element.java
 * @author John Zavidniak
 * This is the Object which will be used for displaying the various
 * sorting algorithms
 */

public class Element implements Comparable<Element>
{
    
    private int value;
    private Color color;
    
    /**
     * Create a new Element with the given value
     * @param value the value of the Element
     */
    public Element(int value)
    {
        this.setValue(value);
    }
    
    /**
     * Compare this Element with another
     * @param e the Element to compare this Element with
     * @return the difference between the value of this element
     * and the value of the other element
     */
    @Override
    public int compareTo(Element e)
    {
        return this.value - e.value;
    }
    
    /**
     * Get the color of this Element
     * @return the color of this Element
     */
    public Color getColor()
    {
        return color;
    }
    
    /**
     * Get the value of this Element
     * @return the value of this Element
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * Set the color of this Element
     */
    private void setColor()
    {
        if (value < 255)
        {
            color = new Color(value, 0, 0);
        }
        else if (value < 255 * 2)
        {
            color = new Color(254, value % 255, 0);
        }
        else
        {
            color = new Color(254, 254, value % 255);
        }
    }

    /**
     * Set the value of this Element, and update its color
     * @param value the new value of this Element
     */
    public void setValue(int value)
    {
        this.value = value;
        this.setColor();
    }
    
}