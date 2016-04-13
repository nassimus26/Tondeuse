package org.mn.exception;

/**
 * Created by nassimus on 11/04/2016.
 */
public class InvalidInstructionsException extends Exception {
    public InvalidInstructionsException(){
        super();
    }
    public InvalidInstructionsException(Exception e){
        super(e);
    }
}
