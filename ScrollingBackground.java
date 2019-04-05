import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ScrollingBackground extends Canvas implements Runnable {

    //Vi lager 2 kobier av bakgrunnen
    private Background backOne;
    private Background backTwo;
    final private int speed = 25;

    private BufferedImage back;

    public ScrollingBackground() {
        backOne = new Background();
        backTwo = new Background(backOne.getImageWidth(), -600);

        new Thread(this).start();
        setVisible(true);
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.currentThread().sleep(this.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
            }
    }

    @Override
    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        Graphics2D twoD = (Graphics2D)window;

        if (back == null)
            back = (BufferedImage)(createImage(getWidth(), getHeight()));

        // Create a buffer to draw to
        Graphics buffer = back.createGraphics();

        // Put the two copies of the background image onto the buffer
        backOne.draw(buffer);
        backTwo.draw(buffer);

        // Draw the image onto the window
        twoD.drawImage(back, null, 0, 0);
    }

}
