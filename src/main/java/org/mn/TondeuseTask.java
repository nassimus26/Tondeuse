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
public class TondeuseTask {
    private final static Logger logger = Logger.getLogger(TondeuseTask.class);
    /**
     * Execute the instructions
     * @param  rows the rows of a instructions to be executed
     * @return      the position of every Tondeuse at the end
     * */
    public static List<String> execute(List<String> rows)throws InvalidInstructionsException {
        if (rows.size()==0)
            throw new InvalidInstructionsException();
        String positions = rows.get(0);
        try{
            List<String> result = new ArrayList<>();
            String[] pos = positions.split(" ");
            int gridSizeX = Integer.valueOf(pos[0])+1;
            int gridSizeY = Integer.valueOf(pos[1])+1;
            for (int i=1;i<rows.size();i+=2) {
                Tondeuse tondeuse = new Tondeuse(gridSizeX, gridSizeY, rows.get(i));
                char [] intructions = rows.get(i+1).toCharArray();
                for (char c :intructions ) {
                    tondeuse.move(c);
                }
                result.add(tondeuse.getPosition());
            }
            return result;
        }catch(RuntimeException e){
            throw new InvalidInstructionsException(e);
        }
    }

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
        List<String> result = execute(rows);
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