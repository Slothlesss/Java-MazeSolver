package core;

import java.util.Objects;

/**
 * The Position class represents a coordinate in a grid.
 */
public class Position {
    private int xCoordinate;
    private int yCoordinate;

    /**
     * Constructs a Position object with default coordinates (0, 0).
     */
    public Position() {
        this.xCoordinate = 0;
        this.yCoordinate = 0;
    }

    /**
     * Constructs a Position object with the specified coordinates.
     * @param y The Y-coordinate.
     * @param x The X-coordinate.
     */
    public Position(int y, int x) {
        this.yCoordinate = y;
        this.xCoordinate = x;
    }

    /**
     * Gets the X-coordinate of the position.
     * @return The X-coordinate.
     */
    public int getX() {
        return xCoordinate;
    }

    /**
     * Gets the Y-coordinate of the position.
     * @return The Y-coordinate.
     */
    public int getY() {
        return yCoordinate;
    }
    /**
     * Override the equal check function when this Position object is equal to another object.
     * Two Position objects are considered equal if they have the same X and Y coordinates.
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position other = (Position) obj;
        return xCoordinate == other.xCoordinate && yCoordinate == other.yCoordinate;
    }

    /**
     * Computes a hash code for this Position object.
     * The hash code is based on the X and Y coordinates.
     * @return The computed hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(yCoordinate, xCoordinate);
    }

}
