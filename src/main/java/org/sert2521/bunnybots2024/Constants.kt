package org.sert2521.bunnybots2024

object ConfigConstants{

}

object PhysicalConstants {
    const val WRIST_ENCODER_OFFSET = 0.1;
}

object ElectricIDs{
    const val OUTTAKE_ID = -1
    const val WRIST_ID = -1
    const val DUTY_ENCODER_ID = -1
}

object TunedConstants{
    const val WRIST_S = 0.0
    const val WRIST_G = 0.0
    const val WRIST_V = 0.0
    const val WRIST_A = 0.0
    const val WRIST_P = 0.0
    const val WRIST_I = 0.0
    const val WRIST_D = 0.0
    const val WRIST_ANGLE_TOLERANCE = 0.1
}

object RuntimeConstants {
    var wristSetPoint = 0.0
}

