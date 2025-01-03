package org.sert2521.bunnybots2024

import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.InstantCommand
import edu.wpi.first.wpilibj2.command.button.JoystickButton
import org.sert2521.bunnybots2024.commands.*

import org.sert2521.bunnybots2024.subsystems.Drivetrain
import org.sert2521.bunnybots2024.subsystems.Indexer
import org.sert2521.bunnybots2024.subsystems.Wrist

object Input {
    val driverController = XboxController(0)
    val gunnerController = Joystick(1)

    var rotationOffset = Rotation2d(0.0)


    val resetRotation = JoystickButton(driverController, 4)
    val outtakeButton = JoystickButton(driverController, 6)


    val intakeButton = JoystickButton(gunnerController, 1)
    val intakeReverse = JoystickButton(gunnerController, 3)
    val indexerReverse = JoystickButton(gunnerController, 4)
    val indexerStop = JoystickButton(gunnerController, 13)
    val indexerEnable = JoystickButton(gunnerController, 12)
    val wristStow = JoystickButton(gunnerController, 10)
    val wristCorallPos = JoystickButton(gunnerController, 9)
    val wristIntakePos = JoystickButton(gunnerController, 8)
    val indexerForce = JoystickButton(gunnerController, 2)
    val reverseIntake = JoystickButton(gunnerController, 7)


    init{
        resetRotation.onTrue(InstantCommand({ rotationOffset=Drivetrain.getPose().rotation }))
        outtakeButton.whileTrue(IndexerOuttake())

        intakeButton.whileTrue(IntakeRun())
        //intakeButton.onFalse(SetWrist(PhysicalConstants.WRIST_CORALL_POSITION))
        intakeReverse.whileTrue(IndexerOuttake())
        indexerReverse.whileTrue(IndexerReverse())
        indexerStop.onTrue(IndexerStop())
        indexerEnable.onTrue(InstantCommand({Indexer.currentCommand.cancel()}))


        wristStow.onTrue(SetWrist(PhysicalConstants.WRIST_STOW_POSITION))
        wristCorallPos.onTrue(SetWrist(PhysicalConstants.WRIST_CORALL_POSITION))
        wristIntakePos.onTrue(SetWrist(PhysicalConstants.WRIST_INTAKE_POSITION))
        reverseIntake.whileTrue(IntakeReverse())

        indexerForce.whileTrue(IndexerOuttake().alongWith(IntakeRun()))





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