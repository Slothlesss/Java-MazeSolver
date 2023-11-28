package util;

/**
 * The Constants class provides constants to avoid magic numbers.
 */
public class Constants {
    /**
     * The Text class represents constants for text-based display.
     */
    public static class Text {
        public static final String RESET = "\u001B[0m";
        public static final String BLUE = "\u001B[34m";
        public static final String GRAY = "\u001B[90m";
        public static final String GREEN = "\u001B[32m";
        public static final String RED = "\u001B[31m";
        public static final String BLACK = "\u001B[30m";
        public static final String SOLID_BLOCK = "\u2588";
    }

    /**
     * The GUI class represents constants for GUI display.
     */
    public static class GUI {
        public static final int PANEL_WIDTH = 1280;     // Width of the panel
        public static final int PANEL_HEIGHT = 800;     // Height of the panel
        public static final int LABEL_X = 45;           // X-coordinate of the label
        public static final int LABEL_Y = 370;          // Y-coordinate of the label
        public static final int LABEL_WIDTH = 200;      // Width of the label
        public static final int LABEL_HEIGHT = 30;      // Height of the label
        public static final int DROPDOWN_X = 20;        // X-coordinate of the dropdown menu
        public static final int DROPDOWN_Y = 400;       // Y-coordinate of the dropdown menu
        public static final int DROPDOWN_WIDTH = 150;   // Width of the dropdown menu
        public static final int DROPDOWN_HEIGHT = 30;   // Height of the dropdown menu
        public static final int BUTTON_X = 40;          // X-coordinate of the "Load" button
        public static final int BUTTON_Y = 440;         // Y-coordinate of the "Load" button
        public static final int BUTTON_WIDTH = 100;     // Width of the "Load" button
        public static final int BUTTON_HEIGHT = 30;     // Height of the "Load" button
        public static final int MARGIN_X = 190;         // Left margin for maze rendering
        public static final int MARGIN_Y = 40;          // Top margin for maze rendering
        public static final int CELL_MARGIN_X = 380;    // Right margin for maze rendering
        public static final int CELL_MARGIN_Y = 80;     // Bottom margin for maze rendering

    }
}
