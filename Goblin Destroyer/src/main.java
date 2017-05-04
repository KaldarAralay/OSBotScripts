//OSBot API
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

//Importing Java AWT
import java.awt.*;

//Script Details
@ScriptManifest(name = "Goblin Crusher", author = "Sean Frazier", version = 1.0, info = "", logo = "")
public class main extends Script {

    @Override
    public void onStart() {
        log("Welcome to Sean's Goblin fucker-uper");

    }

    @Override
    public void onExit() {
        log("peace");
    }

    @Override
    public int onLoop() throws InterruptedException {
        //Script on loop
        NPC chicken = npcs.closest("Goblin");
        //Looking for non-player character chicken, which will be the closest NPC called chicken

            if(chicken != null) {
                if (chicken.isVisible()) {
                if(!myPlayer().isAnimating() && !myPlayer().isMoving()) {

                    chicken.interact("Attack");
                    sleep(random(300, 600));
//If chicken is available on the screen, we will perform interaction Attack on it.
                } else {
                    camera.toEntity(chicken);
//Moving camera so that the chicken will be visible on the screen.
                }
            }
        } else {
            sleep(random(300, 600));
//Sleeping for with devitation
        }

        return(random(100, 300));
//Starting the script over after random sleep in milliseconds.
    }

    @Override
    public void onPaint(Graphics2D g) {
        //Loading paint
        super.onPaint(g);
        g.setColor(Color.GREEN);
        // g.drawString("Uncle Dolan had a chikun ", 5, 290);
//Text color is GREEN - printing a line in the client saying Uncle Dolan had a chikun

    }

}