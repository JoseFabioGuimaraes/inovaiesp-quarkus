package br.edu.iesp.resource;


import br.edu.iesp.entity.Festa;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/festa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Festa Resource", description = "CRUD operations for festa")
public class FestaResource {

    private static final Logger log = LoggerFactory.getLogger(FestaResource.class);

    @GET
    @Operation(
        summary = "List all festa",
        description = "Retorna uma lista de todas as festas."
    )
    public List<Festa> list(){
        return Festa.listAll();
    }

    @POST
    @Transactional
    @Operation(
        summary = "Cria uma festa",
        description = "Cria a festas e persiste."
    )
    public Festa create(Festa festa){
        festa.persist();
        return festa;
    }


}

