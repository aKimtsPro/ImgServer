package be.akimts.tries.imgserver;

import be.akimts.tries.imgserver.exceptions.InvalidImgException;
import be.akimts.tries.imgserver.service.ImageManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController("/img")
public class ImageController {

    private final ImageManager manager;

    public ImageController(ImageManager manager) {
        this.manager = manager;
    }

    @GetMapping(value = "/{filename", produces = { "image/jpeg", "image/png" })
    public byte[] retrieve(@PathVariable String filename){
        return this.manager.retrieveByFilename(filename);
    }

    @PostMapping(value = "/save", consumes = {"image/jpeg", "image/png"})
    public String save(@RequestParam MultipartFile file){
        try{
            return this.manager.saveFile(file.getBytes());
        }
        catch (IOException e){
            throw new InvalidImgException();
        }
    }



}
