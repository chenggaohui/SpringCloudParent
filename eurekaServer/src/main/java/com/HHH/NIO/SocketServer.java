package com.HHH.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        //1.获取服务器端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.将通道设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //3.设置监听的端口
        serverSocketChannel.bind(new InetSocketAddress(8989));
        //4.获取一个选择器
        Selector selector = Selector.open();
        //5.把通道注册到选择其中
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.判断是否有连接事件
        while(selector.select()>0){
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            //7.获取已经连接就绪的事件
            while(iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();

                //8.判断当前事件是否就绪
                if(selectionKey.isAcceptable()){
                    //9.如果当前事件连接就绪，获取连接就绪的连接的通道
                    SocketChannel socket = serverSocketChannel.accept();
                    System.out.println("客户端:"+socket.getRemoteAddress()+"连接成功");
                    //10.把该通道设置为非阻塞，并注册到选择器中
                    //并且监听该连接的写操作是否完成，进行读数据
                    socket.configureBlocking(false);
                    socket.register(selector,SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    //11.获取读就绪的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //12.创建一个字节缓冲区
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    while(socketChannel.read(byteBuffer)>0){
                        //13.缓冲区切换到读模式
                        byteBuffer.flip();
                        System.out.println("客户端地址为："+socketChannel.getRemoteAddress()+",发送的数据为:"+new String(byteBuffer.array()));
                        //14.切换到写模式
                        byteBuffer.clear();
                    }
                }
            }
            iterator.remove();
        }

    }
}
