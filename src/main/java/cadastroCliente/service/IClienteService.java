package cadastroCliente.service;

import cadastroCliente.dto.ClienteDto;
import cadastroCliente.dto.CreateClienteRequest;
import cadastroCliente.dto.UpdateClienteRequest;

import java.util.List;

public interface IClienteService {

   void createCliente(CreateClienteRequest createClienteRequest);

   List<ClienteDto> listCliente();

   ClienteDto clienteById(Long clienteId);

   void updateCliente(Long clienteId, UpdateClienteRequest request);

   void deleteCliente(Long clienteId);
}
