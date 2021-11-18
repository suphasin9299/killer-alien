package javaapplication7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;

//หน้าแรกของเกม

public class PlayGames extends JFrame implements ActionListener {

    homegames homegames1 = new homegames();
    playstate1 state1 = new playstate1();

    public PlayGames() {
        this.setSize(1000, 800);
        this.add(homegames1);
        homegames1.BExit1.addActionListener(this);
        homegames1.BStart.addActionListener(this);
        state1.BExithome.addActionListener(this);
        state1.BPause.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homegames1.BStart) {//เมื่อกดปุ่มstartทำการเริ่มเกม
            this.setLocationRelativeTo(null);
            this.remove(homegames1);
            this.setSize(1000, 800);
            this.add(state1);
            state1.requestFocusInWindow();
            state1.timestart = false;
            state1.scor = 0;        
            state1.HP = 3;          
            state1.times = 100;     
            state1.startball = false;
            state1.timestart = false;
            state1.ma1.start();
            state1.ma2.start();
            state1.ma3.start();
            state1.ma4.start();
            state1.Boss.start();
    
        } else if (e.getSource() == state1.BExithome) {//เมื่อกดปุ่มexitจะปิดเกม
            System.exit(0);
        } else if (e.getSource() == homegames1.BExit1) {
            System.exit(0);
        } else if (e.getSource() == state1.BPause) {//เมื่อกดปุ่มresetจะเริ่มเกมใหม่
            dispose();
            JFrame jf = new PlayGames();
            jf.setSize(1000, 800);
            jf.setTitle("เกม ยานอวกาศ");
            jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jf.setVisible(true);
            jf.setLocationRelativeTo(null);

        }
        this.validate();
        this.repaint();
    }
    
    public static void main(String[] args) {
        JFrame jf = new PlayGames();
        jf.setSize(1000, 800);
        jf.setTitle("เกม ยานอวกาศ");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }

}
