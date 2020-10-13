package bcr.entity;

import java.util.Random;

//0 empty
//1 tank
//2 bullet
//3 mountain
public class Map {
    private Tank playerOne;
    private Tank playerTwo;
    private int mountains;
    private int time;
    private int[][][] positions;
    private int failed = 0;
    private int limitX = 10;
    private int limitY = 10;
    public Map(Tank tank1, Tank tank2) {
        this.playerOne = tank1;
        this.playerTwo = tank2;
        this.mountains = 4;
        this.time = 300;
        positions = new int[limitX][limitY][1];
    }

    public Map() {
        this.mountains = 4;
        this.time = 300;
        positions = new int[limitX][limitY][1];
    }

    public void showPositions() {
        System.out.println("position tank1: " + this.playerOne.getPosX() + "-" + this.playerOne.getPosY());
        System.out.println("position tank2: " + this.playerTwo.getPosX() + "-" + this.playerOne.getPosY());
    }

    public void start() {
        this.clearMap();
        this.showMap();
        this.generateTanks();
        this.generateMountains();
        this.showMap();
    }

    private void clearMap() {
        for(int x = 0; x < this.limitX; x++) {
            for(int y = 0; y < this.limitY; y++) {
                this.positions[x][y][0] = 0;
            }
        }
    }

    private void showMap() {
        for(int x = 0; x < this.limitX; x++) {
            for(int y = 0; y < this.limitY; y++) {
                System.out.print(this.positions[x][y][0]);
                if(y<this.limitY-1){
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private void generateTanks() {
        this.positions[0][0][0] = 1;
        this.positions[this.limitX-1][this.limitY-1][0] = 1;
    }

    private void generateMountains() {
        Random r = new Random();
        for(int x = 0; x < this.mountains; x++) {
            int posX = r.nextInt(this.limitX-1);
            int posY = r.nextInt(this.limitY-1);
            while(this.positions[posX][posY][0]!=0) {
                posX = r.nextInt(this.limitX-1);
                posY = r.nextInt(this.limitY-1);
                failed++;
            }
            this.positions[posX][posY][0] = 3;
        }
    }

    public int getFailed() {
        return this.failed;
    }
}
