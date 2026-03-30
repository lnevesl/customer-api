package cadastroCliente.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateClienteRequest {

    private String nome;
    private String telefone;


}
