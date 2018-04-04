/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbmg;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


/**
 *
 * @author Mimi
 */
public class GamePanel extends JPanel{
    
    static String files[] = {
        "src/bbmg/images/pic1.jpg",
        "src/bbmg/images/pic2.jpg",
        "src/bbmg/images/pic3.jpg",
        "src/bbmg/images/pic4.jpg",
        "src/bbmg/images/pic5.jpg",
        "src/bbmg/images/pic6.jpg",
        "src/bbmg/images/pic7.jpg",
        "src/bbmg/images/pic8.jpg"};
    static JButton buttons[];
    ImageIcon closedIcon;
    int numButtons;
    ImageIcon icons[];
    Timer myTimer;
    
    static int score = 0;
    int numClicks = 0;
    int oddClickIndex = 0;
    int currentIndex = 0;
    
    public GamePanel(){
        
        initGamePanel();
    }
    
    private void initGamePanel(){
        setLayout(new GridLayout(4, files.length));
        
        //adding buttons
        closedIcon = new ImageIcon("src/bbmg/images/back.jpg");
        numButtons = files.length * 2;
        buttons = new JButton[numButtons];
        icons = new ImageIcon[numButtons];
        
        for (int i = 0, j = 0; i < files.length; i++) {
            icons[j] = new ImageIcon(files[i]);
            j = makeButtons(j);

            icons[j] = icons[j - 1];
            j = makeButtons(j);
        }

        // randomize icons array
        Random gen = new Random();
        for (int i = 0; i < numButtons; i++) {
            int rand = gen.nextInt(numButtons);
            ImageIcon temp = icons[i];
            icons[i] = icons[rand];
            icons[rand] = temp;
        }
        
        myTimer = new Timer(1000, new TimerListener());
        
        setVisible(false);
    
    }
    
    private int makeButtons(int j){
        buttons[j] = new JButton("");
        buttons[j].addActionListener(new ImageButtonListener());
        buttons[j].setIcon(closedIcon);
        add(buttons[j++]);
        return j;
}
    
    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            buttons[currentIndex].setIcon(closedIcon);
            buttons[oddClickIndex].setIcon(closedIcon);
            myTimer.stop();
        }
    }
    private class ImageButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            // we are waiting for timer to pop - no user clicks accepted
            if (myTimer.isRunning())
                return;
            
            numClicks++;
            System.out.println(numClicks);
            
            // which button was clicked?
            for (int i = 0; i < numButtons; i++) {
                if (e.getSource() == buttons[i]) {
                    buttons[i].setIcon(icons[i]);
                    currentIndex = i;
                }
            }
            
            // check for even click
            if (numClicks % 2 == 0) {
                // check whether same position is clicked twice!
                if (currentIndex == oddClickIndex) {
                    numClicks--;
                    return;
                }
                // are two images matching?
                if (icons[currentIndex] != icons[oddClickIndex]) {
                    // show images for 1 sec, before flipping back
                    myTimer.start(); 
                    //score--;
                }else{
                    //score system
                    score++;
                    System.out.println("Score " + score);
                }
                if(score == 8){
                        Message.infoBox("You WIN!", "Congratulations!");
                        }
            } else {
                // we just record index for odd clicks
                oddClickIndex = currentIndex;
                
            }
        }
    }
    
    public int getScore(){
        return score;
    }
    public void reset(){
        removeAll();
        initGamePanel();
    }
}
