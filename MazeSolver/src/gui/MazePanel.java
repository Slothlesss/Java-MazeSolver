package gui;

import exceptions.MazeMalformedException;
import exceptions.MazeSizeMissmatchException;
import io.FileLoader;
import core.*;
import util.Constants;
import util.Constants.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Dictionary;
import java.util.Stack;
import javax.swing.*;

/**
 * The MazePanel class represents a panel for displaying maze-solving results.
 * It provides a user interface for selecting and loading maze files and visualizing the solution.
 */
public class MazePanel extends JPanel {
    /**
     * Constructs a new MazePanel instance.
     * Initializes the panel's size, layout, and components, including file selection dropdown and load button.
     */
    public MazePanel() {

        setPanelSize();

        setLayout(null); // Allow to change position of components

        String folderPath = "txtfile"; // Specify the folder path here

        File folder = new File(folderPath);
        String[] fileNames = getTxtFileNames(folder);
        final JComboBox<String> cb = new JComboBox<String>(fileNames);

        AddLabel();
        AddDropdownMenu(cb);
        AddButton(cb);
    }

    /**
     * Adds a "Load" button to the panel.
     * @param cb The JComboBox for selecting maze files.
     */
    private void AddButton(JComboBox<String> cb) {
        JButton btn = new JButton("Load");
        btn.setBounds(GUI.BUTTON_X, GUI.BUTTON_Y, GUI.BUTTON_WIDTH, GUI.BUTTON_HEIGHT);
        Font btnFont = new Font("Arial", Font.BOLD, 16);
        btn.setFont(btnFont);
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFile = "txtfile/" + (String) cb.getSelectedItem();
                // Call the RunMaze function with the selected filename
                FileLoader fileLoader;
                try {
                    fileLoader = new FileLoader(selectedFile);
                } catch (FileNotFoundException | MazeSizeMissmatchException | MazeMalformedException ex) {
                    throw new RuntimeException(ex);
                }
                MazePanel.this.repaint();
            }
        });
    }
    /**
     * Adds a dropdown menu for selecting maze files to the panel.
     * @param cb The JComboBox for selecting maze files.
     */
    private void AddDropdownMenu(JComboBox<String> cb) {
        cb.setBounds(GUI.DROPDOWN_X, GUI.DROPDOWN_Y, GUI.DROPDOWN_WIDTH , GUI.DROPDOWN_HEIGHT);
        Font cbFont = new Font("Arial", Font.PLAIN, 16);
        cb.setFont(cbFont);
        add(cb);
    }

    /**
     * Adds a label for indicating maze file selection to the panel.
     */
    private void AddLabel() {
        JLabel lbl = new JLabel("Select file:");
        lbl.setBounds(GUI.LABEL_X, GUI.LABEL_Y, GUI.LABEL_WIDTH, GUI.LABEL_HEIGHT);
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        lbl.setFont(labelFont);
        this.add(lbl);
    }

    /**
     * Get the names of .txt files in the specified folder.
     * @param folder The folder containing .txt files.
     * @return An array of file names.
     */
    private String[] getTxtFileNames(File folder) {
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });

        if (files != null) {
            String[] fileNames = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                fileNames[i] = files[i].getName();
            }
            return fileNames;
        } else {
            return new String[0]; // No .txt files found
        }
    }

    /**
     * Sets the size of the panel.
     */
    private void setPanelSize() {
        Dimension size = new Dimension(GUI.PANEL_WIDTH, GUI.PANEL_HEIGHT);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    /**
     * Overrides the paintComponent method to customize the maze visualization.
     * @param g The Graphics object used for drawing.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Stack<Position> finalPath = null;
        try {
            finalPath = AStar.getPath();
        } catch (MazeMalformedException e) {
            throw new RuntimeException(e);
        }

        char[][] map = FileLoader.getMap();

        int height = FileLoader.getMaxHeight();
        int width = FileLoader.getMaxWidth();

        int cellHeight = (getHeight() - GUI.CELL_MARGIN_Y) / height;
        int cellWidth = (getWidth() - GUI.CELL_MARGIN_X)/ width;

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int posX = GUI.MARGIN_X + (getWidth() - GUI.CELL_MARGIN_X - width * cellWidth) / 2 + j * cellWidth;
                int posY = GUI.MARGIN_Y + (getHeight() - GUI.CELL_MARGIN_Y - height * cellHeight) / 2 + i * cellHeight;

                boolean isIncludePath = false;
                Position pos = new Position(i, j);
                if (finalPath.contains(pos) && !pos.equals(MazeHelper.getEndPoint()) && !pos.equals(MazeHelper.getStartPoint())) {
                    g.setColor(Color.cyan);
                    g.fillRect(posX, posY, cellWidth, cellHeight);
                    isIncludePath = true;
                }
                if (!isIncludePath) {
                    if (map[i][j] == '#') {
                        g.setColor(Color.gray);
                        g.fillRect(posX, posY, cellWidth, cellHeight);
                    } else if (map[i][j] == 'S') {
                        g.setColor(Color.green);
                        g.fillRect(posX, posY, cellWidth, cellHeight);
                    } else if (map[i][j] == 'E') {
                        g.setColor(Color.red);
                        g.fillRect(posX, posY, cellWidth, cellHeight);
                    } else {
                        g.setColor(Color.white);
                        g.fillRect(posX, posY, cellWidth, cellHeight);
                    }
                }
            }
        }


    }
}
