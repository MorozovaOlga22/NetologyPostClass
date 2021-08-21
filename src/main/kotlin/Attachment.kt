sealed class Attachment(
    val type: AttachmentType
)

enum class AttachmentType {
    Photo, PostedPhoto, Audio, App, Album
}

/** Album */
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

/** App */
data class App(val app: AttachmentApp) : Attachment(AttachmentType.App)

data class AttachmentApp(
    val id: Int,
    val name: String,
    val photo130: String,
    val photo604: String
)

/** Audio */
data class Audio(val audio: AttachmentAudio) : Attachment(AttachmentType.Audio)

data class AttachmentAudio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val date: Int,
    val noSearch: Boolean,
    val isHq: Boolean
)

/** Photo */
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

/** PostedPhoto */
data class PostedPhoto(val postedPhoto: AttachmentPostedPhoto) : Attachment(AttachmentType.PostedPhoto)

data class AttachmentPostedPhoto(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
)