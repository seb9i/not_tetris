import Bricks.BrickLayout;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
    }
//    public void randomizeGrid(){
//        for (int i = 0; i < grid.length; i++){
//            for (int j = 0; j < grid[i].length; j++){
//                grid[i][j] = false;
//            }
//        }
//        for (int i = 0; i < grid.length; i++){
//            for (int j = 0; j < grid[i].length; j++){
//                int chance = (int)(Math.random() * 9) + 1;
//                if (chance < 3){
//                    grid[i][j] = true;
//                }
//            }
//        }
//    }

    public void nextStep(){
        b.doOneBrick();
        index -= 1;
        System.out.println(Arrays.toString(brickGrid2));
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int j = 0; j < 30; j++){
            for (int i = 0; i < 40; i++){
                g.drawRect(10 + (i * 24), 10 + (j * 28), 20, 20);
                if (brickGrid[j][i] == 1){
                    g2.setColor(Color.RED);
                    g2.fillRect(10 + (i * 24), 10 + (j * 28), 20, 20);
                    g2.setColor(Color.BLACK);
                }
            }
        }
//        if (System.currentTimeMillis() > (start + 3000)){
//            randomizeGrid();
//            start = System.currentTimeMillis();
//        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        nextStep();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("HELLO!");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("GOODBYE!");
    }
}