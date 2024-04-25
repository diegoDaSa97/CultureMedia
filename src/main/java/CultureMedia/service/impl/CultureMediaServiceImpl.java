package CultureMedia.service.impl;

import CultureMedia.exception.DurationNotValidException;
import CultureMedia.exception.VideoNotFoundException;
import CultureMedia.model.Video;
import CultureMedia.model.View;
import CultureMedia.repository.VideoRepository;
import CultureMedia.repository.ViewsRepository;
import CultureMedia.service.CultureMediaService;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {

    private VideoRepository videoRepository;
    private ViewsRepository viewRepository;

    public CultureMediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewRepository) {
        this.videoRepository = videoRepository;
        this.viewRepository = viewRepository;
    }

    public List<Video> findAll() throws VideoNotFoundException{
        if (videoRepository.findAll().isEmpty()) {
            throw new VideoNotFoundException();
        }

        return videoRepository.findAll();
    }

    @Override
    public Video save(Video video) {
        return videoRepository.save(video);
    }

    public View save(View view) {

        return viewRepository.save(view);
    }

    @Override
    public List<Video> find(String title) throws VideoNotFoundException {
        if (videoRepository.find(title).isEmpty()) {
            throw new VideoNotFoundException(title);
        }
        return videoRepository.find(title);
    }

    @Override
    public List<Video> find(double fromDuration, double toDuration) throws VideoNotFoundException {
        if (videoRepository.find(fromDuration, toDuration).isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videoRepository.find(fromDuration, toDuration);
    }


}
