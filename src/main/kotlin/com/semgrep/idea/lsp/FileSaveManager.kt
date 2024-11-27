package com.semgrep.idea.lsp

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.newvfs.BulkFileListener
import com.intellij.openapi.vfs.newvfs.events.VFileEvent
import org.eclipse.lsp4j.DidSaveTextDocumentParams
import org.eclipse.lsp4j.TextDocumentIdentifier
import java.net.URLEncoder

class FileSaveManager(private val project: Project) : BulkFileListener {
    override fun after(events: MutableList<out VFileEvent>) {
        val lspServer = SemgrepService.getRunningLspServer(project) ?: return
        val saveEvents = events.filter { it.isFromSave }
        saveEvents.forEach {
            val uri = URLEncoder.encode(it.path, "UTF-8")
            val textDocumentIdentifier = TextDocumentIdentifier(uri)
            val params = DidSaveTextDocumentParams(textDocumentIdentifier)
            lspServer.sendNotification { it.textDocumentService.didSave(params) }
        }
    }
}