package ch.taggiasco.mail

import javax.mail._
import javax.mail.internet._
import javax.mail.search._
import java.util.Properties


object Mail {
  
  // copied from https://alvinalexander.com/scala/scala-imaps-ssl-email-client-javamail-yahoo-gmail
  
  def main(args: Array[String]) {

    val props = System.getProperties()
    props.setProperty("mail.store.protocol", "imaps")
    val session = Session.getDefaultInstance(props, null)
    val store = session.getStore("imaps")
    try {
      // use imap.gmail.com for gmail
      store.connect("imap.mail.yahoo.com", "<al@yahoo.com>", "password")
      val inbox = store.getFolder("Inbox")
      inbox.open(Folder.READ_ONLY)
      
      // limit this to 20 message during testing
      val messages = inbox.getMessages()
      val limit = 20
      var count = 0
      for (message <- messages) {
        count = count + 1
        if (count > limit) System.exit(0)
        println(message.getSubject())
      }
      inbox.close(true)
    } catch {
      case e: NoSuchProviderException =>  e.printStackTrace()
                                          System.exit(1)
      case me: MessagingException =>      me.printStackTrace()
                                          System.exit(2)
    } finally {
      store.close()
    }
  }
}
