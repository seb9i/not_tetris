package Bricks;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BrickLayout {

    private ArrayList<Brick> bricks;
    public int[][] brickLayout;
    boolean first;
    public BrickLayout(String fileName, int cols, boolean dropAllBricks) {
        ArrayList<String> fileData = getFileData(fileName);
        bricks = new ArrayList<Brick>();
        for (String line : fileData) {
            String[] points = line.split(",");
            int start = Integer.parseInt(points[0]);
            int end = Integer.parseInt(points[1]);
            Brick b = new Brick(start, end);
            bricks.add(b);
        }
        brickLayout = new int[30][cols];


    }
    public int nextAvailableHeight(int column){
        for (int i = 0; i < brickLayout.length; i++){
            for (int j = 0; j < brickLayout[i].length; j++){
                if (j == column && brickLayout[i][j] == 1){
                    return i;
                }
            }
        }
        return brickLayout.length;
    }
    public int findthi(Brick b){
        ArrayList<Integer> fs = new ArrayList<Integer>();
        int x = 100000;
        for (int i = b.getStart(); i < b.getEnd() + 1; i++){
            fs.add(nextAvailableHeight(i));
        }
        first = false;
        for (int c: fs){
            if (c < x){
                x = c;
            }
        }
        return x;
    }
    public void doOneBrick() {
        if (bricks.size() != 0) {
            Brick b = bricks.remove(0);
            b.setHeight(findthi(b));
            for (int i = b.getStart(); i < b.getEnd() + 1; i++){
                brickLayout[b.getHeight() - 1][i] = 1;
            }

        }
    }

    public ArrayList<String> getFileData(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        return fileData;
    }

    public void printBrickLayout() {
        for (int r = 0; r < brickLayout.length; r++) {
            for (int c = 0; c < brickLayout[0].length; c++) {
                System.out.print(brickLayout[r][c] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkBrickSpot(int r, int c) {
        if (brickLayout[r][c] == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}