package CultureMedia.exception;

import java.text.MessageFormat;

public class DurationNotValidException extends CultureMediaException {

    public DurationNotValidException(){
        super ("");
    }

    public DurationNotValidException(String Title, Double Duration){
        super (MessageFormat.format("Invalid duration{0}", Duration));
    }
}
