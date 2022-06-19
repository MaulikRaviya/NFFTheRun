package maulikgame;

/**
 *
 * @author MaulikRaviya
 */
public class DownCar extends RoadObject {

    public int id;
    public int spriteID;

    public DownCar(int positionX, float speed, int lane) {
        super(GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT);
        id = GlobalVariables.ID++;
        this.speed = speed; //TODO randomize
        this.positionX = positionX;
        this.lane = lane;
        positionY = 0 - (GlobalVariables.CAR_HEIGHT + 10);
        live = true;
        
        switch (GlobalVariables.crazy.nextInt(4)) {
            case 0:
                image = GlobalVariables.spriteDownCar1;
                deathImage = GlobalVariables.spriteDownCar1_dead;
                spriteID = 1;
                break;
            case 1:
                image = GlobalVariables.spriteDownCar2;
                deathImage = GlobalVariables.spriteDownCar2_dead;
                spriteID = 2;
                break;
            case 2:
                image = GlobalVariables.spriteDownCar3;
                deathImage = GlobalVariables.spriteDownCar3_dead;
                spriteID = 3;
                break;
            case 3:
                image = GlobalVariables.spriteDownCar4;
                deathImage = GlobalVariables.spriteDownCar4_dead;
                spriteID = 4;
                break;
        }
    }

    @Override
    public int update() {
        positionY += speed;
        positionY += GlobalVariables.myCar.speed;
        //System.out.println("\n "+id+" updated: "+positionX+" ,"+ positionY);
        if (live) {
            if (RoadMaths.checkIns((int) positionX, (int) positionY, width,
                    height, (int) GlobalVariables.myCar.positionX + 4,
                    (int) GlobalVariables.myCar.positionY + 4)) {
                live = false;
            } else if (RoadMaths.checkIns((int) positionX, (int) positionY,
                    width, height,
                    (int) (GlobalVariables.myCar.positionX + GlobalVariables.myCar.width - 4),
                    (int) GlobalVariables.myCar.positionY + 4)) {
                live = false;
            } else if (RoadMaths.checkIns((int) positionX, (int) positionY,
                    width, height,
                    (int) (GlobalVariables.myCar.positionX + 4),
                    (int) (GlobalVariables.myCar.positionY + GlobalVariables.myCar.height - 4))) {
                live = false;
            } else if (RoadMaths.checkIns((int) positionX, (int) positionY,
                    width, height,
                    (int) (GlobalVariables.myCar.positionX + GlobalVariables.myCar.width - 4),
                    (int) (GlobalVariables.myCar.positionY + GlobalVariables.myCar.height - 4))) {
                live = false;
            }
            
            
            if (!live) { //just died...
                speed = 0;
                switch (spriteID) {
                    case 1:
                        image = GlobalVariables.spriteDownCar1_dead;
                        break;
                    case 2:
                        image = GlobalVariables.spriteDownCar2_dead;
                        break;
                    case 3:
                        image = GlobalVariables.spriteDownCar3_dead;
                        break;
                    case 4:
                        image = GlobalVariables.spriteDownCar4_dead;
                        break;
                }
                switch (lane) {

                    case 4:
                        GlobalVariables.lane4Panoti = this;
                        break;
                    case 5:
                        GlobalVariables.lane5Panoti = this;
                        break;
                    case 6:
                        GlobalVariables.lane6Panoti = this;
                        break;
                    default:
//                        System.out.println("Lane= " + lane);
                }

                if (!GlobalVariables.rajniMode) {
                    GlobalVariables.myCar.image = GlobalVariables.spriteMyCar_dead;
                    GameComputer.killTheCar();
                }
            }
        }

        if (positionY > (GlobalVariables.gameHeight + GlobalVariables.CAR_HEIGHT)) {
            return 1;
        }
        return 0;
    }
}
