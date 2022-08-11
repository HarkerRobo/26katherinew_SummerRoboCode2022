package frc.robot;

import harkerrobolib.wrappers.HSGamepad;
import harkerrobolib.wrappers.XboxGamepad;

public class OI {
    private static OI instance;

    private HSGamepad driver;
    private HSGamepad operator;
    private static final int DRIVER_ID=0;
    private static final int OPERATOR_ID=0;

    public OI(){
        driver=new XboxGamepad(DRIVER_ID);
        operator=new XboxGamepad(OPERATOR_ID);
    }
    
    public void initBindings(){

    }
    public HSGamepad getDriver(){
        return driver;
    }

    public HSGamepad getOperator(){
        return operator;
    }

    public static OI getInstance(){
        if (instance==null){
            instance=new OI();
        }
        return instance;
    }    
}

