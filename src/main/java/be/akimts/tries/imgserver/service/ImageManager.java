package be.akimts.tries.imgserver.service;

import be.akimts.tries.imgserver.models.Resource;
import be.akimts.tries.imgserver.models.ResourceDetail;

import java.io.IOException;

public interface ImageManager {

    byte[] retrieveByFilename(String filename);
    ResourceDetail saveFile(Resource ressource) throws IOException;

}
