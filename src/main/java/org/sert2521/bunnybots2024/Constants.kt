package org.sert2521.bunnybots2024

import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax

object ConfigConstants{
    const val MAX_DRIVE_SPEED = 4.239
    const val DRIVE_SPEED = 3.0

    const val ROT_SPEED = 4.0
}

//Most swerve config is in deploy/swerve as .json files
object SwerveConstants{
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
    const val WRIST_ENCODER_OFFSET = 0.1;
}

object ElectricIDs{
    const val INTAKE_ID = -1
    const val INDEXER_BEAM_BREAK_ID = -1
    const val INDEXER_MOTOR_ID = -1
    const val WRIST_ID = -1
    const val DUTY_ENCODER_ID = -1
}

object TunedConstants{
    //Feed forward variables
    const val WRIST_S = 0.0
    const val WRIST_G = 0.0
    const val WRIST_V = 0.0
    const val WRIST_A = 0.0

    //PID loop variables
    const val WRIST_P = 0.0
    const val WRIST_I = 0.0
    const val WRIST_D = 0.0

    //Other stuff
    const val WRIST_ANGLE_TOLERANCE = 0.1
}

object RuntimeConstants {

}

