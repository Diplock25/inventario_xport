package com.diplock.inventarioxport.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_code", nullable = false)
	private String productCode;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "colors", length = 100)
	private String colors;

	@Column(name = "price", precision = 10, scale = 2, nullable = false)
	private BigDecimal price;

	@Column(name = "cost", precision = 10, scale = 2, nullable = false)
	private BigDecimal cost;

	@ManyToOne
	@JoinColumn(name = "supplier_id", nullable = false)
	private Supplier supplier;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = AvailableSize.class, cascade = CascadeType.PERSIST)
	@JoinTable(name = "product_sizes", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "size_id"))
	private Set<AvailableSize> availableSizes;
}