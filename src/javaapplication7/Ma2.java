package javaapplication7;
//นิยามของจรวดใหญ่

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class Ma2 extends Ma1 {

    public Image img2,imgg2;
    public int hp = 2;

    Ma2() {

        URL imageURL1 = this.getClass().getResource("ball2.png");
        this.img2 = Toolkit.getDefaultToolkit().getImage(imageURL1);
        URL imageURL11 = this.getClass().getResource("ball22.png");
        this.imgg2 = Toolkit.getDefaultToolkit().getImage(imageURL11);
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
                y += 1;
                if (y >= 1100) {
                    img2 = null;
                    imgg2 = null;
                    runner = null;
                    y = -500;
                    x = -500;
                }
                try {
                    runner.sleep(30);
                } catch (InterruptedException e) {
                }
            }
        }
    });


}
