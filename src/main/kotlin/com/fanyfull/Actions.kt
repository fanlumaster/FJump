package com.fanyfull

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.DumbAwareAction

abstract class BaseAction : DumbAwareAction() {
    override fun update(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR)
        e.presentation.isEnabled = editor != null
    }

    override fun actionPerformed(e: AnActionEvent) {
        JumpHandler.start(getMode(), e)
    }

    abstract fun getMode(): Int
}

class FJumpAction : BaseAction() {
    override fun getMode() = JumpHandler.MODE_CHAR1
}

class Char2Action : BaseAction() {
    override fun getMode() = JumpHandler.MODE_CHAR2
}

/**
 * Jump to start of any word on visible screen
 */
class Word0Action : BaseAction() {
    override fun getMode() = JumpHandler.MODE_WORD0
}

class Word1Action : BaseAction() {
    override fun getMode() = JumpHandler.MODE_WORD1
}

class LineAction : BaseAction() {
    override fun getMode() = JumpHandler.MODE_LINE
}

class GotoDeclarationWord1Action : BaseAction() {
    override fun getMode() = JumpHandler.MODE_WORD1_DECLARATION
}

/**
 * Jump to start of any word on visible screen
 */
class WordEndAction : BaseAction() {
    override fun getMode() = JumpHandler.MODE_WORD_END
}
