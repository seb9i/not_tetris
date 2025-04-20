import Bricks.Brick;
import Bricks.BrickLayout;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DrawPanel extends JPanel implements MouseListener {

    private boolean[][] grid;
    private int[][] brickGrid;
    private int[][] brickGrid2;


    private long start;
    BrickLayout b;
    int index;
    int max;
    public DrawPanel() {
        this.addMouseListener(this);
        grid = new boolean[30][40];
        long start = System.currentTimeMillis();
        b = new BrickLayout("src/Bricks/bricks.txt", 40, true );
        brickGrid = b.brickLayout;
        brickGrid2 = new int[30][40];
        index = 0;

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int j = 0; j < 30; j++){
            for (int i = 0; i < 40; i++){
                g.drawRect(10 + (i * 24), 10 + (j * 28), 20, 20);
                if (brickGrid2[j][i] == 1 || brickGrid2[j][i] == 2){
                    g2.setColor(Color.BLUE);
                    g2.fillRect(10 + (i * 24), 10 + (j * 28), 20, 20);
                    g2.setColor(Color.BLACK);
                }
            }
        }
        if (System.currentTimeMillis() > (start + 159)){
            brickGrid2[0] = b.brickLayout2[29];
            for (int j = 29; j >= 0; j--) { // start from second-to-last row
                for (int col = 0; col < brickGrid2[j].length; col++) {
                    if (brickGrid2[j][col] == 1){
                        int currentIteration = index - j;
                        if (((( b.brickHeight.get(currentIteration - 1) - 1) == j))){
                            System.out.println(currentIteration + " brick hit its spot" + col);
                            brickGrid2[j][col] = 2;
                            continue;
                        }
                        else {

                            brickGrid2[j + 1][col] = brickGrid2[j][col];
                            brickGrid2[j][col] = 0;
                        }
                    }


                }
            }
            start = System.currentTimeMillis();
            index += 1;
            b.oneBrick();
        }

}

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}