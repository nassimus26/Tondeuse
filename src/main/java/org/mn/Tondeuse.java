package org.mn;

import org.mn.exception.InvalidInstructionsException;

/**
 * Created by nassimus on 12/04/2016.
 */
public class Tondeuse {
    private int gridSizeX;
    private int gridSizeY;
    private int x;
    private int y;
    private Direction direction;

    public Tondeuse(int gridSizeX, int gridSizeY,String data) throws InvalidInstructionsException {
        try{
            this.gridSizeX = gridSizeX;
            this.gridSizeY = gridSizeY;
            String[] vals = data.split(" ");
            x = Integer.valueOf(vals[0]);
            y = Integer.valueOf(vals[1]);
            direction = Direction.valueOf(vals[2]);
        }catch (RuntimeException e){
            throw new InvalidInstructionsException(e);
        }
    }

    /**
     * Execute an instruction
     * @param  an instructions to be executed
     * */
    public void move(char next) throws InvalidInstructionsException {
        switch (next){
            case 'G':turnLeft();
                break;
            case 'D':turnRight();
                break;
            case 'A':move();
                break;
            default:
                throw new InvalidInstructionsException();
        }
    }

    private void turnLeft(){
        int ord = direction.ordinal()+1;
        if (ord>Direction.values().length-1)
            ord = 0;
        direction = Direction.values()[ord];
    }

    private void turnRight(){
        int ord = direction.ordinal()-1;
        if (ord<0)
            ord = Direction.values().length-1;
        direction = Direction.values()[ord];
    }

    private void move(){
        switch (direction){
            case N:y++;
                break;
            case S:y--;
                break;
            case W:x--;
                break;
            case E:x++;
                break;
        }
        if (x<0)
            x = 0;
        if (x > gridSizeX-1)
            x = gridSizeX-1;
        if (y<0)
            y = 0;
        if (y > gridSizeY-1)
            y = gridSizeY-1;
    }
    public String getPosition(){
        return x+" "+y+" "+direction;
    }

    @Override
    public String toString() {
        return getPosition();
    }
}