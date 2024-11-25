package org.sert2521.bunnybots2024.subsystems

import edu.wpi.first.math.geometry.Pose2d
import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.math.kinematics.ChassisSpeeds
import edu.wpi.first.wpilibj.Filesystem
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.sert2521.bunnybots2024.ConfigConstants
import org.sert2521.bunnybots2024.limelightlib.LimelightHelpers
import swervelib.parser.SwerveParser
import swervelib.telemetry.SwerveDriveTelemetry
import java.io.File

object Drivetrain : SubsystemBase() {
    private val swerveDir = File(Filesystem.getDeployDirectory(), "swerve")
    val swerve = SwerveParser(swerveDir).createSwerveDrive(ConfigConstants.DRIVE_SPEED)

    val tx = LimelightHelpers.getTX("")
    val ty = LimelightHelpers.getTY("")
    val ta = LimelightHelpers.getTA("")

    val hasTarget = LimelightHelpers.getTV("")

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

    fun driveHeadingSetpoint(inputX:Double, inputY:Double, heading:Rotation2d){
        swerve.driveFieldOriented(
            swerve.swerveController.getTargetSpeeds(
                inputX,
                inputY,
                heading.sin,
                heading.cos,
                swerve.yaw.radians,
                swerve.maximumVelocity
            )
        )
    }

    fun getVisionEstimate(): Pose2d{
        LimelightHelpers.SetRobotOrientation(
            "limelight",
            swerve.swerveDrivePoseEstimator.estimatedPosition.rotation.degrees,
            0.0,
            swerve.pitch.degrees,
            0.0,
            swerve.roll.degrees,
            0.0
        )

    }

    fun configureVision(){

    }



}