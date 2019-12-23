
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CalculatorTest {

	
	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		int a=23;
		int b=33;
		int result=calculator.add(a, b);
		int expected=56;
		assertEquals(expected, result);
		fail("Not yet implemented");
	}

}
