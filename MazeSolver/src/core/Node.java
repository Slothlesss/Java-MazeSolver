package core;

/**
 * The Node class provides information for the node, including position,
 * parent, isWalkable and g,h,f scores.
 */
public class Node {
    private Position pos;
    private Node parent;
    public boolean isWalkable;
    public int G;
    public int H;
    public int F;

    /**
     * The constructor of Node class
     * @param position the position of the node
     * @param parent the parent of the node
     * @param isWalkable to tell whether the node is walkable or not.
     */
    public Node(Position position, Node parent, boolean isWalkable) {
        this.pos = position;
        this.parent = parent;
        this.isWalkable = isWalkable;
    }

    /**
     * Calculate g,h,f cost for the nodes. Also updated the parent for the node
     * @param parent the parent needs to be updated
     * @param goal the end point of the maze
     * @param gCost the g score need to be added
     */
    public void calculateValues(Node parent, Node goal, int gCost) {
        this.parent = parent;
        this.G = parent.G + gCost;
        this.H = Math.abs(this.pos.getX() - goal.pos.getX()) +
                Math.abs(this.pos.getY() - goal.pos.getY()); //Manhattan Distance
        this.F = this.G + this.H;
    }

    /**
     * Get the position of the node.
     * @return the position
     */
    public Position getPos() {
        return pos;
    }

    /**
     * Get the parent of the node.
     * @return the parent node
     */
    public Node getParent() {
        return parent;
    }
}
