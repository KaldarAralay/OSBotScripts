import org.osbot.rs07.script.Script;
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
@ScriptManifest(author = "Sean Frazier", logo = "", info = "Auto walks to Port Sarim", version = 1, name = "[Auto Walk] Port Sarim")
public class main extends Script{




    @Override
    public int onLoop() throws InterruptedException {


        //Walk to Draynor Bank
        Area bankArea = new Area(3027, 3228, 3028, 3228);
        if (!bankArea.contains(myPlayer())){
            getWalking().webWalk(bankArea);
        }

        sleep(random(700, 1500));



        return 0;
    }


}