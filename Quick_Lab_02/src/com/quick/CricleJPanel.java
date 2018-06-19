package com.quick;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

class CricleJPanel extends JPanel {
	private Color color;
	public CricleJPanel()
	{
		color = new Color(255, 255, 255);
		this.setPreferredSize(new Dimension(10, 10));
		this.setBackground(new Color(255,255,255));
	}
	public void setPointColor(Color color)
	{
		this.color = color;
	}
	protected void paintComponent(Graphics g) {
		Color c = g.getColor();
		g.setColor(this.color);
		g.fillOval(0, 0, this.getSize().width - 1, this.getSize().height - 1);
		g.setColor(Color.BLACK); // 设置边框颜色
		g.drawOval(0, 0, this.getSize().width - 1, this.getSize().height - 1);
		g.setColor(c);
	}
}