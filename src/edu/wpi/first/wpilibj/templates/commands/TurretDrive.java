package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Zhu
 */
public class TurretDrive extends CommandBase {

    public TurretDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(turret);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //turret.encoder.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (turret.isCalibrated) {
            turret.set(oi.getTurretSpeed());
            if (oi.getSpool()) {
                turret.spool((oi.getSpoolSpeed()+1)/2);
            } else {
                turret.spool(0);
            }
            
            if (oi.getFire()) {
                turret.fire(true);
            } else {
                turret.fire(false);
            }
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
