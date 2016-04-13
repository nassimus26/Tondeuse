package org.mn;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.mn.exception.InvalidInstructionsException;

/**
 * Created by nassimus on 11/04/2016.
 */
public class TondeuseExecutor {
    private final static Logger logger = Logger.getLogger(TondeuseExecutor.class);

    /**
     * Read file to String
     * @param  filePath the file path to the instructions file
     * @return      the content of the file
     * */
    public static List<String> read(String filePath) throws IOException {
        try {
            URL url = Tondeuse.class.getResource(filePath);
            if (url==null)
                throw new IOException();
            return Files.readAllLines(Paths.get( url.toURI() ));
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }
    }
    /**
     * Read file to String
     * @param  filePath the file path to the instructions file
     * @return      the position of every Tondeuse at the end
     * */
    public static List<String> readAndExecute(String filePath)throws IOException, InvalidInstructionsException {
        List<String> rows = read(filePath);
        List<String> result = TondeuseTask.execute(rows);
        return result;
    }
    /**
     * Read file to String
     * @param  filePath the file path to the instructions file
     * @return      the position of every Tondeuse at the end
     * */
    public static void readExecuteAndPrint(String filePath)throws IOException, InvalidInstructionsException {
        List<String> result = readAndExecute(filePath);
        for (String r : result)
            System.out.println(r);
    }
}