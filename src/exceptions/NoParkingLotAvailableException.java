package exceptions;

public class NoParkingLotAvailableException extends RuntimeException{
    public NoParkingLotAvailableException() {
        super("No Parking Lot has been created");
    }
}
