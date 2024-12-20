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
@Table(name="articles")
public class ArticleEntity {


    @Id
    @Column(name="ID", nullable = false)
    private Long id;

    @Column(name="DESCRIPTION")
	private String description;

    @Column(name="MODEL")
	private String model;

    @Column(name="SIZE")
    private String size;

    @Column(name="COLOR")
	private String color;

    @Column(name="STOCK")
    private String stok;

    @Column(name="GENDER")
    private String gender;

    @Column(name="PVP")
    private String pvp;
}
