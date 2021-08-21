data class PostSource(
    val type: PostSourceType,
    val platform: PostSourcePlatform?,
    val data: PostSourceData?,
    val url: String
)

enum class PostSourceType {
    Vk, Widget, Api, Rss, Sms
}

enum class PostSourcePlatform {
    Android, Iphone, Wphone
}

enum class PostSourceData {
    ProfileActivity, ProfilePhoto, Comments, Like, Poll
}