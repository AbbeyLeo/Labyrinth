/**
 * 
 */
package com.quick;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author Abbey
 *
 */
public class PaintJPanel extends JPanel {
	public PaintJPanel()
	{
		this.setPreferredSize(new Dimension(10, 10));
		this.setBackground(new Color(255,255,255));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setVisible(true);
	}
}
