import ui.custom.frame.MainFrame;
import ui.custom.panel.MainPanel;
import ui.custom.screen.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UIMain {

    public static void main(String[] args) {
        final var gameConfig  = Stream.of(args)
                .collect(Collectors.toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]
                ));
        var mainScreen = new MainScreen(gameConfig);
        mainScreen.buildMainScreen();


    }
}
