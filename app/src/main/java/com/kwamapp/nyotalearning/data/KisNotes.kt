package com.kwamapp.nyotalearning.data

data class KiswNoteSection(val title: String, val content: String)

object KisNotes {
    val sections = listOf(
        KiswNoteSection(
            title = "Mofimu na Misemo",
            content = "Sehemu hii inajadili mifumo ya lugha na misemo ya Kiswahili."
        ),
        KiswNoteSection(
            title = "Fasihi",
            content = "Maelezo ya kina kuhusu fasihi ya Kiswahili."
        ),
        KiswNoteSection(
            title = "Uandishi wa Kiswahili",
            content = "Maelezo ya mbinu bora za uandishi na uchoraji kwa Kiswahili."
        )
        // Add more sections as needed
    )
}
