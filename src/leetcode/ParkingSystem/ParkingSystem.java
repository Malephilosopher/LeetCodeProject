package leetcode.ParkingSystem;

public class ParkingSystem {
    private int big;
    private int medium;
    private int small;
    int curBig = 0;
    int curMedium = 0;
    int curSmall = 0;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1 : {
                curBig += 1;
                return curBig <= big;
            }
            case 2 : {
                curMedium += 1;
                return curMedium <= medium;
            }
            case 3 : {
                curSmall += 1;
                return curSmall <= small;
            }
        }
        return true;
    }
}
