package es.sandana.tienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="bill")
public class BillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billId;

	@Column(name="fech")
	private String fech;

	@Column(name="hour")
	private Long hour;

	@Column(name="idUser")
	private String idUser;
}
