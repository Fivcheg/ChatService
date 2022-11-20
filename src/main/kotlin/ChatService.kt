package ru.netology

object ChatService {
    private var chats = mutableMapOf<Int, Chat>()
    fun clear() {
        chats = mutableMapOf()
    }

    fun addMessage(recepient: Int, message: Message) =
        chats.getOrPut(recepient) { Chat() }.messages.add(message)


    fun printChats() {
        println(chats)
    }

    fun unreadChatsCount() = chats.values.asSequence().count { chat -> chat.messages.any { !it.read } }

    fun getMessages(recepient: Int, messagesCount: Int): List<Message> =
        chats
            .filter { it.key == recepient }
            .values
            .asSequence()
            .map { it.messages }
            .take(messagesCount)
            .ifEmpty { throw ChatNotFoundError() }
            .last()
            .onEach { it.read = true }

    fun deleteMessages(recepient: Int, messageId: Int) {
        chats
            .filter { it.key == recepient }
            .values
            .asSequence()
            .map { it.messages }
            .take(messageId)
            .ifEmpty { throw MessageNotFoundError() }
            .last()
            .onEach { it.delete = true }
            .count { !it.delete }
            .takeIf { it == 0 }
            ?: run {
                chats.remove(recepient)
            }
    }

    fun deleteChat(recepient: Int) {
        chats.remove(recepient)
    }

    fun getChats() = chats
        .values
        .asSequence()
        .map { it.messages[0] }
        //.forEach(::println)

    class ChatNotFoundError : Exception("Чат не найден!")
    class MessageNotFoundError : Exception("Сообщение не найдено!")

}



