package demoservice.domain;

public class Dog {
	private String name;
	private String species;
	private User master;
	
	public Dog() {
		// default constructor
	}
	
	public Dog(User user) {
		this.master = user;
	}

	public void init() {
		// initialize
	}
	
	public void cleanup() {
		// destruction
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public User getMaster() {
		return master;
	}

	public void setMaster(User master) {
		this.master = master;
	}
}
