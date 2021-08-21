import attachment.*
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        cleanData()
        val post = createTestPost(1234567890)
        val expectedPost = post.copy(id = 0)
        val addedPost = WallService.add(post)
        assertEquals(1234567890, post.id)
        assertEquals(0, expectedPost.id)
        assertEquals(expectedPost, addedPost)
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

        val postSource = PostSource(
            type = PostSourceType.Vk,
            platform = PostSourcePlatform.Android,
            data = null,
            url = "http://vk"
        )

        val geo = Geo(
            type = "type1",
            coordinates = "any country",
            place = null
        )

        val donut = Donut(
            isDonut = true,
            paidDuration = 1,
            placeholder = Any(),
            canPublishFreeCopy = true,
            editMode = DonutEditMode.All
        )

        val photoSize = PhotoSize(
            type = PhotoSizeType.M,
            url = "",
            width = 300,
            height = 300
        )

        val attachmentPhoto = AttachmentPhoto(
            id = 0,
            albumId = 0,
            ownerId = 0,
            userId = 0,
            text = "",
            date = 0,
            sizes = arrayOf(photoSize),
            width = 300,
            height = 300
        )

        val photo = Photo(
            photo = attachmentPhoto
        )

        val attachmentPostedPhoto = AttachmentPostedPhoto(
            id = 0,
            ownerId = 0,
            photo130 = "",
            photo604 = ""
        )

        val postedPhoto = PostedPhoto(
            postedPhoto = attachmentPostedPhoto
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
            postSource = postSource,
            attachments = arrayOf(photo, postedPhoto),
            geo = geo,
            signerId = 0,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            copyHistory = emptyArray(),
            markedAsAds = true,
            isFavorite = true,
            donut = donut,
            postponedId = 0
        )
    }
}