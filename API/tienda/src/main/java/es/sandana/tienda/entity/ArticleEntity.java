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
@Table(name="article")
public class ArticleEntity {
    

    @Id
    @Column(name="ID", nullable = false)
    private Long id;

    @Column(name="DESCRIPTION")
	private String description;

    @Column(name="MODEL")
	private String model;

    @Column(name="COLOR")
	private String color;

    @Column(name="SIZE")
	private String size;

    @Column(name="STOK")
	private String stok;

}
