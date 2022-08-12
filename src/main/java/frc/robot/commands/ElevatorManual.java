package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.Elevator;

public class ElevatorManual extends CommandBase{
    
    public ElevatorManual(){
        addRequirements(Elevator.getInstance());
    }
    public void excute(){
        double output=OI.getInstance().getDriver().getRightY();
        if (Math.abs(output)<0.1){
            output=0.1;
        }
        Elevator.getInstance().setOutput(output);
    }
    public void end(boolean interruputed){
        Elevator.getInstance().setOutput(0);
    }


}
