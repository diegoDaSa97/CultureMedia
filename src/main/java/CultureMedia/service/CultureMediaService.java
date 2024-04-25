package CultureMedia.service;

import CultureMedia.exception.VideoNotFoundException;
import CultureMedia.model.Video;
import CultureMedia.model.View;

import java.util.List;

public interface CultureMediaService {

    List<Video> findAll() throws VideoNotFoundException;

    Video save(Video video);

    View save(View view);

    List<Video> find(String title) throws VideoNotFoundException;

    List<Video> find(double fromDuration, double toDuration) throws VideoNotFoundException;




}
