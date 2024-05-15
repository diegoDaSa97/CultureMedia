package cultureMedia.controllers;

import java.util.Collections;
import java.util.List;

import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.repository.impl.VideoRepositoryImpl;
import cultureMedia.repository.impl.ViewsRepositoryImpl;
import cultureMedia.service.CultureMediaService;
import cultureMedia.service.impl.CultureMediaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CultureMediaController {

    private final CultureMediaService cultureMediaService;


    public CultureMediaController(CultureMediaService cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    public CultureMediaController() {
        this.cultureMediaService = new CultureMediaServiceImpl(new VideoRepositoryImpl(), new ViewsRepositoryImpl());
    }
    @GetMapping("/videos")
    public ResponseEntity<List<Video>> findAllVideos() {
        try {
            return ResponseEntity.ok().body(cultureMediaService.findAll());
        }
        catch (VideoNotFoundException e){
            return ResponseEntity.ok().header("Error-Message", e.getMessage()).body( Collections.emptyList() );
            }
        }

    @PostMapping("/videos")
    public Video addVideo(@RequestBody Video video){
        return cultureMediaService.save(video);
    }
}
