package org.sert2521.bunnybots2024.commands

import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.math.kinematics.ChassisSpeeds
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.InstantCommand
import org.sert2521.bunnybots2024.ConfigConstants
import org.sert2521.bunnybots2024.Input
import org.sert2521.bunnybots2024.subsystems.Drivetrain
import kotlin.math.*
import kotlin.time.times

class JoystickDrive(private val fieldOriented:Boolean = true) : Command() {
    val joystickX = Input::getJoystickX
    val joystickY = Input::getJoystickY
    val joystickZ = Input::getJoystickZ

    val inputRotOffset = Input::getRotOffset



    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(Drivetrain)
    }

    override fun initialize() {

    }

    override fun execute() {
        val x = joystickX()
        val y = joystickY()

        var magnitude = sqrt(x.pow(2)+y.pow(2))
        val angle = atan2(y, x)

        magnitude = magnitude.pow(3)

        val newX = cos(angle)*magnitude
        val newY = sin(angle)*magnitude

        if (joystickX() == 0.0 && joystickY() == 0.0 && joystickZ() == 0.0){
            Drivetrain.stop()
        }
        else if (fieldOriented) {
            Drivetrain.driveRobotOriented(
                ChassisSpeeds.fromFieldRelativeSpeeds(
                    newY * ConfigConstants.DRIVE_SPEED,
                    newX * ConfigConstants.DRIVE_SPEED,
                    joystickZ().pow(3) * ConfigConstants.ROT_SPEED,
                    Drivetrain.getPose().rotation.minus(inputRotOffset())
                )
            )
        }
        else {
            Drivetrain.driveRobotOriented(
                ChassisSpeeds(
                    newY * ConfigConstants.DRIVE_SPEED,
                    newX * ConfigConstants.DRIVE_SPEED,
                    joystickZ().pow(3) * ConfigConstants.ROT_SPEED
                )
            )
        }
    }

    override fun isFinished(): Boolean {
        return false
    }

    override fun end(interrupted: Boolean) {
        Drivetrain.stop()
    }
}
