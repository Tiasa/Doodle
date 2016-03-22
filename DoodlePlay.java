/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package doodle;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author Tiasa
 */
public class DoodlePlay extends JPanel implements Observer {
    private DoodleModel model;
    private JSlider slider = null;
    public DoodlePlay(DoodleModel model) {
        super();
        this.model = model;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JButton play = new JButton ("Play");
        play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (model.getSlider()<model.getSliderMax()) {
                                    model.setSlider(model.getSlider()+1);
                                    try {
                                    TimeUnit.SECONDS.sleep(1);
                                    } catch (Exception ex) {
                                        
                                    }
                                }
			}
		});
        slider = new JSlider(JSlider.HORIZONTAL,0,0,0);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setBorder(
        BorderFactory.createEmptyBorder(0,0,10,0));
        slider.setSnapToTicks(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                    JSlider source = (JSlider)e.getSource();
                    if (source.getValueIsAdjusting()) {
                        
                        model.setSlider((int)source.getValue());
                    }
                }
        });
        JButton start = new JButton("Start");
        JButton end = new JButton ("End");
        start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setSlider(slider.getMinimum());
			}
		});
        end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setSlider(slider.getMaximum());
			}
		});
        add(play);
        add(slider);
        add(start);
        add (end);
    }
    @Override
    public void update(Observable o, Object arg) {
            if (slider != null) {
                slider.setMinimum(model.getSliderMin());
                slider.setValue(model.getSlider());
                slider.setMaximum(model.getSliderMax());
            }
        }    
}
