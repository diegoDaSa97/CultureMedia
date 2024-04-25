package CultureMedia.service.impl;

import CultureMedia.exception.VideoNotFoundException;
import CultureMedia.model.Video;
import CultureMedia.model.View;
import CultureMedia.repository.VideoRepository;
import CultureMedia.repository.ViewsRepository;
import CultureMedia.repository.impl.VideoRepositoryImpl;
import CultureMedia.repository.impl.ViewsRepositoryImpl;
import CultureMedia.service.CultureMediaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CultureMediaServiceTestImpl {
    CultureMediaService cultureMediaService;
    VideoRepository videoRepository;
    ViewsRepository viewsRepository;
    Video video ;
    List<Video> videos = List.of(
            new Video("01", "video 1", "a video", 3.4),
            new Video("02", "video 2", "a video", 4.4),
            new Video("03", "short 3", "a video", 5.4),
            new Video("04", "short 4", "a video", 6.0),
            new Video("05", "video 5", "a video", 2.1)
    );
    View view;

    @BeforeEach
    void setUp() {
        viewsRepository = new ViewsRepositoryImpl();
        videoRepository = new VideoRepositoryImpl();
        cultureMediaService = new CultureMediaServiceImpl(videoRepository, viewsRepository);
    }

    private void fillVideos() throws VideoNotFoundException{
        videos.forEach(video -> cultureMediaService.save(video));
    }

    @Test
    void fid_all_exception() {
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.findAll();
        });
    }

    @Test
    void find_all() throws VideoNotFoundException {
        fillVideos();
        boolean target = cultureMediaService.findAll().containsAll(videos);
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
        fillVideos();
        List<Video> expected = videos.stream().filter(video -> video.title().contains("video")).toList();
        boolean target = cultureMediaService.find("video").containsAll(expected);
        assertTrue(target);
    }

    @Test
    void find_by_duration_video() throws VideoNotFoundException {
        fillVideos();
        List<Video> expected = videos.stream().filter(p -> p.duration() <= 5.0 && p.duration() >= 3.0).toList();
        boolean target = cultureMediaService.find(3.0, 5.0).containsAll(expected);
        assertTrue(target);
    }
}
