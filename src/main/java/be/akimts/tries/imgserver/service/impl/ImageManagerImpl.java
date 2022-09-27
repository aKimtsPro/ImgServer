package be.akimts.tries.imgserver.service.impl;

import be.akimts.tries.imgserver.service.ImageManager;
import org.springframework.stereotype.Service;

@Service
public class ImageManagerImpl implements ImageManager {
    @Override
    public byte[] retrieveByFilename(String filename) {
        return new byte[0];
    }

    @Override
    public String saveFile(byte[] doc) {
        return null;
    }
}
