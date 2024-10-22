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
@Table(name="LineBill")
public class LineBillEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lineBillId;

	@Column(name="billId")
	private Long billId;

	@Column(name="articleId")
	private Long articleId;

	@Column(name="amount")
	private Long amount;

	@Column(name="pvp")
	private Long pvp;

}
