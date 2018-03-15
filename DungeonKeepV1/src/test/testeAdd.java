package test;

import junit.framework.Test;

public class testeAdd {

	@Test(timeout=1000)
	public void testSomeRandomBehavior{
		boolean outcome1 = false,outcome2 = false;
		while(! outcome1 || !outcome2)
			someAction;
		if(condition1)
			outcome1 = true;
		else if(condition2)
			outcome2 = true;
		else
			fail("Some error message");
	}
}
