package com.buddy;

public class GameLevelGenerator {
    Level[] levels = new Level[10];

    



    private class Level {
        Floor floor;

        String name;
        Floor[] floors = new Floor[10];

        public Level generateLevel(){
            Level level = new Level();

            for(int i = 0; i <10; i++) {
                floors[i] = floor.generateFloor();

            }

            level.floors = this.floors;
            return level;
        }
    }

    private class Floor {
        String name;

        public Floor generateFloor() {
            return new Floor();
        }
    }

}
