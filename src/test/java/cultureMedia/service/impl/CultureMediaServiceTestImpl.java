package cultureMedia.service.impl;

import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.model.View;
import cultureMedia.repository.VideoRepository;
import cultureMedia.repository.ViewsRepository;
import cultureMedia.repository.impl.VideoRepositoryImpl;
import cultureMedia.repository.impl.ViewsRepositoryImpl;
import cultureMedia.service.CultureMediaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class CultureMediaServiceTestImpl {
    ViewsRepository viewsRepository = Mockito.mock();
    VideoRepository videoRepository = Mockito.mock();
    CultureMediaService cultureMediaService = new CultureMediaServiceImpl(videoRepository, viewsRepository);
    List<Video> videos = List.of(
            new Video("01", "video 1", "a video", 3.4),
            new Video("02", "video 2", "a video", 4.4),
            new Video("03", "short 3", "a video", 5.4),
            new Video("04", "short 4", "a video", 6.0),
            new Video("05", "video 5", "a video", 2.1)
    );


    @Test
    void find_all_exception() {
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.findAll();
        });
    }

    @Test
    void find_all() throws VideoNotFoundException {
        doReturn(videos).when(videoRepository).findAll();
        var target = videos.containsAll(cultureMediaService.findAll());
        assertTrue(target);

    }

    @Test
    void find_by_title_video_exception() {
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.find("title"));
    }

    @Test
    void find_by_duration_video_exception() {
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.find(0.0, 5.0));
    }

    @Test
    void find_by_title_video() throws VideoNotFoundException {
        var parameter = "video";
        var expected = videos.stream().filter(p -> p.title().contains(parameter)).toList();
        doReturn(expected).when(videoRepository).find(parameter);
        var result = cultureMediaService.find(parameter).containsAll(expected);
        assertTrue(result);
    }

    @Test
    void find_by_duration_video() throws VideoNotFoundException {
        var expected = videos.stream().filter(p -> p.duration() <= 5.0 && p.duration() >= 3.0).toList();
        doReturn(expected).when(videoRepository).find(3.0, 5.0);
        var target = cultureMediaService.find(3.0, 5.0).containsAll(expected);
        assertTrue(target);
    }
}
