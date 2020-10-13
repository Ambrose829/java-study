package com.pika.designPattern.proxy.staticProxy;

public class ProxyParternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("向往的生活");

        image.display();
        System.out.println();
        image.display();
    }
}
