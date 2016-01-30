package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.TankDriveJoysticks;
import edu.wpi.first.wpilibj.templates.commands.TurretDrive;

/**
 * @author Zhu
 */
public class Turret extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Victor motor;
    Talon spool;
    Relay safety;
    public Encoder baseEncoder;
    public Encoder turretEncoder;
    public boolean isCalibrated = false;

    public Turret() {
        motor = new Victor(8);
        spool = new Talon(7);
        safety = new Relay(3);
        baseEncoder = new Encoder(1, 2, true, EncodingType.k4X);
        turretEncoder = new Encoder(3, 4);
        isCalibrated = false;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TurretDrive());
    }

    public void set(double speed) {
        if (speed < 0 && baseEncoder.get() > -760) {
            motor.set(speed);
        } else if (speed > 0 && baseEncoder.get() < 0) {
            motor.set(speed);
        } else {
            motor.set(0);
        }
        SmartDashboard.putNumber("Encoder Pos:", baseEncoder.get());
        SmartDashboard.putNumber("Turret Encoder:", turretEncoder.get());
    }
    
    public void spool(double speed) {
        spool.set(speed);
    }
    
    public int get_turret_encoder() {
        return Math.abs(turretEncoder.get());
    }
    
    public void reset_turret_encoder() {
        turretEncoder.reset();
    }
    
    public void fire (boolean test)
    {
        if (test) {
            safety.set(Relay.Value.kOn);
        } else {
            safety.set(Relay.Value.kOff);
        }
    }
    public void calset(double speed) {

        motor.set(speed);

        SmartDashboard.putNumber("Encoder Pos:", baseEncoder.get());
    }

}
