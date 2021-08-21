abstract class Attachment(
    val type: AttachmentType
)

enum class AttachmentType {
    Photo, PostedPhoto, Audio, App, Album
}
