package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.TankDriveJoysticks;

/**
 * @author Zhu
 */
public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    RobotDrive drive;
    Victor left, right;

    public Drivetrain() {
        left = new Victor(10);
        right = new Victor(9);
        drive = new RobotDrive(left, right);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TankDriveJoysticks());
    }

    public void drive(double left, double right) {
        drive.tankDrive(left, right);
    }
}
