package cs5004.animator.view;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.AnimationVisual;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;



public class Visual extends JFrame implements AnimationView, ActionListener {
  private Timer timer;
  private VisualPanel modelPanel;     
  private AnimationVisual model;
  private int speed;
  static int currentTime = 0;
  private JButton quitButton;  
  private JMenuItem quit;
  private JPanel buttonPane;

 //this sets jFrame  
  public Visual(AnimationVisual model2, int speed) {
    super("Animator");
    this.model = model2;
    this.setBackground(Color.white);
    this.setSize(1000, 1000);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.timer = new Timer(16, this);   
    this.modelPanel = new VisualPanel(this.model);
    this.setVisible(true);
    this.add(modelPanel);
    this.speed = speed;
    timer.start();
    
    modelPanel.repaint();
    

    
//    this.setLayout(new FlowLayout());
    
    
    
    
//    modelPanel.repaint();
    //*************************
    

    
    
 
    
    //override a paint component method and will be called every time we repaint 
    //paint component super in paint component and pass parameter g


    //implements action listener overrides action performed method
    //this--> line 112
    //no buttons in panel makes the listening event much more simple 
    
    
    
    
    

  }

  @Override
  public void displayText(String str) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("displayText is not supported");
    
    
  }

  @Override
  public void displaySVG(String str) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("displaySVG is not supported");
  }

  @Override
  public void displayVisual(AnimationVisual model) {
    //animator calls displayVisual
    //have a setter for the visualPanel to be instantiated 
    
      
    
    


    
    
  
    
  
    
     
    
    
  }

  @Override
  public void actionPerformed(ActionEvent e) { 
//    if(this.timer ) check if it is the timer calling the action 
    //event of the making of an object
    currentTime += 16;
    //below is updating the timer
    this.modelPanel.tick((currentTime * speed)); // high number goes faster (each tick is a milisecond)
    
    this.modelPanel.repaint();
    
    
  
    
  }
  



  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
