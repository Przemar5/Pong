package pong.play;

import pong.Game;
import pong.Screen;
import pong.Settings;
import pong.play.elements.Ball;
import pong.play.elements.Paddle;
import pong.play.elements.PaddleFactory;

import java.awt.*;
import java.util.HashMap;

public class PlayFactory
{
    public static Play createDefaultPlay(Game game)
    {
        Screen s = game.getScreen();
        Paddle p1 = PaddleFactory.createDefaultFirstPlayer(s);
        Paddle p2 = PaddleFactory.createDefaultSecondPlayer(s);
        Ball b = new Ball((int) s.getWidth()/2, (int) s.getHeight()/2, 40);
        Play play = new Play(game);

        play.setFirstPlayer(p1);
        play.setSecondPlayer(p2);
        play.setBall(b);
        return play;
    }
}
