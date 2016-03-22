/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package doodle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author Tiasa
 */
public class DoodleColor extends JPanel implements Observer {
    private DoodleModel model;
    DoodleColor(DoodleModel model) {
        super(new GridLayout(2,1));
        this.model = model;
        JLabel color = new JLabel("Color Palette",JLabel.CENTER);
        JButton choose = new JButton("Pick Color");
        choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(DoodleColor.this, "Choose Stroke Color", Color.yellow);
                                model.setColor(c);
			}
		});	
        add(color);
        add(choose);
    }

    @Override
    public void update(Observable o, Object arg) {
        
    }
    
}
