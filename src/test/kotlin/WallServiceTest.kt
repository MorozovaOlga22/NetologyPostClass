import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        cleanData()
        assertEquals(0, WallService.posts.size)
        WallService.add(createTestPost(0))
        assertEquals(1, WallService.posts.size)
    }

    @Test
    fun update_withExistId() {
        cleanData()
        WallService.add(createTestPost(0))
        WallService.add(createTestPost(1))
        WallService.add(createTestPost(2))
        val isUpdated = WallService.update(createTestPost(0))
        assertTrue(isUpdated)
    }

    @Test
    fun update_withNotExistId() {
        cleanData()
        WallService.add(createTestPost(0))
        WallService.add(createTestPost(1))
        WallService.add(createTestPost(2))
        val isUpdated = WallService.update(createTestPost(4))
        assertFalse(isUpdated)
    }

    private fun cleanData() {
        WallService.posts = emptyArray()
        WallService.nextPostId = 0
    }

    private fun createTestPost(id: Int): Post {
        val comment = Comment(
            count = 3,
            canPost = true,
            groupsCanPost = true,
            canClose = true,
            canOpen = true
        )

        val copyright = Copyright(
            id = 0,
            link = "http://link1",
            name = "name",
            type = "type1"
        )

        val like = Like(
            count = 10,
            userLikes = true,
            canLike = true,
            canPublish = false
        )

        val repost = Repost(
            count = 5,
            userReposted = false
        )

        val view = View(
            count = 20
        )

        val donut = Donut(
            isDonut = true,
            paidDuration = 1,
            placeholder = Any(),
            canPublishFreeCopy = true,
            editMode = DonutEditMode.All
        )

        return Post(
            id = id,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = 0,
            text = "anyText",
            replyOwnerId = 0,
            replyPostId = 0,
            friendsOnly = false,
            comments = comment,
            copyright = copyright,
            likes = like,
            reposts = repost,
            views = view,
            postType = PostType.Post,
            signerId = 0,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            donut = donut,
            postponedId = 0
        )
    }
}