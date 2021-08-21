class BadCommentReasonException(commentId: Int, reason: UInt) :
    RuntimeException("Comment with id $commentId has reason with not allowed number $reason")