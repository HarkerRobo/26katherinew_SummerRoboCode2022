package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import harkerrobolib.commands.IndefiniteCommand;

public class ArcadeDrive extends IndefiniteCommand{
    private double turn;
    private double drive;

    public ArcadeDrive(){
        addRequirements(Drivetrain.getInstance());
    }
    public void initialize(){

    }
    public void execute(){
        drive=OI.getInstance().getDriver().getLeftY();
        turn=OI.getInstance().getDriver().getLeftX();
        Drivetrain.getInstance().setArcadeDrive(drive, turn);
    }
    public void end(boolean interruputed){
        turn=0;
        drive=0;
        Drivetrain.getInstance().setArcadeDrive(drive,turn);
    }

}