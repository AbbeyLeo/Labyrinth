/**
 * 
 */
package com.quick;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.sun.org.apache.xml.internal.security.Init;

/**
 * @author Abbey
 *
 */
public class Demo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[][] = {
				{1,0,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,1,0,0,0,0},
				{1,0,1,1,0,1,1,1,0,1},
				{1,0,0,0,1,1,1,1,0,1},
				{1,1,1,0,1,0,1,1,1,1},
				{1,0,0,0,1,0,1,1,0,1},
				{1,0,0,1,0,0,0,0,0,1},
				{1,0,1,1,0,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1}
				};
		Step step =new Step(array);	//将数组双向链表化
		step.init();	//					
		step.stepInit();//这两部将数组两两双向链表化
		goThrough(step.SearchStep(new Step(array,1,0)));	//输入坐标自动走迷宫	
		JFrame f = new PaintJFrame(array);
		for(int x = 0; x < array[0].length; x++)
		{
			for(int y = 0; y < array.length; y++)
			{
				System.out.print(array[x][y] + "  ");
			}
			System.out.println();
		}
	}
	
	public static void goThrough(Step step)
	{
		int up = 0;
		int down = 0;
		int left = 0;
		int right = 0;
		//向上寻找路线
		
		if(step.getUpStep() != null){
			if(step.getUpStep().getItself() != 1 
					&& step.getUpStep().getItself() != 2 
					&& step.getUpStep().getItself() != 8 )
			{
				up = 0;
				step.setItself(2);
				step.array[step.y][step.x] = 2;
				goThrough(step.getUpStep());
			}
			
			if(step.getUpStep().getItself() == 1 
					|| step.getUpStep().getItself() == 8 )
			{
				up = 1;
			}
		}
		//向下寻找路线
		if(step.getDownStep() != null){
			if(step.getDownStep().getItself() != 1 
					&& step.getDownStep().getItself() != 2 
					&& step.getDownStep().getItself() != 8)
			{
				down = 0;
				step.setItself(2);
				step.array[step.y][step.x] = 2;
				goThrough(step.getDownStep());
			}
			if(step.getDownStep().getItself() == 1 
					|| step.getDownStep().getItself() == 8)
			{
				down = 1;
			}
		}
		//向左寻找路线
		if(step.getLeftStep() != null){
			if(step.getLeftStep().getItself() != 1 
					&& step.getLeftStep().getItself() != 2 
					&& step.getLeftStep().getItself() != 8)
			{
				left = 0;
				step.setItself(2);
				step.array[step.y][step.x] = 2;
				goThrough(step.getLeftStep());
			}
			if(step.getLeftStep().getItself() == 1 
					|| step.getLeftStep().getItself() == 8)
			{
				left = 1;
			}
		}
		//向右寻找路线
		if(step.getRightStep() != null){
			if(step.getRightStep().getItself() != 1 
					&& step.getRightStep().getItself() != 2 
					&& step.getRightStep().getItself() != 8)
			{
				right = 0;
				step.setItself(2);
				step.array[step.y][step.x] = 2;
				goThrough(step.getRightStep());
			}
			if(step.getRightStep().getItself() == 1 
					|| step.getRightStep().getItself() == 8)
			{
				right = 1;
			}
		}
		//绘制错误路线
		if((up == 1 && down == 1 && left == 1 && right != 1)
				|| (up == 1 && down == 1 && left != 1 && right == 1)
				|| (up == 1 && down != 1 && left == 1 && right == 1)
				|| (up != 1 && down == 1 && left == 1 && right == 1))
		{
			step.setItself(8);
			step.array[step.y][step.x] = 8;
			if(step.getLeftStep().getItself() == 2) goThrough(step.getLeftStep());
			if(step.getRightStep().getItself() == 2) goThrough(step.getRightStep());
			if(step.getUpStep().getItself() == 2) goThrough(step.getUpStep());
			if(step.getDownStep().getItself() == 2) goThrough(step.getDownStep());
		}
		
	}
}
