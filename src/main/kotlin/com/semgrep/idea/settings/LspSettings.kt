package com.semgrep.idea.settings

import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.extensions.PluginId
import java.util.*

enum class TraceLevel {
    OFF,
    MESSAGES,
    VERBOSE,
}

data class SemgrepLspSettings(
    var trace: Trace = Trace(),
    var path: String = "",
    var ignoreCliVersion: Boolean = false,
    var scan: Scan = Scan(),
    var doHover: Boolean = false,
    var metrics: Metrics = Metrics(),
    var pro_intrafile: Boolean = false,
    var useJS: Boolean = System.getProperty("os.name").lowercase(Locale.getDefault()).contains("win"),
    var stackSizeJS: Int = 1024 * 1024,
    var heapSizeJS: Int = 4096,
) {

    fun toFlattenedMap(): Map<String, String> {
        return mapOf(
            "trace.server" to trace.server.name,
            "path" to path,
            "ignoreCliVersion" to ignoreCliVersion.toString(),
            "scan.configuration" to scan.configuration.joinToString(","),
            "scan.exclude" to scan.exclude.joinToString(","),
            "scan.include" to scan.include.joinToString(","),
            "scan.jobs" to scan.jobs.toString(),
            "scan.maxMemory" to scan.maxMemory.toString(),
            "scan.maxTargetBytes" to scan.maxTargetBytes.toString(),
            "scan.timeout" to scan.timeout.toString(),
            "scan.timeoutThreshold" to scan.timeoutThreshold.toString(),
            "scan.onlyGitDirty" to scan.onlyGitDirty.toString(),
            "doHover" to doHover.toString(),
            "metrics.machineId" to metrics.machineId,
            "metrics.isNewAppInstall" to metrics.isNewAppInstall.toString(),
            "metrics.extensionVersion" to metrics.extensionVersion,
            "metrics.extensionType" to metrics.extensionType,
            "metrics.enabled" to metrics.enabled.toString(),
            "pro_intrafile" to pro_intrafile.toString(),
            "useJS" to useJS.toString(),
            "stackSizeJS" to stackSizeJS.toString(),
            "heapSizeJS" to heapSizeJS.toString(),
        )
    }

    data class Trace(var server: TraceLevel = TraceLevel.OFF)
    data class Scan(
        var configuration: Array<String> = arrayOf(),
        var exclude: Array<String> = arrayOf(),
        var include: Array<String> = arrayOf(),
        var jobs: Int = 1,
        var maxMemory: Int = 0,
        var maxTargetBytes: Int = 1000000,
        var timeout: Int = 30,
        var timeoutThreshold: Int = 3,
        var onlyGitDirty: Boolean = true,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Scan

            if (!configuration.contentEquals(other.configuration)) return false
            if (!exclude.contentEquals(other.exclude)) return false
            if (!include.contentEquals(other.include)) return false
            if (jobs != other.jobs) return false
            if (maxMemory != other.maxMemory) return false
            if (maxTargetBytes != other.maxTargetBytes) return false
            if (timeout != other.timeout) return false
            if (timeoutThreshold != other.timeoutThreshold) return false
            if (onlyGitDirty != other.onlyGitDirty) return false

            return true
        }

        override fun hashCode(): Int {
            var result = configuration.contentHashCode()
            result = 31 * result + exclude.contentHashCode()
            result = 31 * result + include.contentHashCode()
            result = 31 * result + jobs
            result = 31 * result + maxMemory
            result = 31 * result + maxTargetBytes
            result = 31 * result + timeout
            result = 31 * result + timeoutThreshold
            result = 31 * result + onlyGitDirty.hashCode()
            return result
        }
    }

    data class Metrics(
        var machineId: String = UUID.randomUUID().toString(),
        var isNewAppInstall: Boolean = true,
        var extensionVersion: String = PluginManager.getInstance()
            .findEnabledPlugin(PluginId.findId("com.semgrep.idea")!!)?.version!!,
        var extensionType: String = "intellij",
        // sessionId cannot be generated from intellij easily
        var enabled: Boolean = true,
    )
}