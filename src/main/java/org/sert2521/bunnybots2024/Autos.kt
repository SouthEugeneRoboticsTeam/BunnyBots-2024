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
import org.sert2521.bunnybots2024.PhysicalConstants.WRIST_INTAKE_POSITION
import org.sert2521.bunnybots2024.PhysicalConstants.WRIST_STOW_POSITION
import org.sert2521.bunnybots2024.commands.IndexerOuttake
import org.sert2521.bunnybots2024.commands.IntakeRun
import org.sert2521.bunnybots2024.commands.SetWrist
import org.sert2521.bunnybots2024.commands.VisionStopDrive
import org.sert2521.bunnybots2024.subsystems.Drivetrain

object Autos : SubsystemBase() {
    private var autoChooser = SendableChooser<Command>()
    private val defaultAutoCommand = Commands.none()

    private var commandList = mapOf<String, Command>(
        "outtake" to IndexerOuttake(),
        "wrist intake position" to SetWrist(WRIST_INTAKE_POSITION),
        "wrist stow position" to SetWrist(WRIST_STOW_POSITION),
        "stop at tote" to VisionStopDrive(),
        "intake" to IntakeRun()
    )

    init {
        AutoBuilder.configureHolonomic(
            Drivetrain::getPose,
            Drivetrain::setPose,
            Drivetrain::getRelativeSpeeds,
            Drivetrain::driveRobotOriented,
            HolonomicPathFollowerConfig(
                PIDConstants(
                    AutoConstants.AUTO_POWER_P,
                    AutoConstants.AUTO_POWER_I,
                    AutoConstants.AUTO_POWER_D
                ),
                PIDConstants(
                    AutoConstants.AUTO_ANGLE_P,
                    AutoConstants.AUTO_ANGLE_I,
                    AutoConstants.AUTO_ANGLE_D
                ),
                AutoConstants.MAX_AUTO_SPEED,
                AutoConstants.DRIVE_BASE_RADIUS,
                ReplanningConfig(
                    false,
                    true,
                    AutoConstants.AUTO_REPLANNING_TOTAL_ERROR,
                    AutoConstants.AUTO_REPLANNING_SPIKE
                )
            ),
            {DriverStation.getAlliance().get()==DriverStation.Alliance.Red},
            Drivetrain
        )

        NamedCommands.registerCommands(commandList)

        autoChooser=AutoBuilder.buildAutoChooser()

    }
}