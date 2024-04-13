package CultureMedia.repository;

import CultureMedia.model.Videos;

import java.util.List;

public interface VideoRepository {
    List<Videos> findAll();
    Videos save( Videos save);
    List<Videos> find (String Title);
    List<Videos> find(Double fromDuration, Double toDuration);
}
