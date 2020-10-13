package com.pika.designPattern.proxy.staticProxy;

public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFile(fileName);
    }

    @Override
    public void display() {
        System.out.println("播放->" + fileName);
    }

    public void loadFile(String fileName) {
        System.out.println("载入->" + fileName);
    }
}
