package cadastroCliente.persistence.repositories;

import cadastroCliente.persistence.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity , Long> {

    List<ClienteEntity> findAll();
    List<ClienteEntity> findByAtivo(Boolean ativo);
    Optional<ClienteEntity> findByClienteIdAndAtivo(Long clienteId, Boolean ativo);
    // se eu clicar shift + f6, clicando na variavel e renomeia ela em todos os lugares.
}
