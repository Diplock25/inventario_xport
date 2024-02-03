package com.diplock.inventarioxport.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "available_sizes")
public class AvailableSize {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "size_id")
	private Long sizeId;

	@Column(name = "size_name", nullable = false, length = 10)
	private String sizeName;

}
