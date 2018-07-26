package com.hcl.movie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="movieinfo")
public class MovieInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")	
	private Integer category_id;
	
	
	@Column(name="moviename")
	@NotBlank(message="{moviename.notblank}")
	@Size(message="{customername.size}")
	private String moviename;
	
	private String availability;
	
	private String category;
	
	private String language;
	
	
	
	private Integer price;
}
