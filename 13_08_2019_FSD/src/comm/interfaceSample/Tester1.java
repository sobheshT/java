package comm.interfaceSample;

public class Tester1 {
public static void main(String[] args) {
	LivingThings livingThings=new Monkey("Tom");
	livingThings.walk();
	Dog dog=new Dog("A","B");
	dog.createLivingThings();
	new LivingThings() {
		@Override
		public void walk() {
			System.out.println("Dog Name:"+dog.getName()+"Breed Name:"+dog.getBreed());
		}
	};
	
}
}
