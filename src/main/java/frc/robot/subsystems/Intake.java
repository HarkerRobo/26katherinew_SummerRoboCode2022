package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase{
    private static Intake instance;

    private HSTalon motor;
    private static final int MOTOR_ID=0;
    private static final boolean INVERT=false;
    private DoubleSolenoid intake;
    private static final int FOWARD_ID=0;
    private static final int REVERSE_ID=0;
    private boolean intaking;


    private Intake(){
        motor=new HSTalon(MOTOR_ID);
        motor.setInverted(INVERT);
        intake=new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FOWARD_ID, REVERSE_ID);
    }
    public void toggle(){
        if (intake.get()==Value.kForward){
            intake.set(Value.kReverse);
        }
        else{
            intake.set(Value.kForward);
        }
    }
    public HSTalon getMotor(){
        return motor;
    }

    public void setOutput(double output){
        if (output>0.1){
            intaking=true;
        }
        else{
            intaking=false;
        }
        motor.set(ControlMode.PercentOutput, output);
    }

    public boolean isIntaking(){
        return intaking;
    }

    public static Intake getInstance(){
        if (instance==null){
            instance=new Intake();
        }
        return instance;
    }

}
