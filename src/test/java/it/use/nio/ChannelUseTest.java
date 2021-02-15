package it.use.nio;

import org.junit.jupiter.api.Test;

public class ChannelUseTest {

	@Test
	public void test() throws Exception {
		for (int i=0; i<100; i++) {
			new ChannelUse( i, 100 ).use();
		}
	}

}
