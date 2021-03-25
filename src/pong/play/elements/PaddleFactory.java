package pong.play.elements;

import pong.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class PaddleFactory
{
    private static int defaultWidth = 20;
    private static int defaultHeight = 140;

    public static Paddle createDefaultFirstPlayer(Screen s)
    {
        Paddle p = new Paddle(
                20,
                (int) ((s.getHeight() - PaddleFactory.defaultHeight) / 2),
                PaddleFactory.defaultWidth,
                PaddleFactory.defaultHeight,
                Color.GREEN);
        p.setMinYPos(0);
        p.setMaxYPos(s.getHeight());
        p.setSpeedLimit(20);
        p.setAccelerationStep(2);
        p.setControls(PaddleFactory.getFirstPlayerDefaultControls());

        return p;
    }

    public static Paddle createDefaultSecondPlayer(Screen s)
    {
        Paddle p = new Paddle(
                s.getWidth() - PaddleFactory.defaultWidth - 20,
                (int) ((s.getHeight() - PaddleFactory.defaultHeight) / 2),
                PaddleFactory.defaultWidth,
                PaddleFactory.defaultHeight,
                Color.GREEN);
        p.setMinYPos(0);
        p.setMaxYPos(s.getHeight());
        p.setSpeedLimit(20);
        p.setAccelerationStep(2);
        p.setControls(PaddleFactory.getSecondPlayerDefaultControls());

        return p;
    }

    private static HashMap<String,Integer> getFirstPlayerDefaultControls()
    {
        HashMap<String,Integer> controls = new HashMap<String,Integer>();
        controls.put("UP", KeyEvent.VK_W);
        controls.put("DOWN", KeyEvent.VK_S);
        return controls;
    }

    private static HashMap<String,Integer> getSecondPlayerDefaultControls()
    {
        HashMap<String,Integer> controls = new HashMap<String,Integer>();
        controls.put("UP", KeyEvent.VK_UP);
        controls.put("DOWN", KeyEvent.VK_DOWN);
        return controls;
    }
}
