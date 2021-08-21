package attachment

import Attachment

data class Album(val album: AttachmentAlbum) : Attachment(AttachmentType.Album)

data class AttachmentAlbum(
    val id: Int,
    val thumb: AttachmentPhoto,
    val ownerId: Int,
    val title: String,
    val description: String,
    val created: Int,
    val updated: Int,
    val size: Int
)