package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Image;
import com.medianet.AgenceApplication.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;

    @GetMapping
    public List<Image> getAllImages(){return imageRepository.findAll();}
}
