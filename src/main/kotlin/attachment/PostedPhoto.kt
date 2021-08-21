package attachment

import Attachment

data class PostedPhoto(val postedPhoto: AttachmentPostedPhoto) : Attachment(AttachmentType.PostedPhoto)

data class AttachmentPostedPhoto(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
)