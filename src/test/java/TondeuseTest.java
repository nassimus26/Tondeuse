
import org.junit.Assert;
import org.junit.Test;
import org.mn.TondeuseExecutor;
import org.mn.TondeuseTask;
import org.mn.exception.InvalidInstructionsException;
import org.mn.Tondeuse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nassimus on 11/04/2016.
 */
public class TondeuseTest {

    @Test
    public void testEastGoLeft(){
        try {
            TondeuseTask task = new TondeuseTask(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 E", "G"})));
            Assert.assertArrayEquals(new String[]{"1 1 N"}, task.getResult().toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testNorthGoLeft(){
        try {
            TondeuseTask task = new TondeuseTask(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 N", "G"})));
            Assert.assertArrayEquals(new String[]{"1 1 W"}, task.getResult().toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testWestGoLeft(){
        try {
            TondeuseTask task = new TondeuseTask(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 W", "G"})));
            Assert.assertArrayEquals(new String[]{"1 1 S"}, task.getResult().toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }

    @Test
    public void testSudGoLeft(){
        try {
            TondeuseTask task = new TondeuseTask(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 S", "G"})));
            Assert.assertArrayEquals(new String[]{"1 1 E"}, task.getResult().toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testEastGoRight(){
        try {
            TondeuseTask task = new TondeuseTask(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 E", "D"})));
            Assert.assertArrayEquals(new String[]{"1 1 S"}, task.getResult().toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testSudGoRight(){
        try {
            TondeuseTask task = new TondeuseTask(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 S", "D"})));
            Assert.assertArrayEquals(new String[]{"1 1 W"}, task.getResult().toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testWestGoRight(){
        try {
            TondeuseTask task = new TondeuseTask(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 W", "D"})));
            Assert.assertArrayEquals(new String[]{"1 1 N"}, task.getResult().toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testNorthGoRight(){
        try {
            TondeuseTask task = new TondeuseTask(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 N", "D"})));
            Assert.assertArrayEquals(new String[]{"1 1 E"}, task.getResult().toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testMoveEast(){
        try {
            TondeuseTask task = new TondeuseTask(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 E", "A"})));
            Assert.assertArrayEquals(new String[]{"2 1 E"}, task.getResult().toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testMoveNorth(){
        try {
            TondeuseTask task = new TondeuseTask(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 N", "A"})));
            Assert.assertArrayEquals(new String[]{"1 2 N"}, task.getResult().toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testMoveWest(){
        try {
            TondeuseTask task = new TondeuseTask(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 W", "A"})));
            Assert.assertArrayEquals(new String[]{"0 1 W"}, task.getResult().toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testMoveSud(){
        try {
            TondeuseTask task = new TondeuseTask(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 S", "A"})));
            Assert.assertArrayEquals(new String[]{"1 0 S"}, task.getResult().toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }

}