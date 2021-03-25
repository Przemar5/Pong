package pong.menus;

import pong.Screen;
import pong.menus.options.*;

public class MenuFactory
{
    public static Menu createMainMenu(Screen screen)
    {
        return new Menu(screen, "Pong", new Option[]{
                OptionFactory.createPlayOption(screen),
                OptionFactory.createExitOption(screen),
        });
    }

    public static Menu createGameFinishMenu(Screen screen, String title)
    {
        return new Menu(screen, title, new Option[]{
                OptionFactory.createPlayOption(screen, "Play again"),
                OptionFactory.createOpenMainMenuOption(screen),
        });
    }

    public static Menu createWonGameMenu(Screen screen, String msg)
    {
        return MenuFactory.createGameFinishMenu(screen, msg);
    }

    public static Menu createGameStopMenu(Screen screen)
    {
        return new Menu(screen, "Paused", new Option[]{
                OptionFactory.createResumeOption(screen),
                OptionFactory.createOpenMainMenuOption(screen),
        });
    }
}
