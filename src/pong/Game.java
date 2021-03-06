package pong;

import pong.menus.*;
import pong.menus.Menu;
import pong.play.Play;
import pong.play.PlayFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Core implements KeyListener, Drawable
{
    private boolean playing = false;
    private Menu menu;
    private Play play;

    public void init()
    {
        super.init();
        Window w = screen.getFullScreenWindow();
        w.setFocusTraversalKeysEnabled(false);
        w.addKeyListener(this);
        menu = MenuFactory.createMainMenu(screen);
        play = PlayFactory.createDefaultPlay(this);
        play.run();
    }
    
    public void goToMenu(Menu m)
    {
        menu = m;
        playing = false;
    }

    public void startPlaying()
    {
        playing = true;
    }

    public void stopPlaying()
    {
        playing = true;
    }

    public void startNewGame()
    {
        play = PlayFactory.createDefaultPlay(this);
        playing = true;
        play.run();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        e.consume();
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();

        if (!playing) {
            menu.keyPressed(e, this);
        }
        else {
            play.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        e.consume();
    }

    public synchronized void draw(Graphics2D g)
    {
        if (!playing) {
            menu.draw(g);
        }
        else {
            play.update();
            play.draw(g);
        }
    }

    public Play getPlay()
    {
        return play;
    }
}
