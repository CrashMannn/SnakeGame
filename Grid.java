/**
*@author crash_man
*@Time 2016-11-01
*/
//package com.crashman.snake;
import java.util.Arrays;
import java.util.Random;

public class Grid
{
	private boolean status[][];
	private final int width;
    private final int height;
	private Node food;
    private Snake snake;
	private int foodCount;
 	// 初始方向默认设置为向左
    private Direction snakeDirection = Direction.LEFT;
	//贪吃蛇的长度为棋盘宽度的三分之一
	//贪吃蛇为水平放置，即包含的所有Node的Y坐标相同，Y坐标为棋盘垂直中间位置（即height / 2），
	//最左边的X为棋盘水平中间位置（即width / 2）
	private Snake initSnake() 
	{
	   snake = new Snake();
	   // 设置Snake的Body
	   snake.getBody().add(new Node(width/2-10,height/2));
	   snake.getBody().add(new Node(width/2,height/2));
	   snake.getBody().add(new Node(width/2+10,height/2));	   
	   // 更新棋盘覆盖状态
	   return snake;
	}
	public Node createFood() 
	{
    	int x, y;
		// 使用Random设置x和y
		Random rand = new Random();
		do {
			x = 10*(1 + rand.nextInt(width/10-1));
			y = 10*(1 + rand.nextInt(height/10-1));
		} while(status[x][y] == true);
	    food = new Node(x, y);		
	    return food;
	}
    public Grid(int width, int height) {

        this.width = width;
        this.height = height;
		foodCount = 0;
		status = new boolean[width][height];

   		this.snake = initSnake();
   		this.food = createFood();
	   	updateStatus(snake);
    }
	public Node getFood()
	{
		return this.food;
	}
	public Snake getSnake()
	{
		return this.snake;
	}
	public int getFoodCount()
	{
		return this.foodCount;
	}
	public int nextRound() 
	{
		Node lastTail;
		lastTail = snake.move(snake.getDirection());
		if(snake.eat(food)) 
		{
			this.foodCount++;
			System.out.println("The snake has eat " + foodCount + " food.");
			this.food = createFood();
		}
		return updateStatus(snake);
	}
	public void changeDirection(Direction newDirection) 
	{
    	//if (snakeDirection.compatibleWith(newDirection)) 
		//{
        //	snakeDirection = newDirection;
    	//}
	}
	public int updateStatus(Snake snake)
	{
		for(Node node : snake.getBody())
		{
			if(outofBound(node)) 
			{
				System.out.println("Error : Out of Bound.");
				return 1;
			} 
			else if(snake.isEatingSelf()) 
			{
				System.out.println("Don't eat yourself.");
				return 2;
			}
			else
				status[node.getX()/10][node.getY()/10] = true;
		}
		return 0;
	}
	public boolean outofBound(Node node)
	{
		return(node.getX() < 0 || node.getY() < 0 || node.getY() >= height || node.getX() >= width);
	}
}
