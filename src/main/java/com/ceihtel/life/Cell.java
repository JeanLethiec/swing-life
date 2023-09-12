package com.ceihtel.life;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cell {
    private int row;
    private int column;
    private boolean alive;

    public Cell(Cell cell, boolean alive) {
        this.row = cell.row;
        this.column = cell.column;
        this.alive = alive;
    }
}
