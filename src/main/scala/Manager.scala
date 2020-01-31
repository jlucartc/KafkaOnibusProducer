import java.util.Properties
import java.util.concurrent.ArrayBlockingQueue

class Manager extends Thread {

    private var messageBuffer : ArrayBlockingQueue[String] = new ArrayBlockingQueue[String](1000)
    
    override def run(): Unit = {
    
        val props : Properties = new Properties()
    
        props.put("bootstrap.servers","localhost:32771")
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer")
        props.put("acks","1")
    
        val topic = "placas"
        val mqttProps : Properties = new Properties()
        mqttProps.setProperty("user","luca")
        mqttProps.setProperty("password","123")
        mqttProps.setProperty("uri","tcp://localhost:1883")
        mqttProps.setProperty("topic",topic)
        
    
        val mqttSubscriber : MQTTMessageConsumer = new MQTTMessageConsumer(messageBuffer,mqttProps)
        
        val bufferConsumer : KafkaTopicMessageProducer = new KafkaTopicMessageProducer(messageBuffer,props,topic)
        
        mqttSubscriber.start()
        bufferConsumer.start()
        
    }
    
}
