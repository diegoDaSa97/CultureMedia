package CultureMedia.repository;

import CultureMedia.model.Video;
import CultureMedia.model.View;

import java.util.List;

public interface CultureMediaService {

    default List<Video> findAll() {
        return null;
    }

    default Video save(Video save) {
        return null;
    }

    default View save(View save) {
        return null;
    }

}
