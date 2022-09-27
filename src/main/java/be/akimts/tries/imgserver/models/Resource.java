package be.akimts.tries.imgserver.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.util.MimeType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class Resource extends RepresentationModel<Resource> {

    private String filename;
    private long size;
    private byte[] content;
    private MimeType type;
    private String location;

    public static Resource of(MultipartFile file) throws IOException {

        byte[] content = file.getBytes();
        Resource ressource = new Resource();

        ressource.setContent( content );
        ressource.setSize( content.length );
        ressource.setType( MimeType.valueOf( Objects.requireNonNull(file.getContentType()) ));
        ressource.setFilename( UUID.randomUUID().toString() + '.' + ressource.getType().getSubtype() );

        return ressource;

    }

}
