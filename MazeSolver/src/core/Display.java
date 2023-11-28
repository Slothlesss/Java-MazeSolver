package core;

import exceptions.MazeMalformedException;
import gui.MazeGUI;
import io.FileLoader;
import util.Constants.Text;

import java.util.Stack;

/**
 * The Display class provides methods to display the result of the maze solving algorithm.
 * It can display the result in either a GUI or text.
 */
public class Display {
    /**
     * Display the result of the maze solving algorithm.
     * @param isGUI indicates whether the result should be displayed in a GUI or text.
     * @throws MazeMalformedException when cannot find the valid path.
     */
    public static void DisplayResult(boolean isGUI) throws MazeMalformedException {

        Stack<Position> finalPath = AStar.getPath();
        char[][] map = FileLoader.getMap();

        if (!isGUI) {
            for(int i = 0; i < FileLoader.getMaxHeight(); i++) {
                for(int j = 0; j < FileLoader.getMaxWidth(); j++) {
                    boolean isIncludePath = false;
                    Position pos = new Position(i, j);
                    if (!pos.equals(MazeHelper.getStartPoint()) && finalPath.contains(pos)) {
                        System.out.print(Text.BLUE + Text.SOLID_BLOCK + Text.RESET);
                        isIncludePath = true;
                    }
                    if (!isIncludePath) {
                        if (map[i][j] == '#') {
                            System.out.print(Text.GRAY + Text.SOLID_BLOCK + Text.RESET);
                        } else if (map[i][j] == 'S') {
                            System.out.print(Text.GREEN + Text.SOLID_BLOCK + Text.RESET);
                        } else if (map[i][j] == 'E') {
                            System.out.print(Text.RED + Text.SOLID_BLOCK + Text.RESET);
                        } else {
                            System.out.print(Text.BLACK + Text.SOLID_BLOCK + Text.RESET);
                        }
                    }
                }
                System.out.println();
            }
        } else {
            new MazeGUI();
        }
    }
}
