package javaapplication7;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ยาน {

    public ImageIcon[] im = new ImageIcon[6];
    public int x;
    public int count = 0;

    ยาน() {
        for (int i = 0; i < im.length; i++) {
            im[i] = new ImageIcon(this.getClass().getResource((i + 1) + ".png"));
        }
    }
}
