package pong.play.elements;

import pong.Playable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Paddle extends Rectangle implements Playable
{
    protected Color color;
    protected int minY;
    protected int maxY;
    protected int speed = 0;
    protected int speedLimit;
    protected int accStep = 2;
    protected HashMap<String,Integer> controls;

    public Paddle(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }

    public Paddle(int x, int y, int w, int h, Color c)
    {
        this(x, y, w, h);
        color = c;
    }

    public Paddle(int x, int y, int w, int h, int limit)
    {
        this(x, y, w, h);
        speedLimit = limit;
    }

    public Paddle(int x, int y, int w, int h, Color c, int limit)
    {
        this(x, y, w, h);
        color = c;
        speedLimit = limit;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        //
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();

        if (keyCode == controls.get("UP")) {
            accelerateUpIfPossible();
        }
        else if (keyCode == controls.get("DOWN")) {
            accelerateDownIfPossible();
        }
        e.consume();
    }

    private void accelerateUpIfPossible()
    {
        speed -= accStep;
        if (speed < -speedLimit)
            speed = -speedLimit;
    }

    private void accelerateDownIfPossible()
    {
        speed += accStep;
        if (speed > speedLimit)
            speed = speedLimit;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        //
    }

    @Override
    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void update()
    {
        if (y < minY) {
            y = minY;
            speed = 0;
        }
        else if (y + height > maxY) {
            y = maxY - height;
            speed = 0;
        }
        else {
            y += speed;
        }
    }

    public void setColor(Color c)
    {
        color = c;
    }

    public void setMinYPos(int y)
    {
        minY = y;
    }

    public void setMaxYPos(int y)
    {
        maxY = y;
    }

    public void setSpeedLimit(int limit)
    {
        speedLimit = limit;
    }

    public void setAccelerationStep(int step)
    {
        accStep = step;
    }

    public void setControls(HashMap<String,Integer> c)
    {
        controls = c;
    }
}
