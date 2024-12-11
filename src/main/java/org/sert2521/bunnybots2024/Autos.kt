package org.sert2521.bunnybots2024

import com.pathplanner.lib.auto.AutoBuilder
import com.pathplanner.lib.auto.NamedCommands
import com.pathplanner.lib.util.HolonomicPathFollowerConfig
import com.pathplanner.lib.util.PIDConstants
import com.pathplanner.lib.util.ReplanningConfig
import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sert2521.bunnybots2024.subsystems.Drivetrain

object Autos : SubsystemBase() {
    private var autoChooser = SendableChooser<Command>()
    private val defaultAutoCommand = Commands.none()

    private var commandList = mapOf<String, Command>(

    )

    init {
        AutoBuilder.configureHolonomic(
            Drivetrain::getPose,
            Drivetrain::setPose,
            Drivetrain::getRelativeSpeeds,
            Drivetrain::driveRobotOriented,
            HolonomicPathFollowerConfig(
                PIDConstants(
                    SwerveConstants.AUTO_POWER_P,
                    SwerveConstants.AUTO_POWER_I,
                    SwerveConstants.AUTO_POWER_D
                ),
                PIDConstants(
                    SwerveConstants.AUTO_ANGLE_P,
                    SwerveConstants.AUTO_ANGLE_I,
                    SwerveConstants.AUTO_ANGLE_D
                ),
                SwerveConstants.MAX_AUTO_SPEED,
                SwerveConstants.DRIVE_BASE_RADIUS,
                ReplanningConfig(
                    false,
                    true,
                    SwerveConstants.AUTO_REPLANNING_TOTAL_ERROR,
                    SwerveConstants.AUTO_REPLANNING_SPIKE
                )
            ),
            {DriverStation.getAlliance().get()==DriverStation.Alliance.Red},
            Drivetrain
        )

        NamedCommands.registerCommands(commandList)

        autoChooser=AutoBuilder.buildAutoChooser()

    }
}