package es.sandana.demo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseUserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String email;
	
}
