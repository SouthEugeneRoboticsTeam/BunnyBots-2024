package org.sert2521.bunnybots2024

import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.wpilibj.DataLogManager
import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.smartdashboard.Field2d
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.sert2521.bunnybots2024.subsystems.Indexer
import org.sert2521.bunnybots2024.subsystems.Wrist
import java.io.File
import kotlin.math.*

object Output:SubsystemBase() {
    private val values = mutableListOf<Pair<String, () -> Double>>()
    private val bools = mutableListOf<Pair<String, () -> Boolean>>()
    private val field = Field2d()
    private val visionField = Field2d()

    init{
        //TODO: Fix this later
        val storageDevices = File("/media").listFiles()
        if (storageDevices != null) {
            if (storageDevices.isNotEmpty()) {
                DataLogManager.start(storageDevices[0].absolutePath)
                DriverStation.startDataLog(DataLogManager.getLog())
            }
        }

        bools.add(Pair("Beambreak"){ Indexer.getBeamBreak() })

        values.add(Pair("Abs Encoder"){ Wrist.getRadians() })
        values.add(Pair("Wrapped Encoder"){Wrist.getWrappedAngle()})


    }

    private fun update(){
        for (value in values) {
            SmartDashboard.putNumber(value.first, value.second())
        }

        for (bool in bools) {
            SmartDashboard.putBoolean(bool.first, bool.second())
        }

        val x = Input.getJoystickX()
        val y = Input.getJoystickY()



        var angle = atan2(y, x)
        val mult = if (x == 0.0 || y == 0.0){
            1.0
        }else if (abs(x) >= abs(y)){
            abs(cos(angle))
        } else {
            abs(sin(angle))
        }
        val magnitude = Translation2d(x, y).norm * mult
        angle = 360 * atan2(y, x) / (2 * PI) - 90

        SmartDashboard.putNumber("Joystick Angle", angle)
        SmartDashboard.putNumber("Joystick Magnitude", magnitude)

        //SmartDashboard.putData(Autos.getAutoChooser())
    }

    override fun periodic() {
        update()
    }
}