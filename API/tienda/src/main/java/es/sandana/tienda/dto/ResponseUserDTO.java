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
public class ResponseUserDTO implements Serializable { 
	
	private String email;
	private String passwd;
	private String rol;
	
}

