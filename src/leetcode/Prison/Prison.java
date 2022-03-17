package leetcode.Prison;

import java.util.ArrayList;

public class Prison {
    private ArrayList<Cell> cells;

    public Prison(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        return "Prison{" +
                "cells=" + cells +
                '}';
    }
}
