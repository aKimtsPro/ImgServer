package be.akimts.tries.imgserver.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.util.MimeType;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class ResourceDetail extends RepresentationModel<ResourceDetail> {

    private String filename;
    private long size;
    private String mimeType;

    public static ResourceDetail of(Resource resource){
        return ResourceDetail.builder()
                .filename(resource.getFilename())
                .size(resource.getSize())
                .mimeType(resource.getType().getType()+"/"+resource.getType().getSubtype())
                .build();
    }

}
