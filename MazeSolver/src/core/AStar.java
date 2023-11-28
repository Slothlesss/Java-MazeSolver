package core;

import exceptions.MazeMalformedException;

import java.util.*;

/**
 * The AStar class provides the A* algorithm for finding maze path.
 */
public class AStar {

    /**
     * The function helps to find the path by using A* algorithm
     * @return the valid path, if not, return null.
     * @throws MazeMalformedException when cannot find the valid path.
     */
    public static Stack<Position> getPath() throws MazeMalformedException {
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(node -> node.F));
        HashSet<Node> closeList = new HashSet<>();
        Stack<Position> finalPath = new Stack<>();

        Dictionary<Position, Node> nodes = MazeHelper.mapToNodes();
        //current node will be start point
        Position startPoint = MazeHelper.getStartPoint();
        Position endPoint = MazeHelper.getEndPoint();
        Node currentNode = nodes.get(startPoint); // 1 1

        openList.add(currentNode);

        //Calculate F scores for surrounding nodes
        while (!openList.isEmpty()) {
            for (int y = -1; y <= 1; y++) {
                for (int x = -1; x <= 1; x++) {
                    Position neighborPos = new Position(currentNode.getPos().getY() - y,
                            currentNode.getPos().getX() - x);
                    if (MazeHelper.isInBound(neighborPos)) {
                        if (nodes.get(neighborPos).isWalkable && currentNode.getPos() != neighborPos) {
                            int gCost;
                            if (Math.abs(x - y) == 1) {
                                gCost = 10;
                            } else { //Diagonally
                                continue;
                            }

                            Node neighbourNode = nodes.get(neighborPos);
                            if (openList.contains(neighbourNode)) {
                                if (currentNode.G + gCost < neighbourNode.G) {
                                    neighbourNode.calculateValues(currentNode,
                                            nodes.get(endPoint), gCost);
                                }
                            } else if (!closeList.contains(neighbourNode)) {
                                openList.add(neighbourNode);
                                neighbourNode.calculateValues(currentNode,
                                        nodes.get(endPoint), gCost);
                            }
                        }
                    }
                }
            }

            openList.remove(currentNode);
            closeList.add(currentNode);

            if (!openList.isEmpty()) {
                currentNode = openList.peek();
            }
            if (currentNode == nodes.get(endPoint)) {
                while (currentNode.getPos() != startPoint) {
                    currentNode = currentNode.getParent();
                    finalPath.push(currentNode.getPos());
                }
                return finalPath;
            }
        }
        throw new MazeMalformedException("Cannot find the path");
    }
}
