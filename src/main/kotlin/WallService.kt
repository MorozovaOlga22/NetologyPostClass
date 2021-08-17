object WallService {
    internal var posts = emptyArray<Post>()
    internal var nextPostId = 0

    fun add(post: Post): Post {
        val updatedPost = post.copy(id = nextPostId++)
        posts += updatedPost
        return updatedPost
    }

    fun update(post: Post): Boolean {
        for ((index, oldPost) in posts.withIndex()) {
            if (oldPost.id == post.id) {
                val updatedPost = post.copy(ownerId = oldPost.ownerId, date = oldPost.date)
                posts[index] = updatedPost
                return true
            }
        }
        return false
    }
}