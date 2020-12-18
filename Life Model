import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LifeModel {

    private Cell[][] world;
    
    public LifeModel() {
        world = new Cell[10][10];
        // don't forget to replace all those nulls with actual Cell refs!
        // TO DO
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                world[i][j] = new Cell();
            }
        }
    }

    public LifeModel(int numRows, int numCols) {
        //TO DO
        world = new Cell[numRows + 2][numCols + 2];
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                world[i][j] = new Cell();
            }
        }
    }

    public LifeModel(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File("data/" + fileName));
        int rows = input.nextInt();
        int cols = input.nextInt();
        world = new Cell[rows + 2][cols + 2];
        for (int r = 0; r < world.length; r++) {
            for (int c = 0; c < world[r].length; c++) {
                world[r][c] = new Cell();
            }
        }
        while (input.hasNextInt()) {
            int x = input.nextInt();
            int y = input.nextInt();
            world[x + 1][y + 1] = new Cell(true);
        }
    }

    public String toString() {
        String s = "";
        // TO DO
        for (int row = 1; row < world.length - 1; row++) {
            for (int col = 1; col < world[row].length - 1; col++)
                s += world[row][col] + " ";
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) throws FileNotFoundException {
        LifeModel model = new LifeModel("glider.dat");
        LifeModel model2 = new LifeModel();
        System.out.println(model);
        model.nextGen1();
        System.out.println(model);
        model.nextGen1();
        System.out.println(model);
        LiveConsoleView view = new LiveConsoleView(model2);
        view.run();
    }

    public int getRows() {
        return world.length;
    }

    public int getColumns() {
        return world[0].length;
    }

    public Cell[][] getWorld() {
        return world;
    }

    public Cell[][] worldState() {
        Cell[][] temp = new Cell[world.length][world[0].length];
        for (int row = 0; row < temp.length; row++) {
            for (int col = 0; col < temp[row].length; col++) {
                temp[row][col] = new Cell(world[row][col].isAlive());
            }
        }
        return temp;
    }

    public void nextGen1() {
        int r = world.length - 1;
        int c = world[0].length - 1;
        Cell[][] cell = this.worldState();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (nextGen2(world[i][j], neighborCount(i, j)))
                    cell[i][j].setAlive(true);
                else
                    cell[i][j].setAlive(false);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                world[i][j] = cell[i][j];
            }
        }
    }

    public boolean nextGen2(Cell c, int ln) {
        if (c.isAlive()) {
            if (ln <= 1 || ln >= 4)
                return false;
            if (ln == 2 || ln == 3) {
                return true;
            }
        }
        if (!c.isAlive() && ln == 3) {
            return true;
        }
        return false;
    }

    public int neighborCount(int r, int c) {
        int x = 0;
        if (r != 0 && c != 0) {
            if (world[r + 1][c].isAlive())
                x++;
            if (world[r + 1][c - 1].isAlive())
                x++;
            if (world[r + 1][c + 1].isAlive())
                x++;
            if (r != 0) {
                if (world[r - 1][c].isAlive())
                    x++;
                if (world[r - 1][c - 1].isAlive())
                    x++;
                if (world[r - 1][c + 1].isAlive())
                    x++;
            }
            if (c != 0) {
                if (world[r][c - 1].isAlive())
                    x++;
                if (world[r][c + 1].isAlive())
                    x++;
            }
        }
        return x;
    }

    public void bringToLife(int row, int col) {
        world[row][col].setAlive(true);
    }

    public void kill(int row, int col) {
        world[row][col].setAlive(false);
    }

    public void reset() {
        for (int row = 1; row < world.length - 1; row++) {
            for (int col = 1; col < world[row].length - 1; col++) {
                world[row][col].setAlive(false);
            }
        }
    }
}
