package CALC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
  public JPanel panel;
  private JButton oneButton;
  private JButton twoButton;
  private JButton threeButton;
  private JButton plusButton;
  private JButton eightButton;
  private JButton fourButton;
  private JButton fiveButton;
  private JButton sixButton;
  private JButton minusButton;
  private JButton sevenButton;
  private JButton nineButton;
  private JButton multiplyButton;
  private JButton zeroButton;
  private JButton equalsButton;
  private JButton divideButton;
  private JButton cButton;
  private JButton acButton;
  private JTextField textField;
  private JButton dotButton;
  private JButton modulusButton;
  private double lValue;
  private double rValue;
  private double result;
  private char operation='e';
  private String value="";

  public JPanel getPanel() {
    return panel;
  }

  public Calculator() {
    oneButton.addActionListener(this);
    twoButton.addActionListener(this);
    threeButton.addActionListener(this);
    fourButton.addActionListener(this);
    fiveButton.addActionListener(this);
    sixButton.addActionListener(this);
    sevenButton.addActionListener(this);
    eightButton.addActionListener(this);
    nineButton.addActionListener(this);
    zeroButton.addActionListener(this);
    plusButton.addActionListener(this);
    minusButton.addActionListener(this);
    multiplyButton.addActionListener(this);
    divideButton.addActionListener(this);
    equalsButton.addActionListener(this);
    acButton.addActionListener(this);
    cButton.addActionListener(this);
    dotButton.addActionListener(this);
    modulusButton.addActionListener(this);
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource()==acButton){
      lValue=0.0;
      rValue=0.0;
      operation='e';
      value="";
    }
    else if(e.getSource()==cButton){
      if(value.length()>1)
        value=value.substring(0,value.length()-1);
      else
        value="";


    }
    else if(e.getSource()==equalsButton){
      equalButtonOperation();
    }
    else if (e.getSource()==plusButton||e.getSource()==multiplyButton||e.getSource()==minusButton||e.getSource()==divideButton||e.getSource()==modulusButton){
      if(operation!='e'){
        equalButtonOperation();
        lValue=result;
      }
      operation=e.getActionCommand().charAt(0);
      value="";
    }
    else {
      try {
        if(textField.getText().length()>18){}
        else {
          if (operation == 'e') {
            if (value.contains(".") && e.getActionCommand().equals(".")) {
            } else {
              value = value + e.getActionCommand();
              lValue = Double.parseDouble(value);
            }
          } else {
            if (value.contains(".") && e.getActionCommand().equals(".")) {
            } else {
              value = value + e.getActionCommand();
              rValue = Double.parseDouble(value);
            }
          }
        }
      } catch (Exception er) {
      }
    }
    value=value.replace('E','e');
    textField.setText(value);
  }

  private void perform() {
    switch (operation){
      case '+':
        result=lValue+rValue;
        break;
      case '-':
        result=lValue-rValue;
        break;
      case '/':
        result=lValue/rValue;
        break;
      case '*':
        result=lValue*rValue;
        break;
      case '%':
        result=lValue%rValue;
        break;
      default:
        result=lValue+rValue;
    }
  }
  void equalButtonOperation(){
    perform();
    value=Double.toString(result);
    lValue=result;
    //rValue=0;
  }
}
