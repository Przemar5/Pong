package pong.play;

import pong.Game;
import pong.Playable;
import pong.Screen;
import pong.menus.Menu;
import pong.menus.MenuFactory;
import pong.play.elements.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Play implements Playable
{
    private Game game;
    private Paddle player1;
    private Paddle player2;
    private Ball ball;
    private boolean running = false;

    public Play(Game game)
    {
        Screen s = game.getScreen();
        this.game = game;
    }

    public void run()
    {
        running = true;
    }

    public void stop()
    {
        running = false;
    }

    @Override
    public void update()
    {
        player1.update();
        player2.update();
        updateBall();
        checkGameResult();
    }

    private void updateBall()
    {
        Screen s = game.getScreen();
        ball.bounceIfCollision(player1);
        ball.bounceIfCollision(player2);
        ball.bounceVerticalIfOutOfBounds(0, s.getHeight());
        ball.update();
    }

    private void checkGameResult()
    {
        Screen s = game.getScreen();
        if (ball.x + ball.width >= s.getWidth()) {
            onWin("First player wins!");
        }
        else if (ball.x <= 0) {
            onWin("Second player wins!");
        }
    }

    private void onWin(String msg)
    {
        Menu menu = MenuFactory.createWonGameMenu(game.getScreen(), msg);
        game.goToMenu(menu);
    }

    private void onEscape()
    {
        Menu menu = MenuFactory.createGameStopMenu(game.getScreen());
        game.goToMenu(menu);
    }

    @Override
    public void draw(Graphics2D g)
    {
        clearScreen(g);
        player1.draw(g);
        player2.draw(g);
        ball.draw(g);
    }

    public void clearScreen(Graphics2D g)
    {
        Screen s = game.getScreen();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, s.getWidth(), s.getHeight());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ESCAPE) {
            onEscape();
        }
        else {
            player1.keyPressed(e);
            player2.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setFirstPlayer(Paddle p)
    {
        player1 = p;
    }

    public void setSecondPlayer(Paddle p)
    {
        player2 = p;
    }

    public void setBall(Ball b)
    {
        ball = b;
    }
}
