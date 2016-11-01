/**
*@author crash_man
*@Time 2016-11-01
*/
package com.crashman.snake;
import java.util.LinkedList;

public class Snake
{
	private LinkedList<Node> body = new LinkedList<>();
	public Node eat(Node food) {

        if (!isNeighbor(body.getFirst(), food)) {
        	// 相邻情况下的处理
        }
        // 如果food与头部相邻，则将food这个Node加入到body中，返回food
        // 否则不做任何操作，返回null		
    }
    
    private boolean isNeighbor(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
    }	

    public Node move(Direction direction) {
        // 根据方向更新贪吃蛇的body
        // 返回移动之前的尾部Node
    }

    public Node getHead() {
        return body.getFirst();
    }

    public Node addTail(Node area) {
        this.body.addLast(area);
        return area;
    }

    public LinkedList<Node> getBody() {
        return body;
    }
}
