package cultureMedia.controllers;

import java.util.List;

import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.service.CultureMediaService;

public class CultureMediaController {

    private final CultureMediaService cultureMediaService;


    public CultureMediaController(CultureMediaService cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }


    public List<Video> findAllVideos() throws VideoNotFoundException {
        List<Video> videos = cultureMediaService.findAll();
        return cultureMediaService.findAll();
    }


}
