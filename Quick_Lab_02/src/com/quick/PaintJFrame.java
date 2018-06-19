/**
 * 
 */
package com.quick;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Abbey
 *
 */
public class PaintJFrame extends JFrame {
	PaintJPanel jp = new PaintJPanel();
	int [][] labyrinth;	//绘制迷宫的二维数组
	private GridBagLayout gridbaglayout = new GridBagLayout();					//网格包布局器
	private GridBagConstraints gridbagConstraints = new GridBagConstraints();	//网格包GridBagConstraints对象
	public PaintJFrame(int [][] labyrinth_array)
	{
		init(labyrinth_array);
		this.setSize(new Dimension(600, 600));
		this.setVisible(true);
		this.setResizable(false);
	}
	public void init(int [][] labyrinth_array)
	{
		this.labyrinth = labyrinth_array;
		this.setLayout(gridbaglayout);
		gridbaglayout.setConstraints(jp, gridbagConstraints);
		int labyrinth_width = labyrinth.length;			//迷宫的长度
		int labyrinth_height = labyrinth[0].length;		//迷宫的宽度
		gridbagConstraints.fill = GridBagConstraints.BOTH;
		for(int i = 0; i<labyrinth_width; i++)	//列数
		{	
			for(int j = 0; j<labyrinth_height; j++)		//行数
			{
				PaintJPanel jp = new PaintJPanel();
				CricleJPanel cjp = new CricleJPanel();
				gridbagConstraints.gridx = j;
				gridbagConstraints.gridy = i;
				gridbagConstraints.gridwidth = 1;
				gridbagConstraints.gridheight = 1;
				gridbagConstraints.weightx = 1;
				gridbagConstraints.weighty = 1;
				gridbagConstraints.insets = new Insets(2, 2, 2, 2);
				gridbaglayout.setConstraints(jp, gridbagConstraints);
				gridbaglayout.setConstraints(cjp, gridbagConstraints);
				if(labyrinth[i][j] == 1)
				{
					jp.setBackground(Color.BLACK);
					this.add(jp);
				}
				else if(labyrinth[i][j] == 0)
				{
					jp.setBackground(Color.WHITE);
					this.add(jp);
				}
				else if(labyrinth[i][j] == 2)
				{
					cjp.setPointColor(Color.WHITE);
					this.add(cjp);
				}
				else if(labyrinth[i][j] == 8)
				{
					cjp.setPointColor(Color.BLACK);
					this.add(cjp);
				}
				
			}
		}
		
		
	}
	
	
}
