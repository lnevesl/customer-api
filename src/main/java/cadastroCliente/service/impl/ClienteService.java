package cadastroCliente.service.impl;


import cadastroCliente.dto.ClienteDto;
import cadastroCliente.dto.CreateClienteRequest;
import cadastroCliente.dto.UpdateClienteRequest;
import cadastroCliente.persistence.entities.ClienteEntity;
import cadastroCliente.persistence.repositories.ClienteRepository;
import cadastroCliente.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {


    private final ClienteRepository clienteRepository;

    @Override
    public void createCliente(CreateClienteRequest createClienteRequest) {

        var clienteEntity = new ClienteEntity();
        clienteEntity.setNomeCliente(createClienteRequest.getNome());
        clienteEntity.setTelefoneCliente(createClienteRequest.getTelefone());
        clienteEntity.setAtivo(true);
        clienteRepository.save(clienteEntity);
    }

//    @Override
//    public List<ClienteDto> listCliente() {
//        var clienteLista = clienteRepository.findAll()
//                .stream()
//                .map(clienteEntity -> {
//                    var clienteDto = new ClienteDto();
//                    clienteDto.setNome(clienteEntity.getNomeCliente());
//                    clienteDto.setTelefone(clienteEntity.getTelefoneCliente());
//
//                    return clienteDto;
//                })
//                .toList();
//        return clienteLista;
//
//    }

    @Override
    public List<ClienteDto> listCliente() {
        var clienteLista = clienteRepository.findByAtivo(true)
                .stream()
                .map(clienteEntity -> {
                    var clienteDto = new ClienteDto();
                    clienteDto.setNome(clienteEntity.getNomeCliente());
                    clienteDto.setTelefone(clienteEntity.getTelefoneCliente());

                    return clienteDto;
                })
                .toList();
        return clienteLista;

    }

    @Override
    public ClienteDto clienteById(Long clienteId) {

//        var cliente = clienteRepository.findById(clienteId);
//        if (cliente.isEmpty()) {
//            throw new RuntimeException("cliente nao encontrado");
//        }

        var cliente = clienteRepository.findByClienteIdAndAtivo(clienteId, true)
                .orElseThrow(() -> new RuntimeException("cliente nao encontrado"));

        var clienteDto = new ClienteDto();
        clienteDto.setNome(cliente.getNomeCliente());
        clienteDto.setTelefone(cliente.getTelefoneCliente());
//        clienteDto.setNome(cliente.get().getNomeCliente());
//        clienteDto.setTelefone(cliente.get().getTelefoneCliente());

        return clienteDto;
    }

    @Override
    public void updateCliente(Long clienteId, UpdateClienteRequest updateClienteRequest) {

        // Busca o cliente no banco de dados pelo ID informado
        var  entity = clienteRepository.findByClienteIdAndAtivo(clienteId, true)

                // O método findById retorna um Optional
                // Se o cliente NÃO existir, entra no orElseThrow

                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Se encontrou → retorna o cliente
        //Se NÃO encontrou → explode a exceção

        if (updateClienteRequest.getNome() != null) {
            entity.setNomeCliente(updateClienteRequest.getNome());
        }

        if (updateClienteRequest.getTelefone() != null) {
            entity.setTelefoneCliente(updateClienteRequest.getTelefone());
        }

        clienteRepository.save(entity);
    }
    @Override
    public void deleteCliente(Long clienteId) {

        ClienteEntity entity = clienteRepository.findByClienteIdAndAtivo(clienteId, true)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        entity.setAtivo(false);
        clienteRepository.save(entity);
    }
}