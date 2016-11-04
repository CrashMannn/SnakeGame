/**
*@author crash_man
*@Time 2016-11-01
*/
//package com.crashman.snake;
import java.util.LinkedList;

public class Snake
{
	private LinkedList<Node> body = new LinkedList<>();
	private Direction snakeDirection = Direction.LEFT;
	public boolean eat(Node food) {
		if(isLeftNeibhor(food,body.getFirst()) && snakeDirection.equals(Direction.LEFT)) {
			addTail(food);
			System.out.println("eat left food");
			return true;
		}
		if(isRightNeibhor(food,body.getFirst()) && snakeDirection.equals(Direction.RIGHT)) {
			addTail(food);
			System.out.println("eat right food");
			return true;
		}
		if(isUpNeibhor(food,body.getFirst()) && snakeDirection.equals(Direction.UP)) {
			addTail(food);
			System.out.println("eat up food");
			return true;
		}
		if(isDownNeibhor(food,body.getFirst()) && snakeDirection.equals(Direction.DOWN)) {
			addTail(food);
			System.out.println("eat down food");
			return true;
		}
		return false;
    }
    
    private boolean isRightNeibhor(Node food, Node head) {
        return (food.getX()-head.getX() == 10 && head.getY() == food.getY());
    }	
    private boolean isLeftNeibhor(Node food, Node head) {
        return (head.getX()-food.getX() == 10 && head.getY() == food.getY());
    }	
    private boolean isDownNeibhor(Node food, Node head) {
        return (head.getY()-food.getY() == 10 && head.getX() == food.getX());
    }	
    private boolean isUpNeibhor(Node food, Node head) {
        return (food.getY()-head.getY() == 10 && head.getX() == food.getX());
    }		
    public Node move(Direction direction) {
		int headx = getHead().getX();
		int heady = getHead().getY();
       	switch(direction) {
	   		case UP   : {
				setDirection(Direction.UP);
				body.addFirst(new Node(headx,heady-10));
				break; 
			}
			case DOWN : {
				setDirection(Direction.DOWN);
				body.addFirst(new Node(headx,heady+10));
				break;
			}
			case LEFT : {
				setDirection(Direction.LEFT);
				body.addFirst(new Node(headx-10,heady));
				break;
			}
			case RIGHT: {
				setDirection(Direction.RIGHT);
				body.addFirst(new Node(headx+10,heady));
				break;
			}
		}
		return body.removeLast();
    }

    public Node getHead() {
        return body.getFirst();
    }
	public void addHead(Node head) {
		this.body.addFirst(head);
	}
    public Node addTail(Node area) {
        this.body.addLast(area);
        return area;
    }

    public LinkedList<Node> getBody() {
        return body;
    }
	public Direction getDirection() {
		return this.snakeDirection;
	}
	public void setDirection(Direction d) {
		this.snakeDirection = d;
	}
	
}
