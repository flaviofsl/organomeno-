package br.com.organomeno.ofx.leitura;


import br.com.organomeno.util.UtilFile;
import com.webcohesion.ofx4j.domain.data.MessageSetType;
import com.webcohesion.ofx4j.io.OFXParseException;

import java.io.IOException;
import java.io.InputStream;


public class IdentificadorOfx {
    public MessageSetType identificadorMessageType(InputStream inputStream) throws IOException{
        try {
            String arquivo = UtilFile.lerOfxComoTexto(inputStream);

            if (arquivo.contains("<BANKMSGSRSV1>")) {
                return MessageSetType.banking;
            } else if (arquivo.contains("<CREDITCARDMSGSRSV1>")) {
                return MessageSetType.creditcard;
            } else {
                throw new IOException("Tipo de OFX inválido");
            }

        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }

    }
}
