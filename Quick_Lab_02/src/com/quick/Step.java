/**
 * 
 */
package com.quick;

/**
 * @author Abbey
 *
 */
public class Step {
	private Step leftStep;	//左节点
	private Step rightStep;	//右节点
	private Step upStep;	//上节点
	private Step downStep;	//下节点
	private int itself; 	//自己的数字
	public int x;			//自己的横坐标
	public int y;			//自己的纵坐标
	public int [][] array;	//传过来的数组
	
	public Step(int [][] array, int x, int y)
	{
		this.array = array;
		if(x >= 0 && x < array[0].length && y >= 0 && y < array.length)
		{
			this.x = x;
			this.y = y;
			this.itself = array[y][x];
		}
	}
	public Step()
	{
		
	}
	public Step(int [][] array)
	{
		this.array = array;
		if(x >= 0 && x < array[0].length && y >= 0 && y < array.length)
		{
			this.x = 0;
			this.y = 0;
			this.itself = array[y][x];
		}
	}
	public Step SearchStep(Step step)
	{
		if(this.x != step.x)
		{
			this.getRightStep().x = this.x + 1;
			return this.getRightStep().SearchStep(step);
		}
		else if(this.x == step.x)
		{
			if(this.y != step.y)
			{
				this.getDownStep().y = this.y + 1;
				return this.getDownStep().SearchStep(step);
			}
			else if(this.y == step.y)
			{
				return this;
			}
			else
			{
				return null;
			}
		}
		else 
			return null;
	}
	
	public Step getLeftStep() {
		return leftStep;
	}

	public void setLeftStep(Step leftStep) {
		this.leftStep = leftStep;
	}

	public Step getRightStep() {
		return rightStep;
	}

	public void setRightStep(Step rightStep) {
		this.rightStep = rightStep;
	}

	public Step getUpStep() {
		return upStep;
	}

	public void setUpStep(Step upStep) {
		this.upStep = upStep;
	}

	public Step getDownStep() {
		return downStep;
	}

	public void setDownStep(Step downStep) {
		this.downStep = downStep;
	}

	public int getItself() {
		return itself;
	}

	public void setItself(int itself) {
		this.itself = itself;
	}
	public void init()
	{
		try{
			if(x >= 0 && x < array[0].length && y >= 0 && y < array.length)
			{
				leftInit();
				rightInit();
			}
		}
		catch(NullPointerException e)
		{
			
		}
	}
	public void leftInit()
	{
		if(x - 1 >= 0 && this.leftStep == null)		//左
		{
			Step leftStep_t = new Step(array, x - 1, y);
			this.setLeftStep(leftStep_t);
			this.leftStep.setRightStep(this);
			this.leftStep.leftInit();
			this.upInit();
			this.downInit();
		}
	}
	public void rightInit()
	{
		if(x + 1 < array[0].length && this.rightStep == null)	//右
		{
			Step rightStep_t = new Step(array, x + 1, y);
			this.setRightStep(rightStep_t);
			this.rightStep.setLeftStep(this);
			this.rightStep.rightInit();
			this.upInit();
			this.downInit();
		}
		if(x == array[0].length - 1)
		{
			this.upInit();
			this.downInit();
		}
	}
	public void upInit()
	{
		if(y - 1 >= 0 && this.upStep == null)			//上
		{
			Step upStep_t = new Step(array, x, y - 1);
			this.setUpStep(upStep_t);
			this.upStep.setDownStep(this);
			this.upStep.upInit();
		}
	}
	public void downInit()
	{
		if(y + 1 < array.length && this.downStep == null)	//下
		{
			Step downStep_t = new Step(array, x, y + 1);
			this.setDownStep(downStep_t);
			this.downStep.setUpStep(this);
			this.downStep.downInit();
		}
	}
	public void stepInit()//将第一行以外的链表左右关联
	{
		try{
			//下 右
			if(this.getDownStep() != null && this.getRightStep() != null)
			{
				this.getDownStep().setRightStep(this.getRightStep().getDownStep());
				this.getDownStep().getRightStep().setLeftStep(this.getDownStep());
				this.getRightStep().stepInit();
				this.getDownStep().stepInit();
			}
		}
		catch(NullPointerException e)
		{
		}
		
	}
}
