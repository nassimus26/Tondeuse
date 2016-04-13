
import org.junit.Assert;
import org.junit.Test;
import org.mn.TondeuseExecutor;
import org.mn.TondeuseTask;
import org.mn.exception.InvalidInstructionsException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nassimus on 11/04/2016.
 */
public class TondeuseFileTest {

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