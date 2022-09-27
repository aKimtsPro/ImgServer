package be.akimts.tries.imgserver.controllers;

import be.akimts.tries.imgserver.models.Resource;
import be.akimts.tries.imgserver.models.ResourceDetail;
import be.akimts.tries.imgserver.service.ImageManager;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/img")
public class ImageController {

    private final ImageManager manager;

    public ImageController(ImageManager manager) {
        this.manager = manager;
    }

    @GetMapping(value = "/{filename}", produces = { "image/jpeg", "image/png" })
    public byte[] retrieve(@PathVariable String filename){
        return this.manager.retrieveByFilename(filename);
    }

    @PostMapping(value = "/save")
    public ResourceDetail save(@RequestParam MultipartFile file){
        try{
            Resource resource = Resource.of(file);
            ResourceDetail details = this.manager.saveFile( resource );
            return details.add( Link.of("/img/"+details.getFilename(), IanaLinkRelations.DESCRIBES_VALUE) );
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }



}
