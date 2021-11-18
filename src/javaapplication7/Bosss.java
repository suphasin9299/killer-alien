package javaapplication7;
//นิยามของบอส

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class Bosss extends Ma1 {

    public Image img5, imgg5, imggg5, imgggg5;
    public int hp = 50, f = 1,X,Y;

    Bosss() {

        this.X = 450;
        this.Y = -200;
        URL imageURL = this.getClass().getResource("boss.png");
        this.img5 = Toolkit.getDefaultToolkit().getImage(imageURL);
        URL imageURL1 = this.getClass().getResource("boss1.png");
        this.imgg5 = Toolkit.getDefaultToolkit().getImage(imageURL1);
        URL imageURL2 = this.getClass().getResource("boss2.png");
        this.imggg5 = Toolkit.getDefaultToolkit().getImage(imageURL2);
        URL imageURL3 = this.getClass().getResource("boss3.png");
        this.imgggg5 = Toolkit.getDefaultToolkit().getImage(imageURL3);

        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (X >= 20 && f == 1) {
                    X-=4;
                    if (X <= 20) {
                        if(Y<0){Y+=50;}
                        Y+=30;
                        f = 0;
                    }
                } else if (X<=750 && f==0) {
                    X+=4;
                    if (X >= 750) {
                        if(Y<0){Y+=50;}
                        Y+=30;
                        f = 1;
                    }
                }
                
                if (Y >= 1100) {
                    img5 = null;
                    imgg5 = null;
                    imggg5 = null;
                    imgggg5 = null;
                    runner = null;
                    Y = -500;
                    X = -500;
                }
                try {
                    runner.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    });
    
    @Override
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(X - 10, Y, 240, 240));
    }

}
