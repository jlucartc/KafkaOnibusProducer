import java.util.concurrent.ArrayBlockingQueue

class KafkaTopicProducer extends Thread {

    private var messageBuffer : ArrayBlockingQueue[String] = new ArrayBlockingQueue[String](1000)
    
    override def run(): Unit ={
        
        var mqttSubscriber : MyMQTTSubscriber = new MyMQTTSubscriber(messageBuffer)
        
        var bufferConsumer : MyBufferConsumer = new MyBufferConsumer(messageBuffer)
        
        
        
    }
    
}
