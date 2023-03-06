package com.koonny.appcompat.core

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Build

class AppVersion(val versionCode: Long, val versionName: String)

val Context.appVersion: AppVersion
    get() {
        return try {
            val packageInfo: PackageInfo
            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> {
                    packageInfo = applicationContext.packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0))
                    AppVersion(packageInfo.longVersionCode, packageInfo.versionName)
                }
                Build.VERSION.SDK_INT in Build.VERSION_CODES.P until Build.VERSION_CODES.TIRAMISU -> {
                    packageInfo = applicationContext.packageManager.getPackageInfo(packageName, 0)
                    AppVersion(packageInfo.longVersionCode, packageInfo.versionName)
                }
                else -> {
                    packageInfo = applicationContext.packageManager.getPackageInfo(packageName, 0)
                    AppVersion(packageInfo.versionCode.toLong(), packageInfo.versionName)
                }
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            AppVersion(0, "")
        }
    }

val Context.isDarkMode: Boolean
    get() = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES