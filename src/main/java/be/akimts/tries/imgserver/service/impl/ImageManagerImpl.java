package be.akimts.tries.imgserver.service.impl;

import be.akimts.tries.imgserver.models.Resource;
import be.akimts.tries.imgserver.models.ResourceDetail;
import be.akimts.tries.imgserver.service.ImageManager;
import be.akimts.tries.imgserver.utils.AppArgs;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Log4j2
@Service
public class ImageManagerImpl implements ImageManager {

    private final Path storeLocation;

    public ImageManagerImpl(AppArgs args) {
        this.storeLocation = Paths.get( args.getFirst("store") );
        log.info("Image store initialized at location: " + storeLocation);
    }

    @Override
    public byte[] retrieveByFilename(String filename) {
        String specificPath = storeLocation + "\\" + filename;
        try( InputStream in = new FileInputStream(specificPath) ){
            return in.readAllBytes();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ResourceDetail saveFile(Resource ressource) throws IOException {
        String filename = storeLocation + "\\" + ressource.getFilename();
        try( OutputStream out = new BufferedOutputStream(new FileOutputStream(filename)) ) {
            out.write( ressource.getContent() );
        }
        return ResourceDetail.of(ressource);
    }
}
