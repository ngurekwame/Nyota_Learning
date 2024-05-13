package com.kwamapp.nyotalearning.data

data class BioNoteSection(val title: String, val content: String)

object BioNotes {
    val sections = listOf(
        BioNoteSection(
            title = "Cell Biology",
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                    "sunt in culpa qui officia deserunt mollit anim id est laborum."
        ),
        BioNoteSection(
            title = "Genetics",
            content = "Detailed information about genetic inheritance and DNA."
        ),
        BioNoteSection(
            title = "Ecology",
            content = "Explanation of ecosystems, food chains, and environmental interactions."
        )
        // Add more sections as needed
    )
}
