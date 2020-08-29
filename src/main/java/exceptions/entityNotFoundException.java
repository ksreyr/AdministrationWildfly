package exceptions;

public class entityNotFoundException extends Exception {
    String mesagge;
    public entityNotFoundException(String mesagge) {
        this.mesagge=mesagge;
    }
}
