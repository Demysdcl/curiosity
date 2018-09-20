package jetpack.training.com.model

open class Curiosity(val photos: List<Photo>) {
    constructor() : this(ArrayList<Photo>())
}

open class CuriosityError(val msg: String) : Curiosity()