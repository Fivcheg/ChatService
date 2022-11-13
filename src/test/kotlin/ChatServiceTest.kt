import org.junit.Before
import org.junit.Test
import ru.netology.ChatService
import ru.netology.Message
import java.lang.IndexOutOfBoundsException

class ChatServiceTest{
    @Before
    fun clearBeforeTest() {
        ChatService.clear()
    }
    @Test
    fun addMessageTrue() {
        ChatService.addMessage(1, Message("hihihi", false, true))
    }
    @Test
    fun printChatsTrue() {
        ChatService.printChats()
    }
    @Test
    fun getChatsTrue(){
        ChatService.addMessage(1, Message("hihihi", false, true))
        ChatService.addMessage(1, Message("hihihi", false, true))
        ChatService.addMessage(2, Message("asd", true, false))
        ChatService.addMessage(3, Message("aaasd", false, false))
        ChatService.addMessage(3, Message("2342aaasd", false, false))
        ChatService.getChats()
    }
    @Test(expected = IndexOutOfBoundsException::class)
    fun getChatsThrow(){
        ChatService.addMessage(1, Message("hihihi", false, true))
        ChatService.addMessage(1, Message("hihihi", false, true))
        ChatService.addMessage(3, Message("aaasd", false, false))
        ChatService.addMessage(3, Message("2342aaasd", false, false))
        ChatService.getChats()
    }
    @Test
    fun getMessagesTrue(){
        ChatService.addMessage(1, Message("hihihi", false, true))
        ChatService.addMessage(1, Message("hihihi", false, true))
        ChatService.addMessage(3, Message("aaasd", false, false))
        ChatService.getMessages(1, 1)
    }


}