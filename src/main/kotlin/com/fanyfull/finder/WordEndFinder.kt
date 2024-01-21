package com.fanyfull.finder

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.fanyfull.KeyTagsGenerator
import com.fanyfull.MarksCanvas
import com.fanyfull.UserConfig
import kotlin.math.abs

private val pattern = Regex("(?i)\\w\\b")

class WordEndFinder: Finder {
    // 获取 Logger 实例，参数是当前类的 KClass 对象
    companion object {
        private val LOG = Logger.getInstance(WordEndFinder::class.java)
    }

    override fun start(e: Editor, s: String, visibleRange: TextRange): List<MarksCanvas.Mark> {
        val cOffset = e.caretModel.offset
        val offsets = pattern.findAll(s)
            .map { it.range.first + visibleRange.startOffset }
            .sortedBy { abs(it - cOffset) }
            .toList()

        val tags = KeyTagsGenerator.createTagsTree(offsets.size, UserConfig.getDataBean().characters)

        return offsets.zip(tags)
            .map { MarksCanvas.Mark(it.second, it.first) }
            .toList()
    }

    override fun input(e: Editor, c: Char, lastMarks: List<MarksCanvas.Mark>): List<MarksCanvas.Mark> {
        return advanceMarks(c, lastMarks)
    }
}
