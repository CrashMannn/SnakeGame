/**
*@author crash_man
*@Time 2016-11-01
*/
//package com.crashman.snake;
import javax.swing.*;
import java.awt.*;

public class SnakeApp 
{	
	private final int WindowWidth = 600;
	private final int WindowHeight = 400;
	private final int snakeWidth = 10;
	private final int foodWidth = 10;
	Grid GameGrid;
	GameCanvas GameArea;
	JFrame window;
	GameController gameController;
	public SnakeApp() {
		GameGrid = new Grid(WindowWidth,WindowHeight);
		GameArea = new GameCanvas();	
		gameController = new GameController(GameGrid.getSnake());
	}
	public void init() 
	{
        //创建游戏窗体
        window = new JFrame("贪吃蛇游戏v0.1");
        // 画出棋盘和贪吃蛇
		GameArea.setPreferredSize(new Dimension(WindowWidth,WindowHeight));
		GameArea.repaint();
		window.add(GameArea);
		window.addKeyListener(gameController);
        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) throws Exception 
	{
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.init();
		
		while(true)
		{
			Thread.sleep(500);
			int nextRoundCode = snakeApp.GameGrid.nextRound();
			if(nextRoundCode == 0)
			{	
				snakeApp.GameArea.repaint();
			}
			else
			{
				Dialog gameOverDialog = new Dialog(snakeApp.window,"GameOver",true);
				Label txtLabel = new Label();
				if(nextRoundCode == 1)
					txtLabel.setText("Snake out of Bound. Game Over");
				else if(nextRoundCode == 2)
					txtLabel.setText("Don't eat youself. Game Over");
				gameOverDialog.add(txtLabel);
				gameOverDialog.setBounds(100,200,300,200);
				gameOverDialog.setResizable(false);
				gameOverDialog.setTitle("Game Over");
				gameOverDialog.pack();
				gameOverDialog.setVisible(true);
				break;
			}
		}
    }
	class GameCanvas extends Canvas
	{
		public void paint(Graphics g)
		{
			drawSnake(g);
			drawFood(g);
		}
		private void drawSnake(Graphics g)
		{	
			Snake snake = GameGrid.getSnake();
			g.setColor(new Color(220,100,80));
			for(Node node : snake.getBody())
			{
				g.fillRect(node.getX(),node.getY(),snakeWidth,snakeWidth);
			}
		}
		private void drawFood(Graphics g)
		{	
			Node food = GameGrid.getFood();
			g.setColor(new Color(100,100,100));
			g.fillOval(food.getX(),food.getY(),foodWidth,foodWidth);			
		}
	}
}
