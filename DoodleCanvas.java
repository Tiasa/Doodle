/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package doodle;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;	
import java.util.Observable;
import java.util.Observer;
import java.awt.event.MouseEvent;
import java.util.List;
/**
 *
 * @author Tiasa
 */
public class DoodleCanvas extends JPanel implements Observer {
    private DoodleModel model;
    DoodleCanvas(DoodleModel model) {
        super();
        this.model = model;
        
        //super.setBackground(Color.WHITE);
        //setBackground(Color.WHITE);
        addMouseListener(new MouseClickController());
        addMouseMotionListener(new MouseMotionController());
    }
    
    public void paint(Graphics g) {
        if (g!=null) {
        Graphics2D g2d = ( Graphics2D ) g;
        //g2d
        g2d.clearRect(0, 0, getWidth(), getHeight());
        //g2d.setPaint ( Color.BLACK );
        List<DoodleShape> shapes = model.getShapes();
        //System.out.println(shapes.size());
        for ( DoodleShape shape : shapes )
        {
            if (shape != null) {
                shape.paint(g2d);
            }
        }
        }
    }
    @Override
    public void update(Observable o, Object arg) {
        paint(this.getGraphics());
    }
    private class MouseClickController extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            model.createShape();
            repaint ();
        }
        @Override
        public void mouseReleased ( MouseEvent e )
        {
            model.currentShapeCompleted();
            repaint ();
        }
        
    }
    private class MouseMotionController extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            model.addPoint(e.getX(), e.getY());
            repaint();
        }
    }
    
    
}
