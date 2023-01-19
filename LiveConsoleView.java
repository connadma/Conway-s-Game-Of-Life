import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LiveConsoleView {
    private LifeModel model;
    private Scanner tReader;
    private Scanner nReader;

    public LiveConsoleView(LifeModel model) {
        this.model = model;
        nReader = new Scanner(System.in);
        tReader = new Scanner(System.in);
    }

    private void displayMenu() {
        System.out.println("1. new game");
        System.out.println("2. next generation");
        System.out.println("3. next 100 generations");
        System.out.println("4. quit");
    }

    public void run() throws FileNotFoundException {
        boolean game = true;
        while (game) {
            displayMenu();
            System.out.println("Choose: ");
            int c = nReader.nextInt();
            if (c == 1) {
                newGame();
            }
            if (c == 2) {
                nextGen1();
            }
            if (c == 3) {
                for (int i = 0; i < 100; i++) {
                    nextGen2();
                }
            }
            if (c == 4) {
                game = false;
            }
        }
    }

    private void newGame() throws FileNotFoundException {
        System.out.println("Enter file name for world generation: ");
        String fileName = tReader.nextLine();
        Scanner fileReader = new Scanner(new File("data/" + fileName));
        int r = fileReader.nextInt();
        int c = fileReader.nextInt();
        this.model = new LifeModel(r, c);
        while (fileReader.hasNextInt()) {
            int r2 = fileReader.nextInt();
            int c2 = fileReader.nextInt();
            model.bringToLife(r2, c2);
        }
    }

    private void nextGen1() {
        while (true) {
            System.out.println(model);
            System.out.print("Press enter for the next generation. Press 'm' to stop.");
            String r = tReader.nextLine();
            if (r.equalsIgnoreCase("m")) {
                break;
            }
            model.nextGen1();
        }
    }

    private void nextGen2() {
        while (true) {
            System.out.println(model);
            System.out.print("Press enter to travel 100 generations into the future. Press 'm' to stop.");
            String r = tReader.nextLine();
            if (r.equalsIgnoreCase("m")) {
                break;
            }
            for (int i = 0; i < 100; i++) {
                model.nextGen1();
            }
        }
    }
}
