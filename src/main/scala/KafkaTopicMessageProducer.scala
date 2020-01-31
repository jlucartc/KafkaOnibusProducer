import java.time.Duration
import java.util.concurrent.{ArrayBlockingQueue, TimeUnit}
import java.util.{Collections, Date, Properties, Random}

import org.apache.kafka.clients.consumer.{ConsumerRecords, KafkaConsumer}
import org.apache.kafka.clients.producer.{KafkaProducer, Producer, ProducerRecord}

/*

 Remove mensagens do buffer e insere no tópico do Kafka

*/

class KafkaTopicMessageProducer(buffer : ArrayBlockingQueue[String], props: Properties, topic : String) extends Thread{
    
    override def run(): Unit ={
        
        checkBuffer()
        
    }
    
    def checkBuffer(): Unit = {
        
        val msg : String = buffer.take()
        
        publicarMensagem(msg)
        
        checkBuffer()
        
    }
    
    def publicarMensagem(msg : String) {
        
        val producer : Producer[String,String] = new KafkaProducer(props)
        
        val record : ProducerRecord[String,String] = new ProducerRecord(topic,msg)
        
        producer.send(record)
        producer.close()
        
    }
    
    
    
}
