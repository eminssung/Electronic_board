package ssireum;

public class Player {
	private String name;
	private String affiliation;
	public String weight;
	//»ý¼ºÀÚ
	public Player() {
		setName("");
		setAffiliation("");
		weight = "";
	}
	
	public Player(String n , String a,String w) {
		setName(n);
		setAffiliation(a);
		weight = w;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
}