package it.use.nio;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ChannelFactory {

	private final Path path;

	public ChannelFactory(String filePath) {
		path = Path.of( filePath );
	}

	public FileChannel createAndWrite() throws IOException {
		return FileChannel.open( path, StandardOpenOption.CREATE, StandardOpenOption.WRITE );
	}

	public FileChannel read() throws IOException {
		return FileChannel.open( path, StandardOpenOption.READ );
	}

	public FileChannel write() throws IOException {
		return FileChannel.open( path, StandardOpenOption.WRITE );
	}

	public FileChannel deleteOnClose() throws IOException {
		return FileChannel.open( path, StandardOpenOption.DELETE_ON_CLOSE );
	}
}
