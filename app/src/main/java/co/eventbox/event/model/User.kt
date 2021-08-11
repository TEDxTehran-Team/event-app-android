package co.eventbox.event.model

data class User(
    var name: String?,
    var phone: String?,
    var interested: String?,
    var story: String?,
    var email: String?,
    var university: String?,
    var job: String?
    ) {
    companion object{
        fun toUser() = User ("", "", "", "", "","", "")
    }
    }
