package org.sert2521.bunnybots2024

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.button.JoystickButton
import org.sert2521.bunnybots2024.commands.IndexerRun
import org.sert2521.bunnybots2024.commands.IntakeRun


object Input {
    val driverController = XboxController(0)
    val gunnerController = Joystick(1)

    val IntakeButton = JoystickButton(driverController, 3)
    val IndexerButton = JoystickButton(gunnerController,7)


    init{
        IntakeButton.whileTrue(IntakeRun())
        IndexerButton.whileTrue(IndexerRun())
    }
}