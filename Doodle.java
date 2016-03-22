/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package doodle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author Tiasa
 */ 
public class Doodle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame doodleFrame = new JFrame("Doodle!");
        DoodleModel model = new DoodleModel();
        DoodleCanvas canvas = new DoodleCanvas(model);
        DoodleStroke stroke = new DoodleStroke(model);
        DoodleColor color = new DoodleColor(model);
        DoodlePlay slider = new DoodlePlay(model);
        model.addObserver(canvas);
        model.addObserver(stroke);
        model.addObserver(color);
        model.addObserver(slider);
        model.notifyObservers();
        //SpringLayout layout = new SpringLayout();
        JPanel p = new JPanel (new BorderLayout());
        JPanel q = new JPanel (new GridLayout(2,1));
        doodleFrame.getContentPane().add(p);
        p.add(canvas,BorderLayout.CENTER);
        q.add(color);
        q.add(stroke);
        p.add(q,BorderLayout.WEST);
        p.add(slider,BorderLayout.SOUTH);
        doodleFrame.setJMenuBar(new DoodleMenu(model));
	doodleFrame.setPreferredSize(new Dimension(600,600));
	doodleFrame.pack();
	doodleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doodleFrame.setBackground(Color.WHITE);
	doodleFrame.setVisible(true);
    }   
}
