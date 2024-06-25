package day25;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NIOFileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Path sourcePath = Path.of("source.txt");
		Path destPath= Path.of("destination.txt");
		try(FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
				FileChannel destChannel = FileChannel.open(destPath, StandardOpenOption.CREATE,StandardOpenOption.WRITE)){
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while(sourceChannel.read(buffer)>0) {
				buffer.flip();
				destChannel.write(buffer);
				buffer.clear();
			}
			System.out.println("File copied successfully! ");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
