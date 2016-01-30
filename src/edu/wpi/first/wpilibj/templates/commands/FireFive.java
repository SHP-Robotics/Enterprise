/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Robotics
 */
public class FireFive extends CommandBase {

    public FireFive() {
        requires(turret);
    }

    protected void initialize() {
        turret.turretEncoder.reset();
    }

    protected void execute() {
        if (turret.isCalibrated) {
            turret.set(oi.getTurretSpeed());
            if (turret.get_turret_encoder() < RobotMap.pulsesPerFire * 5) {
                turret.spool(0.45);
                turret.fire(true);
            }
        }
    }

    protected boolean isFinished() {
        return turret.get_turret_encoder() > RobotMap.pulsesPerFire * 5;
    }

    protected void end() {
        turret.spool(0);
        turret.fire(false);
    }

    protected void interrupted() {
        end();
    }
    
}
