/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package doodle;
import java.awt.Color;
import java.awt.Point;
import java.beans.XMLDecoder;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 *
 * @author Tiasa
 */

public class DoodleModel extends Observable {
   
    private List<DoodleShape> shapes = null;
    
    private DoodleShape currentShape;
    
    private int slider = 0;
    
    private int sliderMax = 0;
    
    private int sliderMin = 0;
    
    private Color color = Color.BLACK;
    
    private int stroke = 1;
    DoodleModel() {
        setShapes(new ArrayList<DoodleShape>());
        setChanged();
    }
    public void setShapes(List<DoodleShape> shapes) {
        this.shapes = shapes;
    }
    public void setColor (Color c) {
        color = c;
    }
    public Color getColor() {
        return color;
    }
    public void setStroke(int s) {
        stroke = s;
    }
    public int getStroke() {
        return stroke;
    }
    public void createShape() {
        currentShape = new DoodleShape();
        currentShape.setColor(getColor());
        currentShape.setStrokeThickness(getStroke());
        //shapes.add ( currentShape );
        if (slider==shapes.size()) {
            shapes.add(currentShape);
        } else if (slider < shapes.size()) {
            shapes.set(slider,currentShape);
        }
                //.add(slider, currentShape);
        sliderMax=shapes.size();
        slider++;
        setChanged();
        notifyObservers();
    }
    public void currentShapeCompleted() {
        currentShape = null;
    }
    public void addPoint(int x,int y) {
        currentShape.addPoint(x, y);
        setChanged();
        notifyObservers();
    }
    public List<DoodleShape> getShapes() {
        List<DoodleShape> temp = shapes.subList(sliderMin, slider);
        return temp;
    }
    public void setSlider(int val) {
        slider = val;
        setChanged();
        notifyObservers();
    }
    public int getSlider() {
        return slider;
    }
    public void setSliderMax(int val) {
        sliderMax = val;
        setChanged();
        notifyObservers();
    }
    public int getSliderMax() {
        return sliderMax;
    }
    public void setSliderMin(int val) {
        sliderMin = val;
        setChanged();
        notifyObservers();
    }
    public int getSliderMin() {
        return sliderMin;
    }
    public void saveData(String file)
{
    try {
     XMLEncoder e = new XMLEncoder(
                          new BufferedOutputStream(
                              new FileOutputStream(file)));
       e.writeObject(shapes);
       e.close();
    } catch (Exception e) {
        System.out.println("not working");
    }
}
    public void loadData(String file) {
        try {
        XMLDecoder d = new XMLDecoder(
                          new BufferedInputStream(
                              new FileInputStream(file)));
       shapes = (List<DoodleShape>) d.readObject();
       d.close();
       sliderMin = 0;
       sliderMax = shapes.size();
       slider = sliderMax;
       setChanged();
       notifyObservers();
       
        } catch (Exception e) {
            System.out.println("not working");
        }
    }
}
