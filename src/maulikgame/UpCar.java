package maulikgame;

/**
 *
 * @author MaulikRaviya
 */
public class UpCar extends RoadObject {

    public int id;
    public int spriteID;
    public int type;

    public UpCar(int positionX, float speed, int lane) {
        super(GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT);
        id = GlobalVariables.ID++;
        this.lane = lane;

        this.speed = speed; //TODO randomize
        this.positionX = positionX;
        positionY = 0 - (GlobalVariables.CAR_HEIGHT + 10);
        live = true;
        if (GlobalVariables.myCar.live) {
            type = 1;
        } else {
            type = 2;
            this.speed = speed;
            positionY = height + GlobalVariables.gameHeight;
        }
        //System.out.println(
                //"UpCar created: " + id + ", (" + type + "), porionX=" + positionX + "," + this.positionX);
        switch (GlobalVariables.crazy.nextInt(4)) {
            case 0:
                image = GlobalVariables.spriteUpCar1;
                deathImage = GlobalVariables.spriteUpCar1_dead;
                spriteID = 1;
                break;
            case 1:
                image = GlobalVariables.spriteUpCar2;
                deathImage = GlobalVariables.spriteUpCar2_dead;
                spriteID = 2;
                break;
            case 2:
                image = GlobalVariables.spriteUpCar3;
                deathImage = GlobalVariables.spriteUpCar3_dead;
                spriteID = 3;
                break;
            case 3:
                image = GlobalVariables.spriteUpCar4;
                deathImage = GlobalVariables.spriteUpCar4_dead;
                spriteID = 4;
                break;
        }

        //image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        //System.out.println("\n a car with id=" + id + " created:- Spike = " + image + " of " + image.getWidth(null) + "x" + image.getHeight(null));
    }

    @Override
    public int update() {
        positionY -= speed;
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
                    (int) (GlobalVariables.myCar.positionY) + 4)) {
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
                        image = GlobalVariables.spriteUpCar1_dead;
                        break;
                    case 2:
                        image = GlobalVariables.spriteUpCar2_dead;
                        break;
                    case 3:
                        image = GlobalVariables.spriteUpCar3_dead;
                        break;
                    case 4:
                        image = GlobalVariables.spriteUpCar4_dead;
                        break;
                }
                switch (lane) {
                    case 1:
                        GlobalVariables.lane1Panoti = this;
                        break;
                    case 2:
                        GlobalVariables.lane2Panoti = this;
                        break;
                    case 3:
                        GlobalVariables.lane3Panoti = this;
                        break;
                    default:
                       // System.out.println("Lane= " + lane);

                }
                if (!GlobalVariables.rajniMode) {
                    GlobalVariables.myCar.image = GlobalVariables.spriteMyCar_dead;
                    GameComputer.killTheCar();
                }
            }
        }
        if (GlobalVariables.myCar.live) {
            if (positionY > (GlobalVariables.gameHeight + GlobalVariables.CAR_HEIGHT)) {
                //System.out.println("destroyed: " + id);
                return 1;
            }
        } else {
            if (positionY < (0 - GlobalVariables.CAR_HEIGHT)) {
                //System.out.println("destroyed: " + id);
                return 1;
            }
        }
        return 0;
    }

}
