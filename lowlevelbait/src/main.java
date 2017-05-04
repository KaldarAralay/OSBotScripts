import com.sun.xml.internal.bind.v2.model.core.ID;
import org.osbot.E;
import org.osbot.rs07.api.Objects;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import sun.reflect.generics.tree.Tree;


/**
 * Created by Sean Frazier on 2/4/2016.
 */

@ScriptManifest(author = "Sean", logo = "", info ="Usesbait on low level areas (id 1530) ", version = 1.0 , name = "Low level bait")
public class main extends Script {

    private int i =1;


    @Override

    public void onStart(){

    }

    public void onExit(){

    }


    public int onLoop() throws InterruptedException {





        if(!getInventory().isFull()){

            //chop
            // Area treeArea = new Area(3244, 3150, 3244, 3150);
            NPC fishSpot = npcs.closest(1530);
            if(fishSpot != null) {
                if(fishSpot.isVisible()) {
                    if(!myPlayer().isAnimating()) {
                        if(!myPlayer().isMoving()) {

                            fishSpot.interact("Bait");
                            i++;

                        }
                    }

                    sleep(random(1500, 15000));
                }else {



                }
            }
        }else{
            //bank
            Area bankArea = new Area(3092, 3240, 3970, 3246);
            if(bankArea.contains(myPlayer()) ) {

                sleep(random(700, 1500));
            }else{
                walking.walk(bankArea);
            }
        }

        if (i >= 5){
            camera.moveYaw(random(-180,180));
            i =0;
        }
        return 0;
    }




}
