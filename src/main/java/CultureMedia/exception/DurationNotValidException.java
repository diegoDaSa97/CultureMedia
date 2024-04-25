package CultureMedia.exception;

import java.text.MessageFormat;

public class DurationNotValidException extends CultureMediaException {


    public DurationNotValidException(String Title, Double Duration){
        super (MessageFormat.format("No Videos found with title{0} and Duration {1}", Title, Duration));
    }
}
