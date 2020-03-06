import java.util.Properties
import java.util.concurrent.ArrayBlockingQueue

class Manager extends Thread {

    private var messageBuffer : ArrayBlockingQueue[String] = new ArrayBlockingQueue[String](1000)
    
    override def run(): Unit = {
    
        val props : Properties = new Properties()
        val mqttProps : Properties = new Properties()
        
        val bootstrapServers = sys.env.get("GITHUB_JLUCARTC_BOOTSTRAP_SERVERS") match { case Some(res) => { res } case None => { "" } }
        val keySerializer = sys.env.get("GITHUB_JLUCARTC_KEY_SERIALIZER") match { case Some(res) => { res } case None => { "" } }
        val valueSerializer  = sys.env.get("GITHUB_JLUCARTC_VALUE_SERIALIZER") match { case Some(res) => { res } case None => { "" } }
        val acks = sys.env.get("GITHUB_JLUCARTC_ACKS") match { case Some(res) => { res } case None => { "" } }
        val mqttUser = sys.env.get("GITHUB_JLUCARTC_MQTT_USER") match { case Some(res) => { res } case None => { "" } }
        val mqttPassword = sys.env.get("GITHUB_JLUCARTC_MQTT_PASSWORD") match { case Some(res) => { res } case None => { "" } }
        val mqttUri = sys.env.get("GITHUB_JLUCARTC_MQTT_URI") match { case Some(res) => { res } case None => { "" } }
        val mqttTopic = sys.env.get("GITHUB_JLUCARTC_MQTT_TOPIC") match { case Some(res) => { res } case None => { "" } }
        
    
        props.put("bootstrap.servers",bootstrapServers)
        props.put("key.serializer",keySerializer)
        props.put("value.serializer",valueSerializer)
        props.put("acks",acks)

        mqttProps.setProperty("user",mqttUser)
        mqttProps.setProperty("password",mqttPassword)
        mqttProps.setProperty("uri",mqttUri)
        mqttProps.setProperty("topic",mqttTopic)
        
    
        val mqttSubscriber : MQTTMessageConsumer = new MQTTMessageConsumer(messageBuffer,mqttProps)
        
        val bufferConsumer : KafkaTopicMessageProducer = new KafkaTopicMessageProducer(messageBuffer,props,mqttTopic)
        
        mqttSubscriber.start()
        bufferConsumer.start()
        
    }
    
}
