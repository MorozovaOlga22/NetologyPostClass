package attachment

import Attachment

data class App(val app: AttachmentApp) : Attachment(AttachmentType.App)

data class AttachmentApp(
    val id: Int,
    val name: String,
    val photo130: String,
    val photo604: String
)