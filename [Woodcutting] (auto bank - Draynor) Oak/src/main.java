import com.sun.xml.internal.bind.v2.model.core.ID;
import org.osbot.E;
import org.osbot.rs07.api.Objects;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.event.WalkingEvent;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import sun.reflect.generics.tree.Tree;


/**
 * Created by Sean Frazier on 2/6/2016.
 */

@ScriptManifest(author = "Sean Frazier", logo = "", info = "Cuts oaks directly outside Draynor bank. Banks upon full inventory", version = 1.0, name = "[WC](bank-Draynor)Oak")
public class main extends Script {

    private int i = 1;
    private String keep1;
    private String keep2;
    private String keep3;
    private String keep4;
    private String keep5;


    @Override

    public void onStart() {
        this.keep1 = "Bronze axe" ;
        this.keep2 = "Iron axe";
        this.keep3 = "Steel axe";
        this.keep4 = "Mith axe";
        this.keep5 = "Adamant axe";

    }

    public void onExit() {

    }


    public int onLoop() throws InterruptedException {

        if (i >= 5) {
            camera.moveYaw(random(-180, 180));
            i = 0;
        }
        if (!getInventory().isFull()) {

            //Fish

            Entity object1 = objects.closest("Oak");
            if (object1 != null) {
                if (object1.isVisible()) {
                    action();



                }else {
                    Area actionArea = new Area(3099, 3241, 3102, 3245);
                    getWalking().webWalk(actionArea);
                    if (object1 != null) {
                        if (object1.isVisible()) {
                            action();
                        }
                    }
                }

                //walk to fish area
            }
        } else {
            //bank
            Area bankArea = new Area(3092, 3240, 3093, 3245);
            if (bankArea.contains(myPlayer())) {
                Entity bankBooth = objects.closest(6943);

                if (bank.isOpen()) {
                    bank.depositAllExcept(keep1,keep2,keep3,keep4,keep5);
                } else {
                    if (bankBooth != null) {
                        if (bankBooth.isVisible()) {
                            bankBooth.interact("Bank");
                            sleep(random(1500, 15000));
                        }
                    }
                }

                sleep(random(700, 1500));
                //walk to bank
            } else {
                getWalking().webWalk(bankArea);
            }
        }
        //move camera

        return 0;
    }
    //fish
    public void action() throws InterruptedException {

        Entity object1 = objects.closest("Oak");


        if (!myPlayer().isAnimating()) {
            if (!myPlayer().isMoving()) {

                object1.interact("Chop Down");
                i++;

            }
        }

        sleep(random(1500, 15000));


    }


}
