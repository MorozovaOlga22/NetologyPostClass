data class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    val placeholder: Any,
    val canPublishFreeCopy: Boolean,
    val editMode: DonutEditMode
)

enum class DonutEditMode {
    All, Duration
}