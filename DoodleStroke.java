/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package doodle;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Tiasa
 */
public class DoodleStroke extends JPanel implements Observer {
    private DoodleModel model;
    DoodleStroke(DoodleModel model) {
        super(new GridLayout(4,1));
        this.model = model;
        JLabel stroke = new JLabel("Stroke Thickness",JLabel.CENTER);
        Button stroke1 = new Button("Stroke 1");
        Button stroke2 = new Button("Stroke 2");
        Button stroke3 = new Button("Stroke 3");
        stroke1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setStroke(1);
			}
		});
        stroke2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setStroke(2);
			}
		});
        stroke3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setStroke(3);
			}
		});
        add(stroke);
        add(stroke1);
        add(stroke2);
        add(stroke3);
    }
    @Override
    public void update(Observable o, Object arg) {
    }
    
}
