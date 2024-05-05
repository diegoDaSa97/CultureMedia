package cultureMedia.controllers;

import java.util.*;

import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.service.impl.CultureMediaServiceImpl;

public class CultureMediaController {

    private final CultureMediaServiceImpl cultureMediaService;


    public CultureMediaController(CultureMediaServiceImpl cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }


    public List<Video> find_allVideos() throws VideoNotFoundException {
        List<Video> videos = null;
        videos = cultureMediaService.findAll()
        return videos;
    }


}
