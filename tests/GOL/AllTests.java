package GOL;

import org.junit.*;
import static org.junit.Assert.*;

/*
 * Any live call with fewer than two live neighbours dies,as if caused by 
 * under-population.
 * Any live cell with two or three live neighbours lives on to the next
 * generation.
 * Any live cell with more than three live neighbours dies, as if by
 * overcrowding.
 * Any dead cell with exactly three live neighbours becomes a live cell, as if 
 * by reproduction.
 */
public class AllTests
{
    /*
     * Rule 1: Any live cell with fewer than two live neighbours dies, as if
     * caused by under-population.
     *
     * A cell with zero neighbours should die.
     */
    @Test
    public void rule1_zeroNeighbours()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        gameOfLife.set(coords, GameOfLife.ALIVE);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.ALIVE, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }

    /*
     * Rule 1: Any live cell with fewer than two live neighbours dies, as if
     * caused by under-population.
     *
     * A cell with one neighbour should die.
     */
    @Test
    public void rule1_oneNeighbour()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        gameOfLife.set(coords, GameOfLife.ALIVE);
        addNeighours(gameOfLife, coords, 1);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.ALIVE, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }
    
    /*
     * Rule 2: Any live cell with two or three live neighbours lives on to the 
     * next generation.
     *
     * A cell with two neighbours should stay alive.
     */
    @Test
    public void rule2_twoNeighbours()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        gameOfLife.set(coords, GameOfLife.ALIVE);
        addNeighours(gameOfLife, coords, 2);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.ALIVE, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.ALIVE, gameOfLife.get(coords));
    }
    
    /*
     * Rule 2: Any live cell with two or three live neighbours lives on to the 
     * next generation.
     *
     * A cell with three neighbours should stay alive.
     */
    @Test
    public void rule2_threeNeighbours()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        gameOfLife.set(coords, GameOfLife.ALIVE);
        addNeighours(gameOfLife, coords, 3);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.ALIVE, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.ALIVE, gameOfLife.get(coords));
    }
    
    /*
     * Rule 3: Any live cell with more than three live neighbours dies, as if
     * by overcrowding.
     *
     * Four neighbours causes a live cell to die.
     */
    @Test
    public void rule3_fourNeighbours()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        gameOfLife.set(coords, GameOfLife.ALIVE);
        addNeighours(gameOfLife, coords, 4);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.ALIVE, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }
    
    /*
     * Rule 3: Any live cell with more than three live neighbours dies, as if
     * by overcrowding.
     *
     * Five neighbours causes a live cell to die.
     */
    @Test
    public void rule3_fiveNeighbours()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        gameOfLife.set(coords, GameOfLife.ALIVE);
        addNeighours(gameOfLife, coords, 5);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.ALIVE, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }
    
    /*
     * Rule 3: Any live cell with more than three live neighbours dies, as if
     * by overcrowding.
     *
     * Six neighbours causes a live cell to die.
     */
    @Test
    public void rule3_sixNeighbours()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        gameOfLife.set(coords, GameOfLife.ALIVE);
        addNeighours(gameOfLife, coords, 6);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.ALIVE, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }

    /*
     * Rule 3: Any live cell with more than three live neighbours dies, as if
     * by overcrowding.
     *
     * Seven neighbours causes a live cell to die.
     */
    @Test
    public void rule3_sevenNeighbours()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        gameOfLife.set(coords, GameOfLife.ALIVE);
        addNeighours(gameOfLife, coords, 7);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.ALIVE, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }

    /*
     * Rule 3: Any live cell with more than three live neighbours dies, as if
     * by overcrowding.
     *
     * Eight neighbours causes a live cell to die.
     */
    @Test
    public void rule3_eightNeighbours()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        gameOfLife.set(coords, GameOfLife.ALIVE);
        addNeighours(gameOfLife, coords, 8);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.ALIVE, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }

    /*
     * Rule 4: Any dead cell with exactly three live neighbours becomes a live
     * cell, as if by reproduction.
     *
     */
    @Test
    public void rule4_exactlyThreeNeighbours()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        addNeighours(gameOfLife, coords, 3);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.DEAD, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.ALIVE, gameOfLife.get(coords));
    }

    /*
     * Implicit rule: Dead cells that do not experience
     * reproduction stay dead.
     */
    @Test
    public void implicitRule_zeroNeighboursStaysDead()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.DEAD, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }

    /*
     * Implicit rule: Dead cells that do not experience
     * reproduction stay dead.
     */
    @Test
    public void implicitRule_oneNeighboursStaysDead()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        addNeighours(gameOfLife, coords, 1);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.DEAD, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }

    /*
     * Implicit rule: Dead cells that do not experience
     * reproduction stay dead.
     */
    @Test
    public void implicitRule_twoNeighboursStaysDead()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        addNeighours(gameOfLife, coords, 2);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.DEAD, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }

    /*
     * Implicit rule: Dead cells that do not experience
     * reproduction stay dead.
     */
    @Test
    public void implicitRule_fourNeighboursStaysDead()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        addNeighours(gameOfLife, coords, 4);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.DEAD, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }

    /*
     * Implicit rule: Dead cells that do not experience
     * reproduction stay dead.
     */
    @Test
    public void implicitRule_fiveNeighboursStaysDead()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        addNeighours(gameOfLife, coords, 5);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.DEAD, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }

    /*
     * Implicit rule: Dead cells that do not experience
     * reproduction stay dead.
     */
    @Test
    public void implicitRule_sixNeighboursStaysDead()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        addNeighours(gameOfLife, coords, 6);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.DEAD, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }

    /*
     * Implicit rule: Dead cells that do not experience
     * reproduction stay dead.
     */
    @Test
    public void implicitRule_sevenNeighboursStaysDead()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        addNeighours(gameOfLife, coords, 7);
            
        assertEquals("Pre-condition failed.", 
                    GameOfLife.DEAD, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }

    /*
     * Implicit rule: Dead cells that do not experience
     * reproduction stay dead.
     */
    @Test
    public void implicitRule_eightNeighboursStaysDead()
    {
        GameOfLife gameOfLife = new GameOfLife();
        Coordinates coords = new Coordinates(1,1);
        addNeighours(gameOfLife, coords, 8);

        assertEquals("Pre-condition failed.", 
                    GameOfLife.DEAD, 
                    gameOfLife.get(coords));
        gameOfLife.step();
        
        assertEquals("Test failed.", GameOfLife.DEAD, gameOfLife.get(coords));
    }

    private void addNeighours(GameOfLife gameOfLife, Coordinates coords, int neighbours)
    {
        int count =0;
        for(int x = coords.getX()-1; x <= coords.getX()+1; x++)
        {
            for(int y = coords.getY()-1; y <= coords.getY()+1; y++)
            {
                if(x == coords.getX() && y == coords.getY())
                {
                    continue;
                }
                gameOfLife.set(x, y, GameOfLife.ALIVE);
                count++;
                if(count == neighbours)
                {
                    return;
                }
            }
        }
    }

}
