package GOL;

import java.util.Arrays;

public class Coordinates
{
    private Integer x = 0;
    private Integer y = 0;

    public Coordinates(Integer _x, Integer _y)
    {
        x = _x;
        y = _y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public boolean compareTo(Coordinates other)
    {
        if(this.getX() == other.getX() && this.getY() == other.getY())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean equals(Object other)
    {
        if(other instanceof Coordinates && this.compareTo((Coordinates)other))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int hashCode()
    {
        return Arrays.hashCode(new int[] {x,y});
    }
}
