data class CreateComment(
    val ownerId: Int,
    val postId: Int,
    val fromGroup: UInt = 0u,
    val message: String?,
    val replyToComment: Int,
    val attachments: String?,
    val stickerId: UInt,
    val guid: String,
)