data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int?,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comment,
    val copyright: Copyright,
    val likes: Like,
    val reposts: Repost,
    val views: View,
    val postType: PostType,
    val postSource: PostSource?,
    val attachments: Array<Attachment>,
    val geo: Geo,
    val signerId: Int?,
    val copyHistory: Array<Any>?,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut,
    val postponedId: Int?
)

enum class PostType {
    Post, Copy, Reply, Postpone, Suggest
}