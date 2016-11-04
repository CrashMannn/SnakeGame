/**
*@author crash_man
*@Time 2016-11-01
*/
import java.awt.event.*;

public class GameController implements KeyListener 
{
	private Snake snake;
	public GameController(Snake snake)
	{
		this.snake = snake;
	}

    @Override
    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			if(!snake.getDirection().equals(Direction.DOWN))
				snake.setDirection(Direction.UP);	
		}
    	if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(!snake.getDirection().equals(Direction.RIGHT))
				snake.setDirection(Direction.LEFT);
		}
    	if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(!snake.getDirection().equals(Direction.LEFT))
				snake.setDirection(Direction.RIGHT);
		}
    	if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if(!snake.getDirection().equals(Direction.UP))
				snake.setDirection(Direction.DOWN);
		}
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }	
}
