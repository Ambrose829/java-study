package com.pika.designPattern.template;

public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new FootballGame();
        game.play();
        game = new BasketballGame();
        game.play();
    }
}
