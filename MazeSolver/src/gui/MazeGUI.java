package gui;

/**
 * The MazeGUI class provides the gui for displaying.
 */
public class MazeGUI {
    /**
     * Constructor of the class
     * It creates instances of mazePanel and mazeFrame
     */
    public MazeGUI() {
        MazePanel mazePanel = new MazePanel();
        new MazeFrame(mazePanel);
    }




}
