package org.sert2521.bunnybots2024

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.button.JoystickButton
import org.sert2521.bunnybots2024.commands.EmptyCommand

object Input {
    val driverController = XboxController(0)
    val gunnerController = Joystick(1)

    val exampleButton = JoystickButton(gunnerController, 1)

    init{
        exampleButton.whileTrue(EmptyCommand())
    }
}