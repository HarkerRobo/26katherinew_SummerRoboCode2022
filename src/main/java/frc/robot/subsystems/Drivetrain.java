package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase {
    private static Drivetrain instance;
    private HSTalon rightmaster;
    private HSTalon leftmaster;
    private VictorSPX rightfollow;
    private VictorSPX leftfollow;

    public static final int RMID=0;
    public static final int LMID=0;
    public static final int RFID=0;
    public static final int LFID=0;

    private static final boolean RMINVERT=false;
    private static final boolean LMINVERT=false;
    private static final boolean RFINVERT=false;
    private static final boolean LFINVERT=false;

    public Drivetrain(){
        rightmaster=new HSTalon(RMID);
        leftmaster=new HSTalon(LMID);
        rightfollow=new VictorSPX(RFID);
        leftfollow=new VictorSPX(LFID);
        rightfollow.follow(rightmaster);
        leftfollow.follow(leftmaster);
        rightmaster.setInverted(RMINVERT);
        leftmaster.setInverted(LMINVERT);
        rightfollow.setInverted(RFINVERT);
        leftfollow.setInverted(LFINVERT);
    }
    public void setArcadeDrive(double speed, double turn){
        rightmaster.set(ControlMode.PercentOutput, speed-turn);
        leftmaster.set(ControlMode.PercentOutput, speed+turn);
    }

    public static Drivetrain getInstance(){
        if (instance==null){
            instance=new Drivetrain();
        }
        return instance;
    }
}
