package bootcamp.bootcoin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Bootcoin")
public class BootcoinEntity {

    @Id
    private String id;
    private String correo;
    private String tipDocument;
    private String numDocumento;
    private String numCelular;

}
