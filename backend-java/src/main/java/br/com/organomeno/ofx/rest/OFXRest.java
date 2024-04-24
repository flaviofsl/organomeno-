package br.com.organomeno.ofx.rest;

import br.com.organomeno.ofx.services.OFXService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import net.sf.ofx4j.io.OFXParseException;

import java.io.IOException;
import java.io.InputStream;

@Path("/ofx")
public class OFXRest {

    @Inject
    OFXService ofxService;

    @POST
    @Path("/")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response importarOFX(InputStream stream) throws IOException, OFXParseException {
        try {
            ofxService.fazerLeituraDeOFX(stream);
            return Response.ok().build();
        }catch (Exception e) {
            throw e;
        }
    }
}