import org.omg.CORBA.portable.IndirectionException;
import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import java.util.List;

/**
 * Created by Sean Frazier on 2/5/2016.
 */
@ScriptManifest(author = "Sean", logo = "", info = "Auto Fletcher", version = 1, name = "Auto Fletcher")
public class main extends Script {

    private String knifeName;
    private String logName;
    private String toMakeInv;
    private String toMakeCraft;

    public void onStart(){
        this.knifeName = "Knife";
        this.logName = "Willow logs";
        this.toMakeInv = "Willow longbow(u)";
        this.toMakeCraft = "Willow Long Bow";

    }

    @Override
    public int onLoop() throws InterruptedException {

        withdraw();
        deposit();
        return 0;
    }

    public void onExit(){

    }

    public RS2Widget getChildWidget(){
        return getChildWidget();
    }

    public void fletch() throws InterruptedException{
        getInventory().interact(this.knifeName, "Use");
        sleep(random (1500, 10000));
        getInventory().interact(this.logName, "Use");
        sleep(random (1500, 10000));
        RS2Widget.getChildWidget()
    }

    public void deposit() throws InterruptedException{
        if(this.bank.isOpen()){
            this.bank.depositAllExcept(this.knifeName);
        }
    }

    public void withdraw() throws InterruptedException{
        if(this.bank.isOpen()){
            if(!getInventory().contains(this.knifeName)){
                Item knifeBank = this.getBank().getItem(this.knifeName);
                if(knifeBank != null){
                    this.getBank().withdraw(knifeBank.getId(), 1);
                }


            }
        }
    }
}
