package com.diplock.inventarioxport.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "warehouse")
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "warehouse_id")
	private Long warehouseId;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(name = "in_stock_quantity", nullable = false)
	private int inStockQuantity;

	@Column(name = "location_rack", nullable = false, length = 50)
	private String locationRack;

}
