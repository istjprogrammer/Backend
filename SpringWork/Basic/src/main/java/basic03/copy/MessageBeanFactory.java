package basic03.copy;

public class MessageBeanFactory {
   private MessageBeanFactory() {}
   // 공장 생성
   private static MessageBeanFactory factory = new MessageBeanFactory();
   public static MessageBeanFactory newInstance() {
      return factory;
   }
   
   public MessageBean createMessage(String nation) {
      if(nation.equals("kr")) {
         return new MessageBeanKr();
      }
      else {
         return new MessageBeanEn();
      }
   }
   
}