package minesweeper;


public class Minesweeper
{
    public static void main(String[] args)
    {
        GameMap gm = new GameMap(20, 20);
        Field[] fs = gm.getFields();
        
        int i = 0;
        for (Field f : fs)
        {
            int value = f.getValue();
            String parsedValue = value < 0 ? "*" : String.valueOf(value);
            System.out.print(parsedValue + " ");
            
            if (i == 19)
            {
                System.out.println();
                i = 0;
            }
            else
            {
                i++;
            }
        }
    }
}
