package com.ceihtel.life;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.util.ArrayList;

public class GameOfLife {
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
        var game = initialize();

        var player = new GamePlayer();
        var window = display(game);
        Thread.sleep(3000);

        player.play(game);
        refresh(game, window);

        Thread.sleep(3000);
        player.play(game);
        refresh(game, window);
    }

    public static JFrame display(Game game) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        frame.setLayout(new GridLayout(game.getRows(), game.getColumns()));

        refresh(game, frame);

        frame.setVisible(true);

        return frame;
    }

    private static void refresh(Game game, JFrame frame) {
        frame.getContentPane().removeAll();
        for (Cell cell : game.getCells()) {
            var subframe = new JTextArea();
            subframe.setBorder(new BorderUIResource.LineBorderUIResource(Color.gray));
            subframe.setBackground(cell.isAlive() ? Color.black : Color.white);
            frame.getContentPane().add(subframe);
        }
        frame.revalidate();
        frame.repaint();
    }

    public static Game initialize() {
        var initialCells = new ArrayList<Cell>();
        initialCells.add(new Cell(0, 0, false));
        initialCells.add(new Cell(0, 1, false));
        initialCells.add(new Cell(0, 2, false));
        initialCells.add(new Cell(0, 3, false));
        initialCells.add(new Cell(0, 4, false));
        initialCells.add(new Cell(1, 0, false));
        initialCells.add(new Cell(1, 1, false));
        initialCells.add(new Cell(1, 2, true));
        initialCells.add(new Cell(1, 3, false));
        initialCells.add(new Cell(1, 4, false));
        initialCells.add(new Cell(2, 0, false));
        initialCells.add(new Cell(2, 1, false));
        initialCells.add(new Cell(2, 2, true));
        initialCells.add(new Cell(2, 3, false));
        initialCells.add(new Cell(2, 4, false));
        initialCells.add(new Cell(3, 0, false));
        initialCells.add(new Cell(3, 1, false));
        initialCells.add(new Cell(3, 2, true));
        initialCells.add(new Cell(3, 3, false));
        initialCells.add(new Cell(3, 4, false));
        initialCells.add(new Cell(4, 0, false));
        initialCells.add(new Cell(4, 1, false));
        initialCells.add(new Cell(4, 2, false));
        initialCells.add(new Cell(4, 3, false));
        initialCells.add(new Cell(4, 4, false));

        return new Game(ROWS, COLUMNS, initialCells);
    }
}
