package javaapplication7;
//นิยามของดาวเทียม

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class Ma4 extends Ma1 {

    public Image img4, imgg4, imggg4;
    public int count = 0;

    Ma4() {
        URL imageURL1 = this.getClass().getResource("ดาวเทียม1.png");
        this.img4 = Toolkit.getDefaultToolkit().getImage(imageURL1);
        URL imageURL2 = this.getClass().getResource("ดาวเทียม2.png");
        this.imgg4 = Toolkit.getDefaultToolkit().getImage(imageURL2);
        URL imageURL3 = this.getClass().getResource("ดาวเทียม3.png");
        this.imggg4 = Toolkit.getDefaultToolkit().getImage(imageURL3);
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                y += 1;
                if (y >= 1100) {
                    img4 = null;
                    imgg4 = null;
                    imggg4 = null;
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

    @Override
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 80, 45));
    }

}
