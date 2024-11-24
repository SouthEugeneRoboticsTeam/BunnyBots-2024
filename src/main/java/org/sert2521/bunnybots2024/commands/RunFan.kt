package org.sert2521.bunnybots2024.commands

import org.sert2521.bunnybots2024.ConfigConstants
import org.sert2521.bunnybots2024.subsystems.Fan

class RunFan {

    private val fanSpeed = ConfigConstants.FAN_RUN_SPEED

    override fun initialize() {
        Fan.setFanSpeed(fanSpeed)
    }

    override fun end () {
        Fan.stopFan()
    }

    override fun isFinished (): Boolean {
        return false
    }
}