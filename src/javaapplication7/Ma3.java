package javaapplication7;
//นิยามของufo

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class Ma3 extends Ma1 {

    public Image img3,imgg3,imggg3;
    public int count = 0;
    public int y = (int) ((Math.random() * 250) + 20);
    public int x = -30;

    Ma3() {

        URL imageURL1 = this.getClass().getResource("นก1.png");
        this.img3 = Toolkit.getDefaultToolkit().getImage(imageURL1);
        URL imageURL2 = this.getClass().getResource("นก2.png");
        this.imgg3 = Toolkit.getDefaultToolkit().getImage(imageURL2);
        URL imageURL3 = this.getClass().getResource("นก3.png");
        this.imggg3 = Toolkit.getDefaultToolkit().getImage(imageURL3);
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                x += 2;
                if (y >= 1100) {
                    img3 = null;
                    imgg3 = null;
                    imggg3 = null;
                    runner = null;
                    y = -500;
                    x = -500;
                }
                try {
                    runner.sleep(50);
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

    @Override
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x - 5, y, 80, 45));
    }

}
