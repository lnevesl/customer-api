package cadastroCliente.persistence.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "tb_cliente", schema = "public")
public class ClienteEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cliente_id" , nullable = false)
    private Long clienteId;

    @Setter
    @Column(name = "nome_cliente" , nullable = false)
    private String nomeCliente;

    @Setter
    @Column(name = "telefone_cliente" , nullable = false)
    private String telefoneCliente;

    @Setter
    @Column(name = "ativo" , nullable = false)
    private Boolean ativo;
}
