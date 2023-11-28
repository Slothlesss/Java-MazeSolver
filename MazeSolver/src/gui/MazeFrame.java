package gui;

import javax.swing.*;
import util.Constants.GUI;

/**
 * MazeFrame class provides the frame for GUI.
 */
public class MazeFrame extends JFrame{

    /** Constructor of MazeFrame class.
     * It creates an instance of JFrame, then set the frame size, position,
     * and other relevant functions.
     * @param mazePanel a maze panel that needs to be added to maze frame.
     */
    public MazeFrame(MazePanel mazePanel) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(GUI.PANEL_WIDTH, GUI.PANEL_HEIGHT);
        jFrame.add(mazePanel);
        jFrame.setLocationRelativeTo(null); //It appears in the middle of the screens
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
