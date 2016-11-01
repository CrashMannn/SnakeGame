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

    public Grid(int width, int height) {

        this.width = width;
        this.height = height;
    }
}
