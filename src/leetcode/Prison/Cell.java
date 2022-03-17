package leetcode.Prison;

import java.util.ArrayList;

public class Cell {
    private int cellNum;
    private ArrayList<Prisoner> prisoners;
    private Guard guard;


    public Cell(int cellNum, ArrayList<Prisoner> prisoners, Guard guard) {
        this.cellNum = cellNum;
        this.prisoners = prisoners;
        prisoners.ensureCapacity(4);
        this.guard = guard;
    }

    public int getCellNum() {
        return cellNum;
    }

    public void setCellNum(int cellNum) {
        this.cellNum = cellNum;
    }

    public ArrayList<Prisoner> getPrisoners() {
        return prisoners;
    }

    public void setPrisoners(ArrayList<Prisoner> prisoners) {
        this.prisoners = prisoners;
    }

    public Guard getGuard() {
        return guard;
    }

    public void setGuard(Guard guard) {
        this.guard = guard;
    }
}
