package unam.diplomado.pixup.usuario.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 40)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;

    @Size(max = 40)
    @NotNull
    @Column(name = "primer_apellido", nullable = false, length = 40)
    private String primerApellido;

    @Size(max = 40)
    @Column(name = "segundo_apellido", length = 40)
    private String segundoApellido;

    @Size(max = 150)
    @NotNull
    @Column(name = "password", nullable = false, length = 150)
    private String password;

    @Size(max = 40)
    @NotNull
    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Size(max = 13)
    @Column(name = "rfc", length = 13)
    private String rfc;

}