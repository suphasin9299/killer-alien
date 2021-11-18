package javaapplication7;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//ใช้สร้างปุ่มและชื่อเกมในหน้าแรก

public class homegames extends JPanel {


    private ImageIcon feild = new ImageIcon(this.getClass().getResource("Ponyville_Background_by_Tsitra360.jpg"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.jpg"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("Start.jpg"));
    public JButton BStart = new JButton(starts);
    public JButton BExit1 = new JButton(exit);

    homegames() {
        setLayout(null);
        BExit1.setBounds(640, 650, 150, 90);
        add(BExit1);
        add(BStart);
        BStart.setBounds(810, 650, 150, 90);
        add(BStart);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(feild.getImage(), 0, 0, 1000, 800, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("2005_iannnnnTKO", Font.LAYOUT_LEFT_TO_RIGHT, 90));
        g.drawString("Killer Alien",300,450);
    }
}
