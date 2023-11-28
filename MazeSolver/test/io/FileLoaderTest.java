package io;
import exceptions.MazeMalformedException;
import exceptions.MazeSizeMissmatchException;
import org.junit.*;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;
public class FileLoaderTest {

    @Test
    public void testUnfoundFilename() {
        boolean exceptionThrown = false;
        try {
            FileLoader fileLoader = new FileLoader("abc.txt");
        } catch (FileNotFoundException e) {
            exceptionThrown = true;
        } catch (MazeSizeMissmatchException | MazeMalformedException e) {
            throw new RuntimeException(e);
        }

        assertTrue(exceptionThrown);
    }

    @Test
    public void testWrongDimension() {
        boolean exceptionThrown = false;
        try {
            FileLoader fileLoader = new FileLoader("test/txtfile/test1.txt");
        } catch (FileNotFoundException | MazeMalformedException e) {
            throw new RuntimeException(e);
        } catch (MazeSizeMissmatchException e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }

    @Test
    public void testWrongEndPoint() {
        boolean exceptionThrown = false;
        try {
            FileLoader fileLoader = new FileLoader("test/txtfile/test2.txt");
        } catch (FileNotFoundException | MazeSizeMissmatchException e) {
            throw new RuntimeException(e);
        } catch (MazeMalformedException e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }

    @Test
    public void testNegativeDimension() {
        boolean exceptionThrown = false;
        try {
            FileLoader fileLoader = new FileLoader("test/txtfile/test4.txt");
        } catch (FileNotFoundException | MazeMalformedException e) {
            throw new RuntimeException(e);
        } catch (MazeSizeMissmatchException e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }
}
