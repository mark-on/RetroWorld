package entity;

public class Console {
	private int id;
    private String name;
    private Brand brand;

    public Console() {}

    public Console(int id, String name, Brand brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
    
}
