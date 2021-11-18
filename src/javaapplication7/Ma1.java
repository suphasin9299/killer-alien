package javaapplication7;
//นิยามของจรวดเล็ก

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class Ma1 {

    public Image img1,imgg1;
    public int y = -30, yy = 0;
    public int x = (int) ((Math.random() * 850) + 20);
    public int count = 0;

    Ma1() {
        URL imageURL = this.getClass().getResource("ball1.png");
        this.img1 = Toolkit.getDefaultToolkit().getImage(imageURL);
        URL imageURL1 = this.getClass().getResource("ball11.png");
        this.imgg1 = Toolkit.getDefaultToolkit().getImage(imageURL1);
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
                y += 1;
                if (y >= 1100) {
                    img1 = null;
                    imgg1 = null;
                    runner = null;
                    y = -500;
                    x = -500;
                }
                try {
                    runner.sleep(10 - yy);
                } catch (InterruptedException e) {
                }
            }
        }
    });


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x - 5, y, 70, 50));
    }
}
