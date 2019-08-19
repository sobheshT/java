package comm.interfaceSample;

public class Monkey implements LivingThings{
private String name;
public Monkey(String name) {
	this.name=name;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public void walk() {
	System.out.println("Monkey "+getName()+" can also walk");
	
}
}
