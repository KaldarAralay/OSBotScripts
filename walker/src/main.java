import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.script.Script;
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
@ScriptManifest(author = "Sean Frazier", logo = "", info = "Walks you places", version = 1.0, name = "Walker")

public class main extends Script {

    public void onStart(){

    }

    public int onLoop(){



        return 0;
    }

    public void onExit(){
        Area bankArea = new Area(3092, 3240, 3970, 3246);

        if(bankArea.contains(myPlayer())){

        }else{
            walking.walk(bankArea);
        }
    }
}
