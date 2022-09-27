package be.akimts.tries.imgserver.service;

public interface ImageManager {

    byte[] retrieveByFilename(String filename);
    String saveFile(byte[] doc);

}
