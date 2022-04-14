class Stack<T>(vararg items: T) {
    private var head: Node<T>? = null

    init {
        items.forEach { this.push(it) }
    }

    fun push(item: T) {
        val new: Node<T> = Node(item, head)
        head = new
    }
    fun pop(): T? {
        val temp: T? = head?.value
        head = head?.next
        return temp
    }
    fun isEmpty(): Boolean = (head == null)
}