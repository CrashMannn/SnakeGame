/**
*@author crash_man
*@Time 2016-11-01
*/
//package com.crashman.snake;
import java.util.LinkedList;

public class Snake
{
	private LinkedList<Node> body = new LinkedList<>();
	//public Node eat(Node food) {

    //    if (!isNeighbor(body.getFirst(), food))
	//	{
    //  		return null;
    //    }
	//	else
	//	{
	//		
	//	}
    //  // 如果food与头部相邻，则将food这个Node加入到body中，返回food
    //  // 否则不做任何操作，返回null
	//
    //}
    
    private boolean isNeighbor(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
    }	

    public Node move(Direction direction) {
		int headx = getHead().getX();
		int heady = getHead().getY();
       	switch(direction)
		{
	   		case UP   : body.addFirst(new Node(headx,heady-10));break; 
			case DOWN : body.addFirst(new Node(headx,heady+10));break;
			case LEFT : body.addFirst(new Node(headx-10,heady));break;
			case RIGHT: body.addFirst(new Node(headx+10,heady));break;
		}
		return body.removeLast();
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
