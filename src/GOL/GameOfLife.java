package GOL;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class GameOfLife
{
    public static boolean ALIVE = true;
    public static boolean DEAD = false;

    private HashMap<Coordinates, Boolean> cellMap;

    public GameOfLife()
    {
        cellMap = new HashMap<Coordinates, Boolean>();
    }

    public void set(int x, int y, boolean alive)
    {
        Coordinates coords = new Coordinates(x,y);
        set(coords, alive);
    }

    public void set(Coordinates coords, boolean alive)
    {
        cellMap.put(coords, alive);
    }

    private Set<Coordinates> getCoords()
    {
        return cellMap.keySet();
    }
    
    private boolean containsCoords(Coordinates coords)
    {
        return cellMap.containsKey(coords);
    }
    
    public boolean get(Coordinates coords)
    {
        Boolean value = cellMap.get(coords);
        return value != null ? value : false;
    }

    private int neighbours(Coordinates coords, Map<Coordinates, Boolean> tempMap)
    {
        int x = coords.getX();
        int y = coords.getY();
        int count = 0;
        
        count += isAlive(x-1, y-1, tempMap) ? 1 : 0;
        count += isAlive(x, y-1, tempMap) ? 1 : 0;
        count += isAlive(x+1, y-1, tempMap) ? 1 : 0;

        count += isAlive(x-1, y, tempMap) ? 1 : 0;
        count += isAlive(x+1, y, tempMap) ? 1 : 0;

        count += isAlive(x-1, y+1, tempMap) ? 1 : 0;
        count += isAlive(x, y+1, tempMap) ? 1 : 0;
        count += isAlive(x+1, y+1, tempMap) ? 1 : 0;

        return count;
    }

    public boolean isAlive(int x, int y, Map<Coordinates, Boolean> tempMap)
    {
        Coordinates coords = new Coordinates(x,y);
        if(containsCoords(coords))
        {
            return get(coords);
        }
        else
        {
            // Becomes a relevant cell for next iteration.
            tempMap.put(coords, false);
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
        // Update the collection of relevant coordinates before evaluating over it.
        HashMap<Coordinates, Boolean> map = new HashMap<Coordinates, Boolean>();
        for(Coordinates coords : cellMap.keySet())
        {
            map.put(coords, get(coords));
            neighbours(coords, map);
        }
        cellMap = map;
        
        // Evaluate the rules of the game for each relevant coordinate.
        HashMap<Coordinates, Boolean> tempMap = new HashMap<Coordinates, Boolean>();
        int count = 0;
        for(Coordinates coords : getCoords())
        {
            count = neighbours(coords, tempMap);
            boolean currentValue = get(coords);
            if(currentValue)
            {
                if(count == 2 || count == 3)
                {
                    /*
                     * Rule 2: Any live cell with two or three live neighbours
                     * lives on to the next generation.
                     */
                    if(currentValue)
                    {
                      tempMap.put(coords, currentValue);
                    }
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
                }
            }
            else
            {
                if(count > 0)
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
                    }
                }
                else
                {
                    /*
                     * If a cell is dead and has no neighbours then it is no longer relevant.
                     */
                }
            }
        }
        cellMap = tempMap;
    }
}
