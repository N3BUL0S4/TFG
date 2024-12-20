package es.sandana.tienda.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCartDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idCart;
	private String idUser;

}
