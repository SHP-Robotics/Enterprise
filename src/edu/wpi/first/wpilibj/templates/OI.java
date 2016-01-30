package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.FireFive;
import edu.wpi.first.wpilibj.templates.commands.FireFour;
import edu.wpi.first.wpilibj.templates.commands.FireOne;
import edu.wpi.first.wpilibj.templates.commands.FireSix;
import edu.wpi.first.wpilibj.templates.commands.FireThree;
import edu.wpi.first.wpilibj.templates.commands.FireTwo;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    public Joystick jLeft = new Joystick(1), jRight = new Joystick(2), jGunner = new Joystick(3);
    public Button fireOne = new JoystickButton(jGunner, 7), 
            fireTwo = new JoystickButton(jGunner, 8), 
            fireThree = new JoystickButton(jGunner, 9), 
            fireFour = new JoystickButton(jGunner, 10), 
            fireFive = new JoystickButton(jGunner, 11), 
            fireSix = new JoystickButton(jGunner, 12);
    
    public OI() {
        fireOne.whenPressed(new FireOne());
        fireTwo.whenPressed(new FireTwo());
        fireThree.whenPressed(new FireThree());
        fireFour.whenPressed(new FireFour());
        fireFive.whenPressed(new FireFive());
        fireSix.whenPressed(new FireSix());
    }
    
    

    public double getLeft() {
        return jLeft.getY();
    }

    public double getRight() {
        return jRight.getY();
    }

    public double getTurretSpeed() {
        return -1*jGunner.getTwist();
    }
    
    public boolean getSpool() {
        return jGunner.getRawButton(2);
    }
    
    public double getSpoolSpeed() {
        return -1*jGunner.getThrottle();
    }
    
    public boolean getFire() {
        return jGunner.getRawButton(1);
    }
}
