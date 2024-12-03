package org.sert2521.bunnybots2024

import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.InstantCommand
import edu.wpi.first.wpilibj2.command.button.JoystickButton
import org.sert2521.bunnybots2024.commands.EmptyCommand
import org.sert2521.bunnybots2024.subsystems.Drivetrain

object Input {
    val driverController = XboxController(0)
    val gunnerController = Joystick(1)

    val exampleButton = JoystickButton(gunnerController, 1)
    val resetRotation = JoystickButton(driverController, 4)

    var rotationOffset = Rotation2d(0.0)

    init{
        exampleButton.whileTrue(EmptyCommand())
        resetRotation.onTrue(InstantCommand({ rotationOffset=Drivetrain.getPose().rotation }))
    }

    fun getJoystickX():Double{
        return -driverController.leftX
    }

    fun getJoystickY():Double{
        return -driverController.leftY
    }

    fun getJoystickZ():Double {
        return driverController.rightX
    }

    fun getRotOffset():Rotation2d{
        return rotationOffset
    }

    fun getRotY():Double{
        return driverController.rightY
    }
}