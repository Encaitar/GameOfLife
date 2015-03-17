package GOL;

import java.util.HashMap;

public class GameOfLife
{
    public static boolean ALIVE = true;
    public static boolean DEAD = false;

    private HashMap<Coordinates, Boolean> cellMap;

    public GameOfLife(int x, int y)
    {
        cellMap = new HashMap<Coordinates, Boolean>();
        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j < y; j++)
            {
                cellMap.put(new Coordinates(i,j), DEAD);
            }
        }
    }

    public void set(int x, int y, boolean alive)
    {
        Coordinates coords = new Coordinates(x,y);
        set(coords, alive);
    }

    public void set(Coordinates coords, boolean alive)
    {
        /*
         * If what we are being asked to set the value to is not its current
         * value then set it.
         */
        if(alive != cellMap.get(coords))
        {
            cellMap.remove(coords);
            cellMap.put(coords, alive);
        }
    }

    public boolean get(Coordinates coords)
    {
        return cellMap.get(coords);
    }

    private int neighbours(Coordinates coords)
    {
        int x = coords.getX();
        int y = coords.getY();
        int count = 0;
        
        count += isAlive(x-1, y-1) ? 1 : 0;
        count += isAlive(x, y-1) ? 1 : 0;
        count += isAlive(x+1, y-1) ? 1 : 0;

        count += isAlive(x-1, y) ? 1 : 0;
        count += isAlive(x+1, y) ? 1 : 0;

        count += isAlive(x-1, y+1) ? 1 : 0;
        count += isAlive(x, y+1) ? 1 : 0;
        count += isAlive(x+1, y+1) ? 1 : 0;

        return count;
    }

    public boolean isAlive(int x, int y)
    {
        Coordinates coords = new Coordinates(x,y);
        if(cellMap.containsKey(coords))
        {
            return cellMap.get(coords);
        }
        else
        {
            return false;
        }
    }
    
    /*
     * Any live cell with fewer than two live neighbours dies, as if caused by
     * under-population.
     * Any live cell with two or three live neighbours lives on to the next
     * generation.
     * Any live cell with more than three live neighbours dies, as if by 
     * overcrowding.
     * Any dead cell with exactly three live neighbours becomes a live cell, as
     * if by reproduction. 
     */
    public void step()
    {
        HashMap<Coordinates, Boolean> tempMap;
        tempMap = new HashMap<Coordinates, Boolean>();
        int count = 0;

        for(Coordinates coords : cellMap.keySet())
        {
            count = neighbours(coords);
            boolean currentValue = cellMap.get(coords);
            if(currentValue)
            {
                if(count == 2 || count == 3)
                {
                    /*
                     * Rule 2: Any live cell with two or three live neighbours
                     * lives on to the next generation.
                     */
                    tempMap.put(coords, currentValue);
                }
                else
                {
                    /*
                     * Rule 1: Any cell with fewer than two live
                     * neighbours dies, as if caused by under-population.
                     *
                     * Rule 3: Anny live cell with more than three live
                     * neighbours dies, as if by overcrowding.
                     */
                    tempMap.put(coords, DEAD);
                }
            }
            else
            {
                if(count == 3)
                {
                    /*
                     * Rule 4: Any dead cell with exactly three live neighbours
                     * becomes a live cell, as if by reproduction.
                     */
                    tempMap.put(coords, ALIVE);
                }
                else
                {
                    /*
                     * Implicit rule: Dead cells that do not experience
                     * reproduction stay dead.
                     */
                    tempMap.put(coords, currentValue);
                }
            }
        }
        cellMap = tempMap;
    }
}
