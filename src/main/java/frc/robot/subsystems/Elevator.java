package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase{
    public static Elevator instance;

    private HSTalon master;
    private HSTalon follower;
    private VictorSPX follower_M;
    private VictorSPX follower_F;

    private static final int MASTER_ID=0;
    private static final int FOLLOWER_ID=0;
    private static final int FOLLOWER_M_ID=0;
    private static final int FOLLOWER_F_ID=0;
    private static final boolean MASTER_INV=false;
    private static final boolean FOLLOWER_INV=false;
    private static final boolean FOLLOWER_M_INV=false;
    private static final boolean FOLLOWER_F_INV=false;

    private Elevator(){
        master=new HSTalon(MASTER_ID);
        follower=new HSTalon(FOLLOWER_ID);
        follower_M=new VictorSPX(FOLLOWER_M_ID);
        follower_F=new VictorSPX(FOLLOWER_F_ID);
        master.setInverted(MASTER_INV);
        follower.setInverted(FOLLOWER_INV);
        follower_M.setInverted(FOLLOWER_M_INV);
        follower_F.setInverted(FOLLOWER_F_INV);
        follower.follow(master);
        follower_M.follow(master);
        follower_F.follow(follower);
    }
    public void setOutput(double output){
        master.set(ControlMode.PercentOutput, output);
    }

    

    public static Elevator getInstance(){
        if (instance==null){
            instance=new Elevator();
        }
        return instance;
    }
}
