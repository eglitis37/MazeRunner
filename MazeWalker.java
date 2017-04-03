import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeWalker extends Actor
{
    private final int NORTH = 270;
    private final int EAST = 0;
    private final int SOUTH = 90;
    private final int WEST = 180;
    
    
    public MazeWalker()
    {
        GreenfootImage playerImage = new GreenfootImage(40, 40);
        
        playerImage.setColor(Color.ORANGE);
        playerImage.fillRect(0, 0, 40, 40);
        
        setImage(playerImage);
        setRotation(SOUTH);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkWin();
        
        if( wallOnLeft() == true )
        {
            if( canMoveForward() == true )
            {
                move(1);
            }
            else
            {
                setRotation( getRotation() + 90 );
            }
        }
        else
        {
            setRotation( getRotation() - 90 );
            
            if( canMoveForward() == true )
            {
                move(1);
            }
        }
    }
    
    /**
     * checkWin will check if the Player has reached the WinningSpace and will show a message 
     * that you won.
     * @param There are no parameters.
     * @return Nothing is returned.
     */
    private void checkWin()
    {
        if( isTouching(WinningSpace.class) )
        {
            getWorld().showText("You lost!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
    
    /**
     * wallOnLeft checks if there is a wall to the Player's left side.
     * @param There are no parameters.
     * @return A boolean that tells you if there is or isn't wall on your left.
     */
    private boolean wallOnLeft()
    {
        int xOffset = 0;
        int yOffset = 0;
        
        boolean wallLeft = false;
        
        
        if( getRotation() == NORTH )
        {
            xOffset = -1;
        }
        else if( getRotation() == SOUTH )
        {
            xOffset = 1;
        }
        else if( getRotation() == WEST )
        {
            yOffset = 1;
        }
        else if( getRotation() == EAST )
        {
            yOffset = -1;
        }
        
        if( getOneObjectAtOffset( xOffset, yOffset, Wall.class ) != null )
        {
            wallLeft = true;
        }
        
        return wallLeft;
    }
    
    /**
     * canMoveForward checks if Player can move forward.
     * @param There are no parameters
     * @return A boolean that tells whether or not can move forward.
     */
    private boolean canMoveForward()
    {
        int xOffset = 0;
        int yOffset = 0;
        
        boolean moveForward = false;
        
        if( getRotation() == NORTH )
        {
            yOffset = -1;
        }
        else if( getRotation() == SOUTH )
        {
            yOffset = 1;
        }
        else if( getRotation() == EAST )
        {
            xOffset = 1;
        }
        else
        {
            xOffset = -1;
        }
        
        if( getOneObjectAtOffset( xOffset, yOffset, Wall.class ) == null )
        {
            moveForward = true;
        }
        
        return moveForward;
    }
}
