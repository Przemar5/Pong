package pong.play.elements;

import pong.Drawable;
import pong.Updatable;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball extends Ellipse2D.Float implements Drawable, Updatable
{
    protected int velX;
    protected int velY;
    protected Color color = Color.GREEN;

    public Ball(int x, int y, int d)
    {
        super(x, y, d, d);
        Random rand = new Random();
        this.velX = rand.nextInt(40) - 20;
        this.velY = rand.nextInt(40) - 20;
    }

    public Ball(int x, int y, int d, Color color)
    {
        super(x, y, d, d);
        Random rand = new Random();
        this.velX = rand.nextInt(40) - 20;
        this.velY = rand.nextInt(40) - 20;
        this.color = color;
    }

    public Ball(int x, int y, int d, int velX, int velY, Color color)
    {
        super(x, y, d, d);
        this.velX = velX;
        this.velY = velY;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillOval((int) x, (int) y, (int) width, (int) width);
    }

    @Override
    public void update()
    {
        x += velX;
        y += velY;
    }

    public void bounceIfCollision(Rectangle r)
    {
        if (hasCollided(r)) {
            if ((x + width <= r.x + velX) || (x >= r.x + r.width + velX)) {
                bounceHorizontal();
            }
            if ((y + height <= r.y + velY) || (y >= r.y + r.height + velY)) {
                bounceVertical();
            }
        }
    }

    public void bounceHorizontal()
    {
        velX = -velX;
    }

    public void bounceVertical()
    {
        velY = -velY;
    }

    private boolean hasCollided(Rectangle r)
    {
        return (x + width >= r.x && y + height >= r.y &&
                x <= r.x + r.width && y <= r.y + r.height);
    }

    public void bounceVerticalIfOutOfBounds(int minY, int maxY)
    {
        if (y + velY < minY || y + width + velY > maxY)
            bounceVertical();
    }
}
