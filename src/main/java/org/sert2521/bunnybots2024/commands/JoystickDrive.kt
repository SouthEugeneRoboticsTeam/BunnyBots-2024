package org.sert2521.bunnybots2024.commands

import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.math.kinematics.ChassisSpeeds
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.InstantCommand
import org.sert2521.bunnybots2024.Input
import org.sert2521.bunnybots2024.subsystems.Drivetrain
import kotlin.math.pow

class JoystickDrive(private val fieldOriented:Boolean = true) : Command() {
    val joystickX = Input::getJoystickX
    val joystickY = Input::getJoystickY
    val joystickZ = Input::getJoystickZ

    val inputRotOffset = Input::getRotationOffset



    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(Drivetrain)
    }

    override fun initialize() {

    }

    override fun execute() {
        if (joystickX() == 0.0 && joystickY() == 0.0 && joystickZ() == 0.0){
            Drivetrain.stop()
        }
        else if (fieldOriented) {
            Drivetrain.driveRobotOriented(
                ChassisSpeeds.fromFieldRelativeSpeeds(
                    joystickX().pow(3) * Drivetrain.getMaxSpeed(),
                    joystickY().pow(3) * Drivetrain.getMaxSpeed(),
                    joystickZ().pow(3) * Drivetrain.getMaxSpeed(),
                    Drivetrain.getPose().rotation.minus(inputRotOffset())
                )
            )
        }
        else {
            Drivetrain.driveRobotOriented(
                ChassisSpeeds(
                    joystickX().pow(3) * Drivetrain.getMaxSpeed(),
                    joystickY().pow(3) * Drivetrain.getMaxSpeed(),
                    joystickZ().pow(3) * Drivetrain.getMaxSpeed()
                )
            )
        }
    }

    override fun isFinished(): Boolean {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false
    }

    override fun end(interrupted: Boolean) {
        Drivetrain.stop()
    }
}
