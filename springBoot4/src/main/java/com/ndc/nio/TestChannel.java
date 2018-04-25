package com.ndc.nio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

@Component
public class TestChannel implements CommandLineRunner {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("C:\\Users\\15293\\Desktop\\2222.txt"), "rw");
        System.err.println(randomAccessFile.length());
        File aFile = new File("C:\\Users\\15293\\Desktop\\111.txt");
        System.err.println(aFile.length());
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1222);
        int byteRead = fileChannel.read(buffer);

        Charset charset = Charset.forName("GBK");
        while (byteRead != -1) {
            System.err.println("你是智障---" + byteRead);
            buffer.flip();
            while (buffer.hasRemaining()) {
//                System.err.print((char) buffer.get());

                System.err.println(Charset.forName("GBK").decode(buffer));
            }
            buffer.clear();
            byteRead = fileChannel.read(buffer);
        }
        fileChannel.close();
    }

    @Override
    public void run(String... args) throws Exception {
        System.err.println("ssss");

    }
}
