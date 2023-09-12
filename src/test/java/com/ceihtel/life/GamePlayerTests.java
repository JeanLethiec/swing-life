package com.ceihtel.life;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GamePlayerTests {
    @Test
    void shouldSuccessFirstRound() {
        var game = dataset(0);
        var player = new GamePlayer();

        player.play(game);

        var cells = game.getCells();
        var alive = cells.stream().filter(Cell::isAlive).collect(Collectors.toList());
        assertEquals(3, alive.size());

        assertTrue(cells.get(11).isAlive());
        assertTrue(cells.get(12).isAlive());
        assertTrue(cells.get(13).isAlive());
    }

    @Test
    void shouldSuccessSecondRound() {
        var game = dataset(1);
        var player = new GamePlayer();

        player.play(game);

        var cells = game.getCells();
        var alive = cells.stream().filter(Cell::isAlive).collect(Collectors.toList());
        assertEquals(3, alive.size());

        assertTrue(cells.get(7).isAlive());
        assertTrue(cells.get(12).isAlive());
        assertTrue(cells.get(17).isAlive());
    }

    private static Game dataset(int round) {
        var initialCells = new ArrayList<Cell>();
        initialCells.add(new Cell(0, 0, false));
        initialCells.add(new Cell(0, 1, false));
        initialCells.add(new Cell(0, 2, false));
        initialCells.add(new Cell(0, 3, false));
        initialCells.add(new Cell(0, 4, false));
        initialCells.add(new Cell(1, 0, false));
        initialCells.add(new Cell(1, 1, false));
        initialCells.add(new Cell(1, 2, round == 0));
        initialCells.add(new Cell(1, 3, false));
        initialCells.add(new Cell(1, 4, false));
        initialCells.add(new Cell(2, 0, false));
        initialCells.add(new Cell(2, 1, round == 1));
        initialCells.add(new Cell(2, 2, true));
        initialCells.add(new Cell(2, 3, round == 1));
        initialCells.add(new Cell(2, 4, false));
        initialCells.add(new Cell(3, 0, false));
        initialCells.add(new Cell(3, 1, false));
        initialCells.add(new Cell(3, 2, round == 0));
        initialCells.add(new Cell(3, 3, false));
        initialCells.add(new Cell(3, 4, false));
        initialCells.add(new Cell(4, 0, false));
        initialCells.add(new Cell(4, 1, false));
        initialCells.add(new Cell(4, 2, false));
        initialCells.add(new Cell(4, 3, false));
        initialCells.add(new Cell(4, 4, false));

        return new Game(5, 5, initialCells);
    }
}
