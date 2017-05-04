import org.osbot.E;
import org.osbot.rs07.api.Objects;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import sun.reflect.generics.tree.Tree;


/**
 * Created by Sean Frazier on 2/4/2016.
 */

@ScriptManifest(author = "Sean Frazier", logo = "", info ="Automatically cuts Trees anywhere til full inventory. Does not bank" , version = 1.0 , name = "[WC] Tree")
public class main extends Script {

    private int i =1;


    @Override

    public void onStart(){

    }

    public void onExit(){

    }


    public int onLoop() throws InterruptedException {

        if (i >= 5){
            camera.moveYaw(random(-180,180));
            i =0;
        }



        if(!getInventory().isFull()){

            //chop
            Area treeArea = new Area(3092, 3240, 3970, 3246);
            Entity Tree = objects.closest("Tree");
            if(Tree != null) {
                if(Tree.isVisible()) {
                    if(!myPlayer().isAnimating()) {
                        if(!myPlayer().isMoving()) {

                            Tree.interact("Chop Down");
                            i++;

                        }
                    }

                    sleep(random(1500, 15000));
                }else {


                    camera.toEntity(Tree);
                }
            }
        }else{

            }



        return 0;
    }




}
