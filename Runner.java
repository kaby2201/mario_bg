import java.awt.Component;
import javax.swing.JFrame;

public class Runner extends JFrame {

    public Runner() {
        setTitle("Mario spill");
        setSize(1000, 600);

        ScrollingBackground back = new ScrollingBackground();
        ((Component)back).setFocusable(true);
        getContentPane().add(back);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Runner();
    }

}
