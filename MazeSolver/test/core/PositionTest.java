package core;

import core.Position;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class PositionTest {
    @Test
    public void testPositionEquality() {
        Position position1 = new Position(1, 2);
        Position position2 = new Position(1, 2);
        assertEquals(position1, position2);
    }

    @Test
    public void testDefaultConstructor() {
        Position position = new Position();
        assertEquals(position.getY(), 0);
        assertEquals(position.getX(), 0);
    }

    @Test
    public void testConstructor() {
        Position position = new Position(1,2);
        assertEquals(position.getY(), 1);
        assertEquals(position.getX(), 2);
    }
}
