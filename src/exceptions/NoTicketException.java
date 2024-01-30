package exceptions;

public class NoTicketException extends RuntimeException{
    public NoTicketException()
    {
        super("Entry Ticket was not generated, Please try again later");
    }
}
