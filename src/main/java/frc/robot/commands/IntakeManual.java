package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.Intake;

public class IntakeManual extends CommandBase{
    public IntakeManual(){
        addRequirements(Intake.getInstance());
    }
    public void initialize(){
        Intake.getInstance().toggle();
    }
    public void excute(){
        double output=OI.getInstance().getDriver().getRightTrigger();
        if (output>0.5){
            output=0.3;
        }
        else{
            output=0;
        }
        Intake.getInstance().setOutput(output);
    }
    public void end(boolean interrupted){
        Intake.getInstance().setOutput(0);
        
    }
}
