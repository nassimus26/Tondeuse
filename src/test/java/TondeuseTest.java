
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
    public void testTondeuse(){
        try {
            List<String> result = TondeuseExecutor.readAndExecute("/files/instructions.txt");
            for (String r : result)
                System.out.println(r);
            Assert.assertArrayEquals(new String[]{"1 3 N", "5 1 E"}, result.toArray());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("File not founds");
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testEastGoLeft(){
        try {
            List<String> result = TondeuseTask.execute(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 E", "G"})));
            Assert.assertArrayEquals(new String[]{"1 1 N"}, result.toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testNorthGoLeft(){
        try {
            List<String> result = TondeuseTask.execute(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 N", "G"})));
            Assert.assertArrayEquals(new String[]{"1 1 W"}, result.toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testWestGoLeft(){
        try {
            List<String> result = TondeuseTask.execute(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 W", "G"})));
            Assert.assertArrayEquals(new String[]{"1 1 S"}, result.toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testSudGoLeft(){
        try {
            List<String> result = TondeuseTask.execute(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 S", "G"})));
            Assert.assertArrayEquals(new String[]{"1 1 E"}, result.toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testEastGoRight(){
        try {
            List<String> result = TondeuseTask.execute(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 E", "D"})));
            Assert.assertArrayEquals(new String[]{"1 1 S"}, result.toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testSudGoRight(){
        try {
            List<String> result = TondeuseTask.execute(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 S", "D"})));
            Assert.assertArrayEquals(new String[]{"1 1 W"}, result.toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testWestGoRight(){
        try {
            List<String> result = TondeuseTask.execute(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 W", "D"})));
            Assert.assertArrayEquals(new String[]{"1 1 N"}, result.toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testNorthGoRight(){
        try {
            List<String> result = TondeuseTask.execute(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 N", "D"})));
            Assert.assertArrayEquals(new String[]{"1 1 E"}, result.toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testMoveEast(){
        try {
            List<String> result = TondeuseTask.execute(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 E", "A"})));
            Assert.assertArrayEquals(new String[]{"2 1 E"}, result.toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testMoveNorth(){
        try {
            List<String> result = TondeuseTask.execute(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 N", "A"})));
            Assert.assertArrayEquals(new String[]{"1 2 N"}, result.toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testMoveWest(){
        try {
            List<String> result = TondeuseTask.execute(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 W", "A"})));
            Assert.assertArrayEquals(new String[]{"0 1 W"}, result.toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testMoveSud(){
        try {
            List<String> result = TondeuseTask.execute(new ArrayList<>(Arrays.asList(new String[]{"5 5", "1 1 S", "A"})));
            Assert.assertArrayEquals(new String[]{"1 0 S"}, result.toArray());
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
    @Test
    public void testEmptyTondeuse(){
        try {
            List<String> result = TondeuseExecutor.readAndExecute("/files/empty_instructions.txt");
            Assert.assertArrayEquals(new String[]{}, result.toArray());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("File not founds");
        } catch (InvalidInstructionsException e) {
            e.printStackTrace();
            Assert.fail("Invalid file instructions");
        }
    }
}