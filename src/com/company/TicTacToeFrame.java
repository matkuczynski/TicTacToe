package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class TicTacToeFrame extends JFrame implements ActionListener{

    private ArrayList<JButton> buttons = new ArrayList();


    public TicTacToeFrame(){
            setTitle("Kółko i krzyżyk");
            setLayout(new GridLayout(3,3));


        for (int i=0; i<=8; i++){
            JButton jButton = new JButton("");
            jButton.putClientProperty("id", i);
            jButton.addActionListener(this);

            add(jButton);
            buttons.add(jButton);
        }
        setSize(600,600);
        setVisible(true);
        setBackground(Color.green);
    }
    public boolean isWinner(int i, int j, int k) {
        System.out.println(buttons.get(i).getText());
        if (buttons.get(i).getText().equals("")){
            return false;
        }
        if (buttons.get(i).getText().equals(buttons.get(j).getText()) &&
                buttons.get(j).getText().equals(buttons.get(k).getText()))  {
            return true;

        } else {
            return false;
        }
    }
    public boolean isWinner(){
        if (isWinner(0,1,2)){
            return true;
        }
        if (isWinner(3,4,5)){
            return true;
        }
        if (isWinner(6,7,8)){
            return true;
        }
        if (isWinner(0,3,6)){
            return true;
        }
        if (isWinner(1,4,7)){
            return true;
        }
        if (isWinner(2,5,8)){
            return true;
        }
        if (isWinner(0,4,8)){
            return true;
        }
        if (isWinner(2,4,6)){
            return true;
        }
        else {
            return false;
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeFrame();
            }
        });
    }
    boolean isX = true;

    public void setAllDisabled(){
        for (JButton button: buttons){
            button.setEnabled(false);
        }
    }
    public void showEndOfTheGame(){
        for (JButton button: buttons){

        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (isX){
                button.setText("O");
                isX=false;
        }
        else {
            button.setText("X");

            isX=true;
        }
        button.setEnabled(false);
        if (isWinner()){
            JOptionPane.showMessageDialog(null, "koniec gry");
            setAllDisabled();


        }

        System.out.println("Kliknięto");
    }
}
