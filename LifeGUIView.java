import java.awt.*;

public class LifeGUIView {
    private DrawingPanel panel;
    private LifeModel model;
    public final String[] dash = {"Next Gen", "Reset"};
    public final Color[] colors = {Color.RED, Color.GREEN};
    private final int SQUARE_SIZE = 50;

    public LifeGUIView(LifeModel model1) {
        model = model1;
        panel = new DrawingPanel(model1.getRows() * SQUARE_SIZE, model1.getColumns() * SQUARE_SIZE);
        Graphics graphics = panel.getGraphics();
        for (int i = 0; i < dash.length; i++) {
            graphics.setColor(colors[i]);
            graphics.fillRect(i * SQUARE_SIZE, 0, SQUARE_SIZE, SQUARE_SIZE);
        }
        panel.onClick((x, y) -> processClick(x, y));
    }

    private void processClick(int xPos, int yPos) {
        int row = yPos / SQUARE_SIZE;
        int col = xPos / SQUARE_SIZE;
        System.out.println("You set a cell to alive at " + row + ", " + col);
        Graphics g = panel.getGraphics();
        if (row == 0 && col < dash.length) {
            if (col == 0) {
                System.out.println("Next Gen");
                model.nextGen1();
                for (int r2 = 1; r2 < model.getRows(); r2++) {
                    for (int c2 = 0; c2 < model.getColumns(); c2++) {
                        if (model.getWorld()[r2][c2].isAlive()) {
                            g.setColor(Color.ORANGE);
                            g.fillRect(c2 * SQUARE_SIZE, r2 * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                        } else {
                            g.setColor(Color.WHITE);
                            g.fillRect(c2 * SQUARE_SIZE, r2 * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                        }

                    }
                }
            }
            if (col == 1) {
                System.out.println("Reset");
                resetView();
                model.reset();

            }
        } else {
            if (!model.getWorld()[row][col].isAlive()) {
                g.setColor(Color.ORANGE);
                g.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                model.bringToLife(row, col);
            } else {
                g.setColor(Color.WHITE);
                g.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                model.bringToLife(row, col);
            }
        }
    }

    public void run() {
        System.out.println("Click on squares to bring them to life.");
        System.out.println("The red button runs next generation.");
        System.out.println("The green button resets the field to all dead cells.");
    }

    public void resetView() {
        Graphics graphics = panel.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, SQUARE_SIZE, model.getRows() * SQUARE_SIZE, model.getColumns() * SQUARE_SIZE);
        graphics.fillRect(SQUARE_SIZE * colors.length, 0, model.getRows() * SQUARE_SIZE, model.getColumns() * SQUARE_SIZE);
    }
}
