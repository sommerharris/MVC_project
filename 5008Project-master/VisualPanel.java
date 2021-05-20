package cs5004.animator.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationVisual;
import cs5004.animator.model.MoveAnimation;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;

public class VisualPanel extends JPanel {
  
  AnimationVisual model; // this will eventually change 
  private List<Animation> animationList;
  private List<Shape> currentShapeList;
  private int tick;
  
  //animator model that will only have the getters needed for visual in model
  //instead of animationModel model
  public VisualPanel(AnimationVisual model) {
    super(true);
    
    this.setBackground(Color.WHITE);
    this.setSize(model.getDimensionsWidth(), model.getDimensionsHeight());

    this.setLocation(model.getDimensionsX(), model.getDimensionsY());
    
    this.model = model;
    this.tick = 0;
    this.animationList = model.getAnimationList();
    this.currentShapeList = new ArrayList<Shape>();
    
  }
  
  public void updateModel(AnimationVisual model) {
    this.model = model;
    this.repaint();
  }
  
  public void tick(int tick) {
    this.tick = tick;
  }
  

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    currentShapeList = this.getOnScreenShapes(model.getAnimationList(), tick);
    
    if(currentShapeList != null && currentShapeList.size() != 0) {


      Graphics g2d = (Graphics) g;
    
      for(Shape shape: currentShapeList) {
        
        g.setColor(shape.getCurrentColor());
        
        
        
        if(shape.getType() == "Rectangle") {
          g.fillRect((int) shape.getCurrentX(), (int) shape.getCurrentY(), 
              (int) shape.getCurrentWidth(), (int) shape.getCurrentHeight());
        }
        
        if(shape.getType() == "Ellipse") {
          g.fillOval((int) shape.getCurrentX(), (int) shape.getCurrentY(), 
              (int) shape.getCurrentWidth(), (int) shape.getCurrentHeight());
        }
        
      
      repaint();
      
      }
      }
  }
   

  
private List<Shape> getOnScreenShapes(List<Animation> animationList, int time) {
  //tweening HERE --> this way we have the list at a current time 
  for(Animation animation : animationList) {
    
    if (animation.shapeOnScreen(time)){
      
      if(animation.getTypeAnimation() == "Move") {
        
        
        this.currentShapeList.add(this.tweeningMove(animation, time)); 
     
      }
      
     if(animation.getTypeAnimation() == "ChangeWidth") {
        
        
        this.currentShapeList.add(this.tweeningWidth(animation, time)); 
        
      
      }
      
     if(animation.getTypeAnimation() == "ChangeHeight") {
       
       
       this.currentShapeList.add(this.tweeningHeight(animation, time)); 
       
     
     }
     
     if(animation.getTypeAnimation() == "ChangeColor") {
       
       
       this.currentShapeList.add(this.tweeningColor(animation, time)); 
       
     
     }
      
    }
  }
  
  return this.currentShapeList;
  

}


public Shape tweeningMove(Animation animation, int time) {
  
  if(animation.getStartX() != animation.getEndX()) {
    double a = animation.getStartX();
    double b = animation.getEndX();
    int timeA = animation.getStartTime();
    int timeB = animation.getEndTime();
    double tweenX = (a * (timeB - time) / (timeB - timeA)) + (b*(time - timeA) / (timeB - timeA));
    
    
//    animation.currentX(tweenX);
    animation.getAnimationShape().setCurrentX(tweenX);
  }
  
  if(animation.getStartY() != animation.getEndY()) {
      double a2 = animation.getStartX();
      double b2 = animation.getEndX();
      int timeA2 = animation.getStartTime();
      int timeB2 = animation.getEndTime();
      double tweenY = (a2 * (timeB2 - time) / (timeB2 - timeA2)) + (b2*(time - timeA2) / (timeB2 - timeA2));
      
      
//      animation.currentY(tweenY); 
      animation.getAnimationShape().setCurrentY(tweenY);
    
     }
 
 return animation.getAnimationShape();
  
}

public Shape tweeningWidth(Animation animation, int time) {
  
  
    double a = animation.getStartWidth();
    double b = animation.getEndWidth();
    int timeA = animation.getStartTime();
    int timeB = animation.getEndTime();
    double tweenWidth = (a * (timeB - time) / (timeB - timeA)) + (b * (time - timeA) / (timeB - timeA));
    
    animation.getAnimationShape().setCurrentWidth(tweenWidth);

  
  
 return animation.getAnimationShape();
  
}

public Shape tweeningHeight(Animation animation, int time) {
  
 
    double a = animation.getStartHeight();
    double b = animation.getEndHeight();
    int timeA = animation.getStartTime();
    int timeB = animation.getEndTime();
    double tweenHeight = (a * (timeB - time) / (timeB - timeA)) + (b * (time - timeA) / (timeB - timeA));
    
    animation.getAnimationShape().setCurrentHeight(tweenHeight);

  
  
 return animation.getAnimationShape();
  
}



public Shape tweeningColor(Animation animation, int time) {
  double redValue = animation.getStartRed();
  double greenValue = animation.getStartGreen();
  double blueValue = animation.getStartBlue();
  
  if(animation.getStartRed() != animation.getEndRed()) {
    double a = animation.getStartRed();
    double b = animation.getEndRed();
    int timeA = animation.getStartTime();
    int timeB = animation.getEndTime();
    double tweenRed = (a * (timeB - time) / (timeB - timeA)) + (b*(time - timeA) / (timeB - timeA));
    
    redValue = tweenRed;

    
  }
  
  if(animation.getStartGreen() != animation.getEndGreen()) {
    double a = animation.getStartGreen();
    double b = animation.getEndGreen();
    int timeA = animation.getStartTime();
    int timeB = animation.getEndTime();
    double tweenGreen = (a * (timeB - time) / (timeB - timeA)) + (b*(time - timeA) / (timeB - timeA));
    
    greenValue = tweenGreen;

    
  }
  
  if(animation.getStartBlue() != animation.getEndBlue()) {
    double a = animation.getStartBlue();
    double b = animation.getEndBlue();
    int timeA = animation.getStartTime();
    int timeB = animation.getEndTime();
    double tweenBlue = (a * (timeB - time) / (timeB - timeA)) + (b*(time - timeA) / (timeB - timeA));
    
    blueValue = tweenBlue;

    
  }
  
  Color currentC = new Color((int)redValue, (int)greenValue, (int)blueValue);
  
  animation.getAnimationShape().setCurrentColor(currentC);



return animation.getAnimationShape();

}




////i.e. time = 2, animation start time = 1, animation end time = 6
public boolean shapeOnScreen(Animation animation, int time) {
 
  if (animation.getStartTime() <= time && animation.getEndTime() >= time) {
    return true;
  }
  return false;

  }
}





