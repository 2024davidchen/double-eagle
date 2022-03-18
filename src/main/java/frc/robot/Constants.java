// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class CAN {
        public static final int driveFL = 62;
        public static final int driveFR = 2;
        public static final int driveBR = 11;
        public static final int driveBL = 8;

        public static final int intake = 25;
        public static final int booper = 7;
        public static final int shooterF = 36;
        public static final int shooterB = 5;

        public static final int pneumaticmod = 3;
        public static final int solenoidF = 7;
        public static final int solenoidR = 0;

        public static final int climberID = 0;
    }

    public static class XBOX {
        // Buttons
        public static final int BUTTON_A = 1;
        public static final int BUTTON_B = 2;
        public static final int BUTTON_X = 3;
        public static final int BUTTON_Y = 4;
        public static final int BUMPER_LEFT = 5;
        public static final int BUMPER_RIGHT = 6;
        public static final int BUTTON_BACK = 7;
        public static final int BUTTON_START = 8;
        public static final int STICK_LEFT = 9;
        public static final int STICK_RIGHT = 10;
    
        // Axes
        public static final int STICK_L_X_AXIS = 0;
        public static final int STICK_L_Y_AXIS = 1;
        public static final int STICK_R_X_AXIS = 4;
        public static final int STICK_R_Y_AXIS = 5;
        public static final int TRIGGER_L_AXIS = 2;
        public static final int TRIGGER_R_AXIS = 3;
    
        public static final double MIN_DEADZONE = 0.13;
        public static final double MAX_DEADZONE = 0.15;
        public static final double SLOW_MODE_MULTIPLIER = 0.5;
      }

    public class Logitech{

         // Axes
         public static final int STICK_L_X_AXIS = 0;
         public static final int STICK_L_Y_AXIS = 1;
         public static final int STICK_R_X_AXIS = 4;
         public static final int STICK_R_Y_AXIS = 5;
         public static final int TRIGGER_L_AXIS = 2;
         public static final int TRIGGER_R_AXIS = 3;

         public static final int BUMPER_LEFT = 5;
         public static final int BUMPER_RIGHT = 6;


    }
}
