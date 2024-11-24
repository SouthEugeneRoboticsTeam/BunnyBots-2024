package org.sert2521.bunnybots2024.subsystems

import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.math.kinematics.ChassisSpeeds
import edu.wpi.first.wpilibj.Filesystem
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sert2521.bunnybots2024.ConfigConstants
import swervelib.parser.SwerveParser
import swervelib.telemetry.SwerveDriveTelemetry
import java.io.File

object Drivetrain : SubsystemBase() {
    private val swerveDir = File(Filesystem.getDeployDirectory(), "swerve")
    val swerve = SwerveParser(swerveDir).createSwerveDrive(ConfigConstants.DRIVE_SPEED)

    init {
        SwerveDriveTelemetry.verbosity = SwerveDriveTelemetry.TelemetryVerbosity.HIGH
        swerve.swerveController
    }

    fun driveRobotOriented(chassisSpeeds: ChassisSpeeds){
        swerve.drive(chassisSpeeds)
    }

    fun driveFieldOriented(fieldSpeeds: ChassisSpeeds){
        swerve.driveFieldOriented(fieldSpeeds)
    }

    fun driveHeadingSetpoint(transX:Double, transY:Double, heading:Rotation2d){
        swerve.driveFieldOriented(
            swerve.swerveController.getTargetSpeeds(
                transX,
                transY,
                heading.sin,
                heading.cos,
                swerve.yaw.radians,
                swerve.maximumVelocity
            )
        )
    }



}