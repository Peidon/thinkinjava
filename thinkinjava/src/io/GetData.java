package io;

import java.nio.ByteBuffer;

public class GetData {
	private static final int BSIZE = 1024;

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		int i = 0;
		while (i++ < bb.limit()) {
			if (bb.get() != 0) {
				System.out.print("nozero");
			}
		}
		System.out.println(" i = " + i);
		bb.rewind();
		bb.flip();
	}
}
