package es.sandana.tienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class UserEntity {
    
    @Id
    @Column(name="email", nullable = false)
	private String email;

    @Column(name="passwd")
	private String passwd;

    @Column(name="rol")
	private String rol;
}
