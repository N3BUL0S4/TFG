package es.sandana.tienda.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CartEntity {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

	 	@Column(name="Id-Cart")
	 	private Long cartId;
	 	
	    @Column(name="Id-article")
		private Long articleId;

	    @Column(name="amount")
		private Long amount;
}
