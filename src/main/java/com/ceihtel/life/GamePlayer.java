package com.ceihtel.life;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    public void play(Game game) {
        List<Cell> newCells = new ArrayList<>();

        game.getCells().forEach(cell -> {
            long aliveNeighboursCount = game.getNeighbours(cell).filter(Cell::isAlive).count();
            newCells.add(new Cell(cell, shouldBeAlive(cell, aliveNeighboursCount)));
        });

        game.getCells().clear();
        game.getCells().addAll(newCells);
    }

    private boolean shouldBeAlive(Cell cell, long aliveNeighboursCount) {
        return (cell.isAlive() && (aliveNeighboursCount == 2 || aliveNeighboursCount == 3)) ||
                (!cell.isAlive() && aliveNeighboursCount == 3);
    }
}
