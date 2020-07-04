package july4th.immutableClass;
//1. make class final
//2. make field private + final
//3  only getter, no setter
public final class StudentImmutableClass {
	private final int id;
	private final String name;
	
	public StudentImmutableClass(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
