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
@ScriptManifest(author = "Sean Frazier", logo = "", info = "Auto walks to Draynor Bank", version = 1, name = "[Auto Walk] Draynor Bank")
public class main extends Script{




    @Override
    public int onLoop() throws InterruptedException {


        //Walk to Draynor Bank
        Area bankArea = new Area(3092, 3240, 3093, 3245);
        if (!bankArea.contains(myPlayer())){
            getWalking().webWalk(bankArea);
        }

        sleep(random(700, 1500));



        return 0;
    }


}
