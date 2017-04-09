package puzzle;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class was written specifically to test certain GUI elements and ideas
 * for puzzles. do not use for production-quality fishing puzzle
 *
 * This puzzle will build a list of Fish, which is an inner class of PuzzleFish
 * and randomly place them on a 10 by 10 grid
 *
 * @author lucas.burdell
 */
public class PuzzleFish extends PuzzleModel {

    // configurable constants
    public static final int MAP_WIDTH = 10;
    public static final int MAP_HEIGHT = 10;
    public static final int NUMBER_OF_FISH = 5;

    private static final Random RANDOM = new Random();

    private ArrayList<Fish> fishes = new ArrayList<>();
    private int fishLeft;

    public PuzzleFish() {
        for (int i = 0; i < NUMBER_OF_FISH; i++) {
            Fish fish = new Fish();
            fishes.add(fish);
        }
        fishLeft = fishes.size();
    }

    /**
     * @return the fishes
     */
    public ArrayList<Fish> getFishes() {
        return fishes;
    }

    /**
     * @return the fishLeft
     */
    public int getFishLeft() {
        return fishLeft;
    }

    public static class Fish {

        private int xPos = 0;
        private int yPos = 0;
        private boolean caught = false;

        public Fish() {
            xPos = RANDOM.nextInt(MAP_WIDTH);
            yPos = RANDOM.nextInt(MAP_HEIGHT);
        }

        /**
         * @return the xPos
         */
        public int getXPos() {
            return xPos;
        }

        /**
         * @param xPos the xPos to set
         */
        public void setXPos(int xPos) {
            this.xPos = xPos;
        }

        /**
         * @return the yPos
         */
        public int getYPos() {
            return yPos;
        }

        /**
         * @param yPos the yPos to set
         */
        public void setYPos(int yPos) {
            this.yPos = yPos;
        }

        /**
         * @return the caught
         */
        public boolean isCaught() {
            return caught;
        }

        /**
         * @param caught the caught to set
         */
        public void setCaught(boolean caught) {
            this.caught = caught;
        }

    }

    /**
     * Method for catching a fish
     *
     * @param fish the Fish to catch
     * @return true if fish caught successfully
     */
    public boolean catchFish(Fish fish) {
        if (fish.isCaught()) {
            return false;
        }
        if (!fishes.contains(fish)) {
            return false;
        }
        fish.setCaught(true);
        fishLeft--;
        if (getFishLeft() <= 0) {
            this.setCompleted();
        }
        return true;
    }
}
