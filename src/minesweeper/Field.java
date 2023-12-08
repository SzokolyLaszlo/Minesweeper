package minesweeper;

import java.util.Random;


public class Field
{
    private int value;

    public int getValue()
    {
        return value;
    }

    public final void setValue(int value)
    {
        this.value = value;
    }

    public Field()
    {
        generateValue();
    }

    private void generateValue()
    {
        Random r = new Random();
        int startValue = -(r.nextInt(-1, 4) >>> 31);
        setValue(startValue);
    }
}
