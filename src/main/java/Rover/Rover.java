package Rover;

import Area.Area;

public class Rover {
    public static final String EAST = "E";
    public static final String SOUTH = "S";
    public static final String WEST = "W";
    public static final String NORTH = "N";
    private Area area;
    private String direction;

    public Rover(Area area) {
        this.area =  area;
    }


    public void land(Area area, int x, int y, String direction) {

        this.area= area;
//        this.x = x;
//        this.y = y;
        area.setX(x);
        area.setY(y);
        this.direction=direction;
    }

    public String getPosition() {
        //return ""+area.getX() +area.getY()+direction;
        return String.format("%d%d%s", area.getX(), area.getY(),direction);
    }

    public void move() {
        if(this.direction.equals(EAST)){
            area.setX(area.getX()+1);
        }
        if(this.direction.equals(WEST)){
            area.setX(area.getX()-1);
        }
        if(this.direction.equals(NORTH)){
            area.setX(area.getY()+1);
        }
        if(this.direction.equals(SOUTH)){
            area.setX(area.getY()-1);
        }
    }

    public void turnLeft() {
        if (direction.equals(EAST)){
            direction = NORTH;
            return;
        }
        if (direction.equals(NORTH)){
            direction = WEST;
            return;
        }
        if (direction.equals(WEST)){
            direction = SOUTH;
            return;
        }
        if (direction.equals(SOUTH)){
            direction = EAST;
            return;
        }
    }

    public void turnRight() {
        if (direction.equals(EAST)){
            direction = SOUTH;
            return;
        }
        if (direction.equals(SOUTH)){
            direction = WEST;
            return;
        }
        if (direction.equals(WEST)){
            direction = NORTH;
            return;
        }
        if (direction.equals(NORTH)){
            direction = EAST;
            return;
        }
    }
}
