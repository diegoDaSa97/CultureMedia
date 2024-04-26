package cultureMedia.exception;


import java.text.MessageFormat;

public class VideoNotFoundException extends CultureMediaException {

    public VideoNotFoundException(String Title){
        super(MessageFormat.format("invalid title for thee video{0}", Title));
    }
    public VideoNotFoundException(){
        super("Video not found");
    }
}
