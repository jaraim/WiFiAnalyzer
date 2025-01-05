/*
 * WiFiAnalyzer
 * Copyright (C) 2015 - 2025 VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.vrem.wifianalyzer.wifi.model

private const val BSSID_LENGTH = 17

data class WiFiVirtual(val bssid: String, val frequency: Int) {
    val key: String
        get() = "$bssid-$frequency"
}

val WiFiDetail.wiFiVirtual: WiFiVirtual
    get() =
        if (BSSID_LENGTH == wiFiIdentifier.bssid.length)
            WiFiVirtual(
                this.wiFiIdentifier.bssid.substring(2, BSSID_LENGTH - 1),
                this.wiFiSignal.primaryFrequency
            )
        else
            WiFiVirtual(
                wiFiIdentifier.bssid,
                wiFiSignal.primaryFrequency
            )


