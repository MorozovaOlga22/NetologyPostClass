object WallService {
    internal var posts = emptyArray<Post>()
    internal var nextPostId = 0
    internal var comments = emptyArray<CreateComment>()

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

    fun createComment(comment: CreateComment) {
        val postId = comment.postId
        for (post in posts) {
            if (post.id == postId) {
                comments += comment
                return
            }
        }
        throw PostNotFoundException(postId)
    }
}