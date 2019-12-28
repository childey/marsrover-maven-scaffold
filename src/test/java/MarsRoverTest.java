import Area.Area;
import Rover.Rover;
import RoverController.RoverController;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class MarsRoverTest {
    @Rule
    public ExpectedException exceptedException = ExpectedException.none();

    @Test
    public void land(){
        Area area = new Area(10,10);
        Rover rover =new Rover();
        rover.land(area,5,5, "E");
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55E");
    }
    @Test
    public void move_forward(){
        Area area = new Area(10,10);
        Rover rover =new Rover();
        rover.land(area,5,5,"E");
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("65E");
    }

    @Test
    public void turn_left(){
        Area area = new Area(10,10);

        Rover rover =new Rover();
        rover.land(area,5,5,"S");
        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55E");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55N");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55W");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55S");


    }

    @Test
    public void turn_right(){
        Area area = new Area(10,10);

        Rover rover =new Rover();
        rover.land(area,5,5,"S");
        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55W");

        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55N");

        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55E");

        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55S");


    }

    @Test
    public void roverBatchExcute(){
        Rover rover =new Rover();
        RoverController roverController = new RoverController(rover);
        String mission ="10,10,5,5,E,M,L,M,R";
        String postion = roverController.excute(mission);
        assertThat(postion).isEqualTo("66E");
    }

    @Test
    public void landException(){
        exceptedException.expect(IllegalArgumentException.class);
        exceptedException.expectMessage("out of bound !");
        Area area = new Area(10,10);
        Rover rover =new Rover();
        rover.land(area,20,5, "E");
    }

    @Test
    public void moveException(){
        exceptedException.expect(IllegalArgumentException.class);
        exceptedException.expectMessage("out of bound !");
        Area area = new Area(10,10);
        Rover rover =new Rover();
        rover.land(area,10,5, "E");
        rover.move();
    }

}
