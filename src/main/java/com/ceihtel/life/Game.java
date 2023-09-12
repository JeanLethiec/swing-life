package com.ceihtel.life;

import lombok.Getter;

import java.util.List;
import java.util.stream.Stream;

@Getter
public class Game {
    private final int rows;
    private final int columns;
    private final List<Cell> cells;

    public Game(int rows, int columns, List<Cell> cells) {
        this.rows = rows;
        this.columns = columns;
        this.cells = cells;
    }

    public Stream<Cell> getNeighbours(Cell cell) {
        return cells.stream()
                .filter(candidate ->
                        // Same column
                        (candidate.getRow() == cell.getRow() - 1 || candidate.getRow() == cell.getRow() + 1) && candidate.getColumn() == cell.getColumn() ||
                                // Same row
                                (candidate.getColumn() == cell.getColumn() - 1 || candidate.getColumn() == cell.getColumn() + 1) && candidate.getRow() == cell.getRow() ||
                                // Diagonals
                                (candidate.getRow() == cell.getRow() - 1 || candidate.getRow() == cell.getRow() + 1) && (candidate.getColumn() == cell.getColumn() - 1 || candidate.getColumn() == cell.getColumn() + 1)
                );
    }
}
