package exceptions;

public class NoSpotAvailableException extends RuntimeException{
    public NoSpotAvailableException()
    {
        super("No Parking Spots available Currently!!");
    }
}
