package minesweeper;

import java.util.ArrayList;
import java.util.List;


public class GameMap
{
    private final int length;
    private final int width;
    private final Field[] fields;

    public Field[] getFields()
    {
        return fields;
    }

    public GameMap(int length, int width)
    {
        this.length = length;
        this.width = width;
        fields = new Field[length * width];
        generateMap();
    }

    private void generateMap()
    {
        initialiseMap();
        numberMap();
    }
    
    private void initialiseMap()
    {
        for (int i = 0; i < fields.length; i++)
        {
            fields[i] = new Field();
        }
    }
    
    private void numberMap()
    {
        for (int i = 0; i < fields.length; i++)
        {
            if (fields[i].getValue() == -1)
            {
                numberAdjacentFields(i);
            }
        }
    }

    private void numberAdjacentFields(int index)
    {
        List<Integer> indexes = new ArrayList();
        
        getNeighbouringIndexes(index, indexes);
        getValidIndexes(index, indexes);
        increaseValuesAtIndexes(indexes);
    }

    private void getNeighbouringIndexes(int index, List<Integer> indexes)
    {   
        indexes.add(index - length - 1);
        indexes.add(index - length);
        indexes.add(index - length + 1);
        indexes.add(index - 1);
        indexes.add(index + 1);
        indexes.add(index + length - 1);
        indexes.add(index + length);
        indexes.add(index + length + 1);
    }
    
    private void getValidIndexes(int index, List<Integer> indexes)
    {
        for (int i = 0; i < indexes.size();)
        {
            int currIndex = indexes.get(i);
            
            if (
                    currIndex < 0 ||
                    currIndex >= (length * width) ||
                 ( (currIndex + 1 - index) % length == 0 &&   (index      % length == 0) ) ||
                 ( (currIndex - 1 - index) % length == 0 && ( (index + 1) % length == 0) ) ||
                    fields[currIndex].getValue() == -1
               )
            {
                indexes.remove(i);
            }
            else
            {
                i++;
            }
        }
    }
    
    private void increaseValuesAtIndexes(List<Integer> indexes)
    {
        for (Integer index : indexes)
        {
            Field currField = fields[index];
            currField.setValue(currField.getValue() + 1);
        }
    }
}
