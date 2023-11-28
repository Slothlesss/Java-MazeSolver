package core;

import io.FileLoader;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * The MazeHelper class provides methods for working with maze data.
 * It includes methods for checking if a position is within the maze boundaries, mapping maze data to nodes,
 * and getting the start and end points of the maze.
 */
public class MazeHelper {
    private static Position startPoint;
    private static Position endPoint;

    /**
     * Checks if a given position is within the boundaries of the loaded maze.
     * @param position The position to check.
     * @return True if the position is within bounds, false otherwise.
     */
    public static boolean isInBound(Position position) {
        int maxX = FileLoader.getMaxWidth();
        int maxY = FileLoader.getMaxHeight();
        return position.getX() >= 0 && position.getY() >= 0 && position.getX() < maxX && position.getY() < maxY;
    }

    /**
     * Maps the maze data to a dictionary of nodes.
     * @return A dictionary containing nodes representing positions in the maze.
     */
    public static Dictionary<Position, Node> mapToNodes() {
        Dictionary<Position, Node> nodes = new Hashtable<>();
        int maxX = FileLoader.getMaxWidth();
        int maxY = FileLoader.getMaxHeight();
        char[][] map = FileLoader.getMap();
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                Position pos = new Position(i, j);
                boolean isWalkable = true;
                if (map[i][j] == '#') {
                    isWalkable = false;
                } else if (map[i][j] == 'S') {
                    startPoint = pos;
                } else if (map[i][j] == 'E') {
                    endPoint = pos;
                }
                Node newNode = new Node(pos, null, isWalkable);
                nodes.put(pos, newNode);
            }
        }
        return nodes;
    }

    /**
     * Gets the starting point of the maze.
     * @return The position of the starting point.
     */
    public static Position getStartPoint() {
        return startPoint;
    }


    /**
     * Gets the ending point of the maze.
     * @return The position of the ending point.
     */
    public static Position getEndPoint() {
        return endPoint;
    }
}


