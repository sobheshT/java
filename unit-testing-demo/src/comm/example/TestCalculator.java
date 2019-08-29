package comm.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import junit.textui.TestRunner;

public class TestCalculator extends TestCase {


	/*	@Test
	void testaddMethod() {
		int x=10;
		int y=20;
		Calculator cl=new Calculator(x,y);
		assertEquals(30,cl.addMethod());
		fail("Not yet implemented");
	}*/
	@Test
    void testisGreater() {
		int x=10;
		int y=20;
		Calculator cl =new Calculator(x,y);
		assertEquals(-1,cl.isGreater());
	}
	public static void main(String[] args) {
		TestRunner.run(TestCalculator.class);
	}
	
}
