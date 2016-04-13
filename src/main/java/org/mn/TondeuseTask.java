package org.mn;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.mn.exception.InvalidInstructionsException;

/**
 * Created by nassimus on 11/04/2016.
 */
public class TondeuseTask {
    private List<String> result = new ArrayList<>();
    private final static Logger logger = Logger.getLogger(TondeuseTask.class);
    public TondeuseTask(){

    }
    public TondeuseTask(List<String> rows)throws InvalidInstructionsException {
        execute(rows);
    }
    /**
     * Execute the instructions
     * @param  rows the rows of a instructions to be executed
     * @return      the position of every Tondeuse at the end
     * */
    public List<String> execute(List<String> rows)throws InvalidInstructionsException {
        result.clear();
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
                for (char c :intructions)
                    tondeuse.move(c);
                result.add(tondeuse.getPosition());
            }
            this.result = result;
            return result;
        }catch(RuntimeException e){
            throw new InvalidInstructionsException(e);
        }
    }

    public List<String> getResult() {
        return result;
    }
}