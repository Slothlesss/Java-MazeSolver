package core;

import exceptions.*;
import io.FileLoader;

import java.io.FileNotFoundException;

/**
 * The Launcher class provides the main function to execute the program
 */
public class Launcher {
    /**
     * Read the command line arguments, then load the file and display it on GUI or text.
     * @param args the command line arguments
     * @throws MazeMalformedException      If the maze data is not correctly formatted.
     * @throws MazeSizeMissmatchException  If the maze dimensions do not match the provided size.
     * @throws IllegalArgumentException     For other validation errors.
     * @throws FileNotFoundException        If the maze file is not found.
     */
    public static void main(String[] args) throws FileNotFoundException, MazeSizeMissmatchException, MazeMalformedException, IllegalArgumentException {
        boolean isGUI = false;
        if (args.length == 1) {
            new FileLoader(args[0]);
        } else if (args.length == 2) {
            if (args[0].equals("GUI")) {
                System.out.println(args.length);
                isGUI = true;
                new FileLoader(args[1]);
            }
        } else {
            throw new IllegalArgumentException("Too many arguments");
        }
        Display.DisplayResult(isGUI);
    }
}