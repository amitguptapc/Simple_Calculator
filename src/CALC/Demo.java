package CALC;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Demo {
  private static Image icon=null;
  public static void main(String[] args) {
    JFrame frame=new JFrame();
    Calculator c=new Calculator();
    frame.add(c.getPanel());
    frame.setTitle("Calculator");
    try {
      icon=ImageIO.read(Demo.class.getResource("images/icon.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    frame.pack();

    frame.setIconImage(icon);

    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
