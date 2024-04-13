package CultureMedia.repository;

import CultureMedia.model.Video;

import java.util.List;

public interface VideoRepository {
    List<Video> findAll();
    Video save(Video save);
    List<Video> find (String Title);
    List<Video> find(Double fromDuration, Double toDuration);
}
