package entity;

import java.util.List;

public class PizzaPie {

	private int pizzaPieId;
	private String name;
	private List<Toppings> toppings;
	
	public PizzaPie(int pizzaPieId, String name, List<Toppings> toppings) {
		this.setPizzaPieId(pizzaPieId);
		this.setName(name);
		this.setToppings(toppings);
	}

	public int getPizzaPieId() {
		return pizzaPieId;
	}

	public void setPizzaPieId(int pizzaPieId) {
		this.pizzaPieId = pizzaPieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Toppings> getToppings() {
		return toppings;
	}

	public void setToppings(List<Toppings> toppings) {
		this.toppings = toppings;
	}

}
