/**
*@author crash_man
*@Time 2016-11-01
*/
package com.crashman.snake;
import java.util.Arrays;

public class Grid
{
	public final boolean status[][];
	private final int width;
    private final int height;
	private Node food;
    private Snake snake;
 	// 初始方向默认设置为向左
    private Direction snakeDirection = Direction.LEFT;
	//贪吃蛇的长度为棋盘宽度的三分之一
	//贪吃蛇为水平放置，即包含的所有Node的Y坐标相同，Y坐标为棋盘垂直中间位置（即height / 2），
	//最左边的X为棋盘水平中间位置（即width / 2）
	private Snake initSnake() 
	{
	   snake = new Snake();
	
	   // 设置Snake的Body
	   
	   // 更新棋盘覆盖状态
	
	   return snake;
	}
	public Node createFood() 
	{
    	int x, y;
		// 使用Random设置x和y
	    food = new Node(x, y);
	    return food;
	}
    public Grid(int width, int height) {

        this.width = width;
        this.height = height;

		status = new boolean[width][height];

   		initSnake();
   		createFood();
    }
	public boolean nextRound() 
	{

    //按当前方向移动贪吃蛇

    //if (头部的位置是否有效) {
        //if (头部原来是食物) {
            //把原来move操作时删除的尾部添加回来
            //创建一个新的食物
        //} 
		//更新棋盘状态并返回游戏是否结束的标志
	//}	
	}
	public void changeDirection(Direction newDirection) 
	{
    	if (snakeDirection.compatibleWith(newDirection)) 
		{
        	snakeDirection = newDirection;
    	}
	}
}
