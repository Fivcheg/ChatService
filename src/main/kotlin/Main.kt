package ru.netology
fun main() {

    ChatService.addMessage(1, Message("hihihi", false, true))
    ChatService.addMessage(1, Message("hihihi", false, true))
    ChatService.addMessage(2, Message("asd", true, false))
    ChatService.addMessage(3, Message("aaasd", false, false))
    ChatService.addMessage(3, Message("2342aaasd", false, false))
    ChatService.printChats()
    println(ChatService.getMessages(1, 1))
    ChatService.deleteChat(2)
    ChatService.printChats()
    println(ChatService.getChats())
}