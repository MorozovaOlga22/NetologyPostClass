package attachment

import Attachment

data class Photo(val photo: AttachmentPhoto) : Attachment(AttachmentType.Photo)

data class AttachmentPhoto(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val sizes: Array<PhotoSize>,
    val width: Int,
    val height: Int
)

data class PhotoSize(
    val type: PhotoSizeType,
    val url: String,
    val width: Int,
    val height: Int
)

enum class PhotoSizeType {
    S, M, X, O, P, Q, R, Y, Z, W
}