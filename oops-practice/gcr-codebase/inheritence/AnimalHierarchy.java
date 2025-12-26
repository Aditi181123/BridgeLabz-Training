package inheritence;

class Animal{
	public String name;
	public int age;
	
	public Animal (String name , int age) {
		this.name = name;
		this.age = age;
	}
	
	public void makeSound() {
		System.out.println("Animal make sound ");
	}
}

class dog extends Animal{
	public dog(String name , int age) {
		super (name , age);
	}
	
	public void makeSound() {
		System.out.println(name + "'s sound woof woof");
	}
}

class cat extends Animal{

	public cat(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	
	public void makeSound() {
		System.out.println(name + "'s sound meow meow");
	}
}

class bird extends Animal{

	public bird(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	public void makeSound() {
		System.out.println(name + "'s sound chrip chrip");
	}
}

public class AnimalHierarchy {
	public static void main(String[] args) {
		Animal[] animals = {
				new dog("Buddy", 3),
				new cat("Kitty", 2),
				new bird("Tweety", 1)
		};
		for (Animal animal : animals) {
            animal.makeSound(); 
        }
	}
}
