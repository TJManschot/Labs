package nl.belastingdienst.opgave3;

public class InvalidLocationException extends RuntimeException {
   public InvalidLocationException() {
       super("This city does not exist.");
   }
}
