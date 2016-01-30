package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Zhu
 */
public class CalibrateTurret extends CommandBase {

    int stage;

    public CalibrateTurret() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(turret);
        stage = 0;//0 = move to left, 1 = move to right, 2= done
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        turret.baseEncoder.start();
        turret.turretEncoder.start();
        turret.turretEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (stage == 0) {
            turret.calset(oi.getTurretSpeed());
            SmartDashboard.putString("Move To:", "Turret Left Limit");
            if (oi.jGunner.getRawButton(1)) {
                turret.baseEncoder.reset();
                SmartDashboard.putString("Move To:", "N/A");
                stage = 1;
            }

        } else if (stage == 1) {
            SmartDashboard.putString("Move To:", "N/A");
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (stage == 1) {
            turret.isCalibrated = true;
            return true;
        } else {
            return false;
        }

    }

    // Called once after isFinished returns true
    protected void end() {
        //beep boop
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
