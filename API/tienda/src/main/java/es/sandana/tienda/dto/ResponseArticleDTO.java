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
public class ResponseArticleDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String description;
	private String model;
	private String size;
	private String color;
	private String stok;
	private String gender;
	private Long pvp;

}

