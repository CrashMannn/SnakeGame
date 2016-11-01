/**
*@author crash_man
*@Time 2016-11-01
*/
package com.crashman.snake;

public class Node 
{
	private final int x;
    private final int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
