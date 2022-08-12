package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Wrist extends SubsystemBase{
    private static Wrist instance;
    private HSTalon master;
    private VictorSPX follower;
    private static final int MASTER_ID=0;
    private static final int FOLLOWER_ID=0;
    private static final boolean MASTER_INV=false;
    private static final boolean FOLLOWER_INV=false;
    
    private Wrist(){
        master=new HSTalon(MASTER_ID);
        follower=new VictorSPX(FOLLOWER_ID);
        master.setInverted(MASTER_INV);
        follower.setInverted(FOLLOWER_INV);
        follower.follow(master);
    }

    public void setOutput(double output){
        master.set(ControlMode.PercentOutput, output);
    }

    public static Wrist getInstance(){
        if (instance==null){
            instance=new Wrist();
        }
        return instance;
    }
}
