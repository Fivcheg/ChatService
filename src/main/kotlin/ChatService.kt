package ru.netology

object ChatService {
    private val chats = mutableMapOf<Int, Chat>()

    fun addMessage(recepient: Int, message: Message){
        chats.getOrPut(recepient) { Chat() }.messages.add(message)
    }
    fun printChats(){
        println(chats)
    }

    fun unreadChatsCount() = chats.values.count { chat -> chat.messages.any { !it.read } }

    fun getMessages(recepient: Int, messagesCount: Int): List<Message>{
        return chats[recepient]?.messages.orEmpty().takeLast(messagesCount).onEach { it.read = true }
    }

    fun deleteMessages(recepient: Int, messageId: Int){
        chats[recepient]?.messages.orEmpty().take(messageId).onEach { it.delete = true }
        if (chats[recepient]?.messages.orEmpty().count { !it.delete } == 0) { chats.remove(recepient) }
    }
    fun deleteChat(recepient: Int){
        chats.remove(recepient)
    }
 /*   fun getChats(): MutableMap<Int, Chat>{
        return chats.onEach() { value -> value.key; value.value.messages.takeLast(1) }
    }*/

}


