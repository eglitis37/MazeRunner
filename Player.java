import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    
     public Player()
    {
        GreenfootImage playerImage = new GreenfootImage(40, 40);
        
        playerImage.setColor(Color.RED);
        playerImage.fillRect(0, 0, 40, 40);
        
        setImage(playerImage);
        setRotation(90);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkWin();
        
        if ( checkForWall() == false) 
        {
            moveForward();
        }
    }
    
    /**
     * moveForward sets rotation for Player and moves it one block to that side.
     * @param There are no parameters.
     * @return Nothing is returned.
     */
    private void moveForward()
    {
        if( Greenfoot.isKeyDown("left") )
        {
            setRotation(180);
            setLocation(getX() - 1, getY());
        }
        else if( Greenfoot.isKeyDown("right") )
        {
            setRotation(0);
            setLocation(getX() + 1, getY());
        }    
        else if( Greenfoot.isKeyDown("up") )
        {
            setRotation(270);
            setLocation(getX() , getY() - 1);
        }
        else if( Greenfoot.isKeyDown("down") )
        {
            setRotation(90);
            setLocation(getX() , getY() + 1);
        }    
    }
    
    /**
     * checkForWall checks if there is wall in the path of player. If there is, stops
     * the Player to go there.
     * @param There are no parameters.
     * @return boolean returns if there is wall or not.
     */
    private boolean checkForWall()
    {
        int xOffset = 0;
        int yOffset = 0;
        boolean wall;
        
        if( Greenfoot.isKeyDown("left") )
        {
            xOffset = -1;
        }
        else if ( Greenfoot.isKeyDown("right") )
        {
            xOffset = 1;
        }
        else if ( Greenfoot.isKeyDown("up") )
        {
            yOffset = -1;
        }
        else if ( Greenfoot.isKeyDown("down") )
        {
            yOffset = 1;
        }
        
        if( getOneObjectAtOffset( xOffset, yOffset, Wall.class ) == null )
        {
            wall = false;
        }
        else
        {
            wall = true;
        }
        
        return wall;
    }
    
    /**
     * checkWin checks if the player is touching winning space and if it does touch it,
     * stops Greenfoot and shows text.
     * @param There are no parameters.
     * @return Nothing is returned.
     */
     private void checkWin()
    {
        if( isTouching(WinningSpace.class) )
        {
            getWorld().showText("You Won!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
