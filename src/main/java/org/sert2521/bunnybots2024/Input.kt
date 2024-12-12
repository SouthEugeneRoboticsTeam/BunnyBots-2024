package org.sert2521.bunnybots2024

import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.InstantCommand
import edu.wpi.first.wpilibj2.command.button.JoystickButton
import org.sert2521.bunnybots2024.commands.*

import org.sert2521.bunnybots2024.subsystems.Drivetrain
import org.sert2521.bunnybots2024.subsystems.Indexer

object Input {
    val driverController = XboxController(0)
    val gunnerController = Joystick(1)

    var rotationOffset = Rotation2d(0.0)


    val resetRotation = JoystickButton(driverController, 4)
    val outtakeButton = JoystickButton(driverController, 6)


    val intakeButton = JoystickButton(gunnerController, 1)
    val bothReverse = JoystickButton(gunnerController, 2)
    val intakeReverse = JoystickButton(gunnerController, 3)
    val indexerReverse = JoystickButton(gunnerController, 4)
    val indexerStop = JoystickButton(gunnerController, 13)
    val indexerEnable = JoystickButton(gunnerController, 12)
    val wristStow = JoystickButton(gunnerController, 8)
    val wristIntake = JoystickButton(gunnerController, 9)


    init{
        resetRotation.onTrue(InstantCommand({ rotationOffset=Drivetrain.getPose().rotation }))
        intakeButton.whileTrue(IntakeRun())
        outtakeButton.whileTrue(IndexerOuttake())



        bothReverse.whileTrue(IndexerReverse().alongWith(IntakeReverse()))
        intakeReverse.whileTrue(IntakeReverse())
        indexerReverse.whileTrue(IndexerReverse())
        indexerStop.onTrue(IndexerStop())
        indexerEnable.onTrue(InstantCommand({Indexer.currentCommand.cancel()}))


        wristStow.onTrue(SetWrist(PhysicalConstants.WRIST_STOW_POSITION))
        wristIntake.onTrue(SetWrist(PhysicalConstants.WRIST_INTAKE_POSITION))





    }

    fun getJoystickX():Double{
        return -driverController.leftX
    }

    fun getJoystickY():Double{
        return -driverController.leftY
    }

    fun getJoystickZ():Double {
        return -driverController.rightX
    }

    fun getRotOffset():Rotation2d{
        return rotationOffset
    }

    fun getRotY():Double{
        return driverController.rightY
    }
}