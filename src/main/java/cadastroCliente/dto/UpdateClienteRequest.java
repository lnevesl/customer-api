package cadastroCliente.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class UpdateClienteRequest {

    private String nome;
    private String telefone;


}
