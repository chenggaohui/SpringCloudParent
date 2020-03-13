package com.HHH.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",8989));

        socketChannel.configureBlocking(false);
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        byteBuffer.put(str.getBytes());
        byteBuffer.flip();

        socketChannel.write(byteBuffer);

        scanner.nextLine();
        socketChannel.close();




    }
}
