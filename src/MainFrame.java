import javax.swing.*;

public class MainFrame extends JFrame implements Runnable {

    private DrawPanel p;
    private Thread windowThread;
    JLabel infolabel;

    public MainFrame(String display) {
        super(display);
        int frameWidth = 1000;
        int frameHeight = 1000;
        p = new DrawPanel();
        infolabel = new JLabel("SATSATSATSATIIIIIIIIII");
        this.add(p);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(100, 10);
        this.setVisible(true);
        startThread();

    }

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }

    public void run() {
        while (true) {
            p.repaint();
        }
    }
}