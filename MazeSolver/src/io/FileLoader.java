package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import exceptions.*;

/**
 * The FileLoader class provides functions for laoding the txt file into the maze map
 */
public class FileLoader implements FileInterface {
    private static int maxWidth;
    private static int maxHeight;
    private static char[][] map;
    public FileLoader(String filename) throws FileNotFoundException,
            MazeSizeMissmatchException, MazeMalformedException {
        map = load(filename);
    }

    /**
     * Check the string has whether valid number
     * @param s the string need to be tested
     * @return whether the s is a valid number or not
     */
    public boolean isValidNumber(String s) {
        int start = 0;
        if (s.charAt(start) == '-') {
            start++;
        }
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }

    /**
     * This function read the txt file and then convert it into 2-dimension char array
     * @param filename The path to the maze file to be loaded.
     * @return the map in 2-dimension char array
     * @throws MazeMalformedException      If the maze data is not correctly formatted.
     * @throws MazeSizeMissmatchException  If the maze dimensions do not match the provided size.
     * @throws IllegalArgumentException     For other validation errors.
     * @throws FileNotFoundException        If the maze file is not found.
     */
    @Override
    public char[][] load(String filename) throws MazeMalformedException, MazeSizeMissmatchException, IllegalArgumentException, FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String firstLine;
            //Read the first line
            firstLine = br.readLine();
            String[] dimensions = firstLine.split(" ");
            if (dimensions.length != 2) {
                throw new MazeMalformedException("Maze data is not correctly");
            }

            if (!isValidNumber(dimensions[0]) || !isValidNumber(dimensions[1])) {
                throw new MazeMalformedException("Maze data must be a number");
            }


            maxHeight = Integer.parseInt(dimensions[0]);
            maxWidth = Integer.parseInt(dimensions[1]);

            if (maxWidth % 2 == 0 || maxHeight % 2 == 0) {
                throw new MazeSizeMissmatchException("Maze dimensions must be odd");
            }

            if (maxWidth <= 0 || maxHeight <= 0) {
                throw new MazeSizeMissmatchException("Maze dimensions must be positive");
            }

            String line;
            map = new char[maxHeight][maxWidth];
            int row = 0;
            int startCount = 0;
            int endCount = 0;
            while ((line = br.readLine()) != null) {
                for(int i = 0; i < line.length(); i++) {
                    char cell = line.charAt(i);
                    map[row][i] = cell;
                    if (cell == 'S') {
                        if (row == 0 || i == 0 || row == maxHeight - 1 || i == maxWidth - 1) {
                            throw new MazeMalformedException("Start point needs to be inside border");
                        }
                        startCount++;
                    } else if (cell == 'E') {
                        if (row == 0 || i == 0 || row == maxHeight - 1 || i == maxWidth - 1) {
                            throw new MazeMalformedException("End point needs to be inside border");
                        }
                        endCount++;
                    } else if (cell != '#' && cell != ' ' && cell != '.') {
                        throw new MazeMalformedException("Inappropriate Character");
                    }
                }
                row++;
            }

            if (startCount != 1 && endCount != 1) {
                throw new MazeMalformedException("Have more than one start or end position");
            }

            return map;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Cannot find the specific file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getMaxHeight() {
        return maxHeight;
    }

    public static int getMaxWidth() {
        return maxWidth;
    }

    public static char[][] getMap() {
        return map;
    }
}
