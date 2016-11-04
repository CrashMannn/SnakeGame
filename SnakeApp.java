/**
*@author crash_man
*@Time 2016-11-01
*/
//package com.crashman.snake;
import javax.swing.*;
import java.awt.*;

public class SnakeApp 
{	
	private final int WindowWidth = 300;
	private final int WindowHeight = 200;
	private final int snakeWidth = 10;
	private final int foodWidth = 10;
	Grid GameGrid;
	GameCanvas GameArea;
	GameController gameController;
	public SnakeApp() {
		GameGrid = new Grid(WindowWidth,WindowHeight);
		GameArea = new GameCanvas();	
		gameController = new GameController(GameGrid.getSnake());
	}
	public void init() 
	{
        //创建游戏窗体
        JFrame window = new JFrame("贪吃蛇游戏v0.1");
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
			Thread.sleep(350);
			snakeApp.GameGrid.nextRound();	
			snakeApp.GameArea.repaint();
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
