package org.sert2521.bunnybots2024

import edu.wpi.first.math.trajectory.TrapezoidProfile
import kotlin.math.PI

object ConfigConstants{
    const val MAX_DRIVE_SPEED = 4.239
    const val DRIVE_SPEED = 3.0

    const val ROT_SPEED = 4.0
}

//Most swerve config is in deploy/swerve as .json files
object AutoConstants{
    const val AUTO_POWER_P = 0.0
    const val AUTO_POWER_I = 0.0
    const val AUTO_POWER_D = 0.0

    const val AUTO_ANGLE_P = 0.0
    const val AUTO_ANGLE_I = 0.0
    const val AUTO_ANGLE_D = 0.0

    const val MAX_AUTO_SPEED = 0.0

    const val DRIVE_BASE_RADIUS = 0.0

    const val AUTO_REPLANNING_TOTAL_ERROR = 0.0
    const val AUTO_REPLANNING_SPIKE = 0.0
}
object PhysicalConstants {
    const val WRIST_ENCODER_OFFSET = 0.55/2.79

    const val WRIST_STOW_POSITION = 1.846
    const val WRIST_INTAKE_POSITION = -0.15
}

object ElectricIDs{
    const val INTAKE_ID = 13
    const val INDEXER_BEAM_BREAK_ID = 3
    const val INDEXER_MOTOR_ID = 15
    const val WRIST_ID = 14
    const val DUTY_ENCODER_ID = 0
}

object TunedConstants{
    //Feed forward variables
    const val WRIST_S = 0.8
    const val WRIST_G = 0.1
    const val WRIST_V = 0.88
    const val WRIST_A = 0.0

    //PID loop variables
    const val WRIST_P = 6.0
    const val WRIST_I = 0.0
    const val WRIST_D = 0.0

    val WRIST_TRAP = TrapezoidProfile.Constraints(2.0, 3.0)

    //Other stuff
    const val WRIST_ANGLE_TOLERANCE = 0.1
    const val VISION_AUTO_TOLERANCE = 0.1
}

object RuntimeConstants {

}

