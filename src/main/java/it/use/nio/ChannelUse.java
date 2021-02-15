package it.use.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class ChannelUse {

	private final int iterations;
	private final ChannelFactory channelFactory;

	public ChannelUse(int ordinal, int iterations) {
		this.iterations = iterations;
		channelFactory = new ChannelFactory( "./my-file-" + ordinal );
	}

	public void use() throws IOException {
		try ( FileChannel channel = channelFactory.createAndWrite() ) {
			ByteBuffer buff = ByteBuffer.wrap( "Add this -> ".getBytes( StandardCharsets.UTF_8 ) );
			channel.write( buff );
		}
		for ( int i = 0; i < iterations; i++ ) {
			try ( FileChannel channel = channelFactory.read() ) {
				ByteBuffer buff = ByteBuffer.allocate(1024);
				int noOfBytesRead = channel.read(buff);
				String fileContent = new String(buff.array(), StandardCharsets.UTF_8);
				final HashMap<Object, Object> hashMap = new HashMap<>();
				hashMap.put( noOfBytesRead, fileContent );
			}
			try ( FileChannel channel = channelFactory.write() ) {
				ByteBuffer buff = ByteBuffer.wrap( "Add this -> ".getBytes( StandardCharsets.UTF_8 ) );
				channel.write( buff );
			}
		}
		try ( FileChannel channel = channelFactory.deleteOnClose() ) {

		}
	}
}
