package com.hexaware.veggies.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vegetable")
public class Vegetable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "veg_id")
	private Long vegetableId;
	
	@Column(name = "veg_name", nullable = false)
	private String vegetableName;
	
	@Column(name = "veg_price", nullable = false)
	private double vegetablePrice;
	
	@Column(name = "veg_description")
	private String vegetableDescription;
	
	

	public Vegetable() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Vegetable(String vegetableName, double vegetablePrice, String vegetableDescription) {
		super();
		this.vegetableName = vegetableName;
		this.vegetablePrice = vegetablePrice;
		this.vegetableDescription = vegetableDescription;
	}



	public Long getVegetableId() {
		return vegetableId;
	}



	public void setVegetableId(Long vegetableId) {
		this.vegetableId = vegetableId;
	}



	public String getVegetableName() {
		return vegetableName;
	}



	public void setVegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}



	public double getVegetablePrice() {
		return vegetablePrice;
	}



	public void setVegetablePrice(double vegetablePrice) {
		this.vegetablePrice = vegetablePrice;
	}



	public String getVegetableDescription() {
		return vegetableDescription;
	}



	public void setVegetableDescription(String vegetableDescription) {
		this.vegetableDescription = vegetableDescription;
	}



	@Override
	public String toString() {
		return "Vegetable [vegetableId=" + vegetableId + ", vegetableName=" + vegetableName + ", vegetablePrice="
				+ vegetablePrice + ", vegetableDescription=" + vegetableDescription + "]";
	}

	
	

}
