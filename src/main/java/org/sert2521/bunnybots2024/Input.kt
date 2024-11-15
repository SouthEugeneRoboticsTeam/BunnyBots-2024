package org.sert2521.bunnybots2024

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController

object Input {
    val driverController = XboxController(0)
    val gunnerController = Joystick(1)
}