package frc.robot.commands;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.Wrist;

public class WristManual extends CommandBase{
    public WristManual(){
        addRequirements(Wrist.getInstance());
    }
    public void excute(){
        double output=0;
        if (OI.getInstance().getDriver().getUpDPadButton().get()){
            output=0.7;
        }
        else if (OI.getInstance().getDriver().getDownDPadButton().get()){
            output=-0.7;
        }
        else {
            output=0.2;
        }
        Wrist.getInstance().setOutput(output);
    }
    public void end(boolean interruputed){
        Wrist.getInstance().setOutput(0);
    }
}
