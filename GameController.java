/**
*@author crash_man
*@Time 2016-11-01
*/
import java.awt.event.*;

public class GameController implements KeyListener 
{
	private Direction direction = Direction.LEFT;
	public Direction getDirection()
	{
		return this.direction;
	}
	private void setDirection(Direction d)
	{
		this.direction = d;
	}
    @Override
    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			//System.out.println("W is pressed.");
			setDirection(Direction.UP);	
		}
    	if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			//System.out.println("A is pressed.");
			setDirection(Direction.LEFT);
		}
    	if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			//System.out.println("D is pressed.");
			setDirection(Direction.RIGHT);
		}
    	if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			//System.out.println("S is pressed.");
			setDirection(Direction.DOWN);
		}
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }	
}
