import java.time.Duration
import java.util.concurrent.{ArrayBlockingQueue, TimeUnit}
import java.util.{Collections, Date, Properties, Random}

import org.apache.kafka.clients.consumer.{ConsumerRecords, KafkaConsumer}
import org.apache.kafka.clients.producer.{KafkaProducer, Producer, ProducerRecord}

class MyBufferConsumer(var buffer : ArrayBlockingQueue[String]) extends Thread{
    
    override def run(): Unit ={
        
        checkBuffer()
        
    }
    
    def checkBuffer(): Unit = {
        
        val msg : String = buffer.take()
        
        publicarMensagem(msg)
        
        checkBuffer()
        
    }
    
    def publicarMensagem(msg : String) {
        
        var props : Properties = new Properties()
        
        props.put("bootstrap.servers","localhost:9092")
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer")
        props.put("acks","1")
        
        var i = 0
        
        var rand : Random = new Random()
        
        var tuplas : Array[(String,Int)] = Array(("A",5),("B",1),("C",2),("D",10),("E",5),("F",6),("G",15),("H",9),("I",10),("J",20))
        
        while(true){
            
            val rand = new Random()
            
            val placa = placas(rand.nextInt(9))
            
            Thread.sleep(10)
            
            //var placa = gerarPlaca()
            
            val producer : Producer[String,String] = new KafkaProducer(props)
            
            val date = new Date()
            //var timestamp = new Timestamp(date.getTime())
            
            val record : ProducerRecord[String,String] = new ProducerRecord("placas",placa.toString+";1")
            
            producer.send(record)
            producer.close()
            
            println("Placa produzida: "+placa)
            
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(10)*10)
            
        }
        
    }
    
    
    
}
