package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
	public static void main(String[] args) throws IOException {
		FileOutputStream fs = new FileOutputStream("data.txt");
		FileChannel fc = fs.getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		fs.close();
	}
}
