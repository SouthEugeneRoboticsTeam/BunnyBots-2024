package org.sert2521.bunnybots2024

import edu.wpi.first.hal.FRCNetComm.tInstances
import edu.wpi.first.hal.FRCNetComm.tResourceType
import edu.wpi.first.hal.HAL
import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj.util.WPILibVersion
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.CommandScheduler
import org.sert2521.bunnybots2024.commands.SetWrist
import org.sert2521.bunnybots2024.subsystems.Drivetrain
import kotlin.math.*

/**
 * The VM is configured to automatically run this object (which basically functions as a singleton class),
 * and to call the functions corresponding to each mode, as described in the TimedRobot documentation.
 * This is written as an object rather than a class since there should only ever be a single instance, and
 * it cannot take any constructor arguments. This makes it a natural fit to be an object in Kotlin.
 *
 * If you change the name of this object or its package after creating this project, you must also update
 * the `Main.kt` file in the project. (If you use the IDE's Rename or Move refactorings when renaming the
 * object or package, it will get changed everywhere.)
 */
object Robot : TimedRobot()
{

    private var autonomousCommand: Command? = null


    init {
        Input
        Drivetrain
        Output
        Autos
    }
    override fun robotInit()
    {
        // Report the use of the Kotlin Language for "FRC Usage Report" statistics
        HAL.report(tResourceType.kResourceType_Language, tInstances.kLanguage_Kotlin, 0, WPILibVersion.Version)
        // Access the RobotContainer object so that it is initialized. This will perform all our
        // button bindings, and put our autonomous chooser on the dashboard.
    }


    override fun robotPeriodic()
    {
        CommandScheduler.getInstance().run()
    }

    override fun disabledInit()
    {

    }

    override fun disabledPeriodic()
    {

    }

    override fun autonomousInit()
    {
        Autos.getAuto().schedule()
    }

    override fun autonomousPeriodic()
    {

    }

    override fun teleopInit()
    {
        SetWrist(PhysicalConstants.WRIST_STOW_POSITION)
    }

    /** This method is called periodically during operator control.  */
    override fun teleopPeriodic()
    {

    }

    override fun testInit()
    {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll()
    }

    override fun testPeriodic()
    {

    }

    override fun simulationInit()
    {

    }

    override fun simulationPeriodic()
    {

    }
}