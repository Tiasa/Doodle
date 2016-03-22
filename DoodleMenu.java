/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package doodle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 *
 * @author Tiasa
 */
public class DoodleMenu extends JMenuBar implements Observer {
    private DoodleModel model;
    DoodleMenu(DoodleModel model) {
        super();
        this.model = model;
        JMenu file,view;
        JMenuItem save, load, exit, full_size, fit;
        file = new JMenu("File");
        save = new JMenuItem("Save");
        save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            JFileChooser chooser = new JFileChooser();
                            int retrival = chooser.showSaveDialog(null);
                            if (retrival == JFileChooser.APPROVE_OPTION) {
                            try {                                 
                                    model.saveData(chooser.getSelectedFile().getAbsolutePath());
                                } catch (Exception ex) {
                                    System.out.println("Error saving");
                                }
                            }
                           
			}
		});
        file.add(save);
        load = new JMenuItem("Load");
        load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            JFileChooser chooser = new JFileChooser();
                            int retrival = chooser.showOpenDialog(null);
                            if (retrival == JFileChooser.APPROVE_OPTION) {
                            try {                                 
                                    model.loadData(chooser.getSelectedFile().getAbsolutePath());
                                } catch (Exception ex) {
                                    System.out.println("Error saving");
                                }
                            }
			}
		});
        file.add(load);
        exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
                            
			}
		});
        file.add(exit);
        add(file);
        view = new JMenu("View");
        full_size = new JMenuItem("Full-Size View");
        full_size.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
                            
			}
		});
        view.add(full_size);
        fit = new JMenuItem ("Fit View");
        fit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                           
			}
		});
        add(view);
    }
    @Override
    public void update(Observable o, Object arg) {
        
    }
    
}
