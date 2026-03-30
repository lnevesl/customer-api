package cadastroCliente.controller;


import cadastroCliente.dto.ClienteDto;
import cadastroCliente.dto.CreateClienteRequest;
import cadastroCliente.dto.UpdateClienteRequest;
import cadastroCliente.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ClienteController {

    private final IClienteService iClienteService;

    @PostMapping(path = "/cliente")
    public String createCliente(@RequestBody CreateClienteRequest createClienteRequest) {

        if (createClienteRequest.getNome() == null) {
            return "O Campo Nome do cliente é obrigatório!";
        }
        if (createClienteRequest.getTelefone() == null) {
            return "O Campo telefone do cliente é obrigatório!";
        }

        iClienteService.createCliente(createClienteRequest);
        return "Cliente Cadastrada com Sucesso!";
    }

    @GetMapping(path = "/cliente")
    public List<ClienteDto> listCliente(){
        return iClienteService.listCliente();
    }

    @GetMapping(path = "/cliente/{clienteId}")
    public ClienteDto clienteById(@PathVariable Long clienteId){
        return iClienteService.clienteById(clienteId);
    }

    @PutMapping("/cliente/{clienteId}")
    public String updateCliente(
            @PathVariable Long clienteId,
            @RequestBody UpdateClienteRequest updateClienteRequest
    ) {
        iClienteService.updateCliente(clienteId, updateClienteRequest);
        return "Cliente atualizado com sucesso!";
    }

    @DeleteMapping("/cliente/{clienteId}")
    public String deleteCliente(@PathVariable Long clienteId) {
        iClienteService.deleteCliente(clienteId);
        return "Cliente deletado com sucesso!";
    }
}
// path = /cliente
// query params = ?status=ativos
// &contem=lu

// path = /cliente
// query params = ?

// path = /cliente/{identificador}
