package javaapplication7;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class playstate1 extends JPanel implements ActionListener {
    
    //ส่วนของตัวแปลต่างๆ

    private final ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("level_background_for_a_mobile_game__by_bvigec-d5vi8b0.jpg"));
    private final ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("background_for_flash_game_by_pykodelbi-d4ly9hx.jpg"));
    private final ImageIcon imgstate3 = new ImageIcon(this.getClass().getResource("state3.jpg"));
    private final ImageIcon pause = new ImageIcon(this.getClass().getResource("puse.png"));
    private final ImageIcon back = new ImageIcon(this.getClass().getResource("back.png"));
    ยาน m = new ยาน();

    homegames hg = new homegames();
    ImageIcon feildover = new ImageIcon(this.getClass().getResource("a_cartoon_forest_election_by_88srenaissance88-d4zim5f.jpg"));
    ImageIcon exitover = new ImageIcon(this.getClass().getResource("exit.jpg"));
    ImageIcon restart = new ImageIcon(this.getClass().getResource("Start.jpg"));
    JButton BStartover = new JButton(restart);
    JButton BExitover = new JButton(exitover);

    private JLabel score = new JLabel();
    public JButton BPause = new JButton(pause);
    public JButton BExithome = new JButton(back);
    public ArrayList<Fireball> fireball = new ArrayList<Fireball>();
    public ArrayList<Ma1> ba1 = new ArrayList<Ma1>();
    public ArrayList<Ma2> ba2 = new ArrayList<Ma2>();
    public ArrayList<Ma3> ba5 = new ArrayList<Ma3>();
    public ArrayList<Ma4> ba6 = new ArrayList<Ma4>();
    public ArrayList<Bosss> boss = new ArrayList<Bosss>();

    public int times, win = 0;
    public int HP = 3;
    boolean timestart = true;
    boolean startball = false;

    public int scor = 0;
    
    Thread time = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }

                if (timestart == false) {
                    repaint();
                }
            }
        }
    });

    Thread actor = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }
    });
    //ควบคุมการเกิดของจรวดลูกเล็ก
    Thread ma1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 10000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    ba1.add(new Ma1());
                }
            }
        }
    });
    //ควบคุมการเกิดจรวดลูกใหญ่
    Thread ma2 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 10000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    ba2.add(new Ma2());
                }
            }
        }
    });
    //ควบคุมการเกิดของufo
    Thread ma3 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 10000)+2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    ba5.add(new Ma3());
                }
            }
        }
    });
    //ควบคุมการเกิดดาวเทียม
    Thread ma4 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 10000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    ba6.add(new Ma4());
                }
            }
        }
    });
    //ควบคุมการเกิดของบอส
    Thread Boss = new Thread(new Runnable() {
        public void run() {
            while (true) {

                try {
                    if (startball == false) {
                        Thread.sleep(10000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    boss.add(new Bosss());
                }

            }

        }
    });
    //ใช้ทำให้เวลานับถอยหลัง
    Thread t = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (timestart == false) {
                    times = (times - 1);

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    playstate1() {
        //ใส่ปุ่ม
        this.setFocusable(true);
        this.setLayout(null);
        BPause.setBounds(910, 80, 50, 50);
        BExithome.setBounds(910, 15, 50, 50);
        BPause.addActionListener(this);
        BExithome.addActionListener(this);
        this.add(BPause);
        this.add(BExithome);
        this.add(score);
        //การขับยาน
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int a = e.getKeyCode();

                if (a == KeyEvent.VK_A) {
                    m.x -= 10;
                    m.count++;
                } else if (a == KeyEvent.VK_D) {
                    m.x += 10;
                    m.count++;
                }
                if (m.count > 3) {
                    m.count = 0;
                } else if (a == KeyEvent.VK_SPACE) {
                    m.count = 5;
                    fireball.add(new Fireball(m.x, 550));
                }

            }

            public void keyReleased(KeyEvent e) {
                m.count = 0;
            }
        });

        m.x = 420;
        time.start();
        actor.start();
        t.start();

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        //--------------------------------------จบ------------------------------------------//
        if (times <= 0 || HP <= 0 || win == 1) {
            BPause.setBounds(480, 455, 50, 50);
            BExithome.setBounds(400, 455, 50, 50);
            this.setLayout(null);
            g.drawImage(feildover.getImage(), 0, 0, 1000, 800, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 40));
            g.drawString("SCORE   " + scor, 335, 420);
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 70));
            if (win == 1) {
                g.drawString("- VICTORY- ", 260, 350);
            } else {
                g.drawString("GAME OVER", 255, 350);
            }
        } //----------------------------------------3-------------------------------------------------//
        else if (times <= 21) {

            ma1.stop();
            ma2.stop();
            ma3.stop();
            ma4.stop();
            g.drawImage(imgstate3.getImage(), 0, 0, 1000, 800, this);

            g.drawImage(m.im[m.count].getImage(), m.x, 550, 110, 160, this);

            if (m.x < 0) {
                m.x = this.getWidth() - 10;
            }
            if (m.x > this.getWidth()) {
                m.x = 20;
            }
            for (int i = 0; i < fireball.size(); i++) {
                Fireball ba = fireball.get(i);
                g.drawImage(ba.imfire[ba.count % 5].getImage(), ba.x, ba.y, 50, 50, null);
                ba.move();
                ba.count++;
                if (ba.y < 0) {
                    fireball.remove(i);
                }
            }

            //===========boss================
            for (int i = 0; i < boss.size(); i++) {
                if (boss.get(i).Y >= 800 || times > 20 || i > 0) {
                    boss.remove(i);
                } else if (times == 20) {
                    boss.get(0).Y = -200;
                } else if (times % 4 == 3) {
                    g.drawImage(boss.get(i).img5, boss.get(i).X, boss.get(i).Y, 300, 300, this);
                } else if (times % 4 == 2) {
                    g.drawImage(boss.get(i).imgg5, boss.get(i).X, boss.get(i).Y, 300, 300, this);
                } else if (times % 4 == 1) {
                    g.drawImage(boss.get(i).imggg5, boss.get(i).X, boss.get(i).Y, 300, 300, this);
                } else if (times % 4 == 0) {
                    g.drawImage(boss.get(i).imgggg5, boss.get(i).X, boss.get(i).Y, 300, 300, this);
                }
            }
            for (int i = 0; i < fireball.size(); i++) {
                for (int j = 0; j < boss.size(); j++) {
                    if (Intersect(fireball.get(i).getbound(), boss.get(j).getbound()) && i <= fireball.size() && j <= boss.size()) {
                        fireball.remove(i);
                        boss.get(j).hp--;
                        if (boss.get(j).hp <= 0) {
                            boss.remove(j);
                            scor += 1000;
                            win = 1;
                            Boss.stop();
                        }
                    }
                }
            }

            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 30));
            g.setColor(Color.WHITE);
            g.drawString("Your Time " + times, 10, 40);
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 30));
            g.drawString("SCORE =  " + scor, 100, 740);
            g.setColor(Color.RED);
            g.drawString("♥  " + HP, 10, 740);
        } //--------------------------------------2------------------------------------------------//
        else if (times <= 50) {//ด้าน2

            g.drawImage(imgstate2.getImage(), 0, 0, 1000, 800, this);

            g.drawImage(m.im[m.count].getImage(), m.x, 550, 110, 160, this);

            if (m.x < 0) {
                m.x = this.getWidth() - 10;
            }
            if (m.x > this.getWidth()) {
                m.x = 20;
            }
            for (int i = 0; i < fireball.size(); i++) {
                Fireball ba = fireball.get(i);
                g.drawImage(ba.imfire[ba.count % 5].getImage(), ba.x, ba.y, 50, 50, null);
                ba.move();
                ba.count++;
                if (ba.y < 0) {
                    fireball.remove(i);
                }
            }

            //===========ball1================
            for (int i = 0; i < ba1.size(); i++) {
                ba1.get(i).yy = 5;
                if (ba1.get(i).getY() >= 800) {
                    ba1.remove(i);
                    HP = HP - 1;
                } else if (m.x - 40 <= ba1.get(i).x && m.x + 40 >= ba1.get(i).x && ba1.get(i).y >= 500) {
                    ba1.remove(i);
                    HP = HP - 1;
                } else if (times % 2 == 0) {
                    g.drawImage(ba1.get(i).img1, ba1.get(i).getX(), ba1.get(i).getY(), 100, 100, this);
                } else if (times % 2 == 1) {
                    g.drawImage(ba1.get(i).imgg1, ba1.get(i).getX(), ba1.get(i).getY(), 100, 100, this);
                }
            }
            for (int i = 0; i < fireball.size(); i++) {
                for (int j = 0; j < ba1.size(); j++) {
                    if (Intersect(fireball.get(i).getbound(), ba1.get(j).getbound()) && i <= fireball.size() && j <= ba1.size()) {
                        ba1.remove(j);
                        fireball.remove(i);
                        scor += 20;
                    }
                }
            }
            //===========ball2================
            for (int i = 0; i < ba2.size(); i++) {
                if (ba2.get(i).getY() >= 800) {
                    ba2.remove(i);
                    HP = HP - 1;
                } else if (m.x - 40 <= ba2.get(i).x && m.x + 40 >= ba2.get(i).x && ba2.get(i).y >= 500) {
                    ba2.remove(i);
                    HP = HP - 1;
                } else if (times % 2 == 0) {
                    g.drawImage(ba2.get(i).img2, ba2.get(i).getX(), ba2.get(i).getY(), 100, 100, this);
                } else if (times % 2 == 1) {
                    g.drawImage(ba2.get(i).imgg2, ba2.get(i).getX(), ba2.get(i).getY(), 100, 100, this);
                }
            }
            for (int i = 0; i < fireball.size(); i++) {
                for (int j = 0; j < ba2.size(); j++) {
                    if (Intersect(fireball.get(i).getbound(), ba2.get(j).getbound()) && i <= fireball.size() && j <= ba2.size()) {
                        fireball.remove(i);
                        ba2.get(j).hp--;
                        if (ba2.get(j).hp <= 0) {
                            ba2.remove(j);
                            scor += 40;
                        }
                    }
                }
            }
            //===========ball5================
            for (int i = 0; i < ba6.size(); i++) {
                if (ba6.get(i).getY() >= 800) {
                    ba6.remove(i);
                } else {
                    if (times % 3 == 0) {
                        g.drawImage(ba6.get(i).img4, ba6.get(i).getX(), ba6.get(i).getY(), 100, 100, this);
                    } else if (times % 3 == 1) {
                        g.drawImage(ba6.get(i).imgg4, ba6.get(i).getX(), ba6.get(i).getY(), 100, 100, this);
                    } else if (times % 3 == 2) {
                        g.drawImage(ba6.get(i).imggg4, ba6.get(i).getX(), ba6.get(i).getY(), 100, 100, this);
                    }
                }
            }
            for (int i = 0; i < fireball.size(); i++) {
                for (int j = 0; j < ba6.size(); j++) {
                    if (Intersect(fireball.get(i).getbound(), ba6.get(j).getbound()) && i <= fireball.size() && j <= ba5.size()) {
                        ba6.remove(j);
                        fireball.remove(i);
                        scor -= 40;
                    }
                }
            }

            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 30));
            g.setColor(Color.WHITE);
            g.drawString("Your Time " + times, 10, 40);
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 30));
            g.drawString("SCORE =  " + scor, 100, 740);
            g.setColor(Color.RED);
            g.drawString("♥  " + HP, 10, 740);

        } //------------------------------------1------------------------------------------//
        else {//ด่าน1

            g.drawImage(imgstate1.getImage(), 0, 0, 1000, 800, this);

            g.drawImage(m.im[m.count].getImage(), m.x, 550, 110, 160, this);

            if (m.x < 0) {
                m.x = this.getWidth() - 10;
            }
            if (m.x > this.getWidth()) {
                m.x = 20;
            }
            for (int i = 0; i < fireball.size(); i++) {
                Fireball ba = fireball.get(i);
                g.drawImage(ba.imfire[ba.count % 5].getImage(), ba.x, ba.y, 50, 50, null);
                ba.move();
                ba.count++;
                if (ba.y < 0) {
                    fireball.remove(i);
                }
            }

            //========================================ball1=================
            for (int i = 0; i < ba1.size(); i++) {
                if (ba1.get(i).getY() >= 800) {
                    ba1.remove(i);
                    HP = HP - 1;
                } else if (m.x - 40 <= ba1.get(i).x && m.x + 40 >= ba1.get(i).x && ba1.get(i).y >= 500) {
                    ba1.remove(i);
                    HP = HP - 1;
                } else if (times % 2 == 0) {
                    g.drawImage(ba1.get(i).img1, ba1.get(i).getX(), ba1.get(i).getY(), 100, 100, this);
                } else if (times % 2 == 1) {
                    g.drawImage(ba1.get(i).imgg1, ba1.get(i).getX(), ba1.get(i).getY(), 100, 100, this);
                }
            }
            for (int i = 0; i < fireball.size(); i++) {
                for (int j = 0; j < ba1.size(); j++) {
                    if (Intersect(fireball.get(i).getbound(), ba1.get(j).getbound()) && i <= fireball.size() && j <= ba1.size()) {
                        ba1.remove(j);
                        fireball.remove(i);
                        scor += 10;
                    }
                }
            }
            //========================ball2=========================
            for (int i = 0; i < ba2.size(); i++) {
                if (ba2.get(i).getY() >= 800) {
                    ba2.remove(i);
                    HP = HP - 1;
                } else if (m.x - 40 <= ba2.get(i).x && m.x + 40 >= ba2.get(i).x && ba2.get(i).y >= 500) {
                    ba2.remove(i);
                    HP = HP - 1;
                } else if (times % 2 == 0) {
                    g.drawImage(ba2.get(i).img2, ba2.get(i).getX(), ba2.get(i).getY(), 100, 100, this);
                } else if (times % 2 == 1) {
                    g.drawImage(ba2.get(i).imgg2, ba2.get(i).getX(), ba2.get(i).getY(), 100, 100, this);
                }
            }
            for (int i = 0; i < fireball.size(); i++) {
                for (int j = 0; j < ba2.size(); j++) {
                    if (Intersect(fireball.get(i).getbound(), ba2.get(j).getbound()) && i <= fireball.size() && j <= ba2.size()) {
                        ba2.remove(j);
                        fireball.remove(i);
                        scor += 20;
                    }
                }
            }
            //=================================ball5=============
            for (int i = 0; i < ba5.size(); i++) {
                if (ba5.get(i).getX() >= 1500) {
                    ba5.remove(i);
                } else {
                    switch (times % 3) {
                        case 0:
                            g.drawImage(ba5.get(i).img3, ba5.get(i).getX(), ba5.get(i).getY(), 100, 100, this);
                            break;
                        case 1:
                            g.drawImage(ba5.get(i).imgg3, ba5.get(i).getX(), ba5.get(i).getY(), 100, 100, this);
                            break;
                        case 2:
                            g.drawImage(ba5.get(i).imggg3, ba5.get(i).getX(), ba5.get(i).getY(), 100, 100, this);
                            break;
                        default:
                            break;
                    }
                }
            }
            for (int i = 0; i < fireball.size(); i++) {
                for (int j = 0; j < ba5.size(); j++) {
                    if (Intersect(fireball.get(i).getbound(), ba5.get(j).getbound()) && i <= fireball.size() && j <= ba5.size()) {
                        ba5.remove(j);
                        fireball.remove(i);
                        times -= 10;
                        scor+=10;
                    }
                }
            }
            //แสดงเวลาและพลังชีวิต
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 30));
            g.drawString("Your Time " + times, 10, 40);
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 30));
            g.setColor(Color.BLACK);
            g.drawString("SCORE =  " + scor, 100, 740);
            g.setColor(Color.RED);
            g.drawString("♥  " + HP, 10, 740);

        }
    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BStartover) {
            this.setSize(1000, 800);
            this.add(hg);
            this.setLocation(null);
            timestart = true;
            startball = true;
        } else if (e.getSource() == BExitover) {
            System.exit(0);
        }
    }
}
