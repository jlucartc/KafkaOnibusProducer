
import java.util.UUID

import org.eclipse.paho.client.mqttv3.{IMqttClient, IMqttDeliveryToken, MqttCallback, MqttClient, MqttConnectOptions, MqttException, MqttMessage, MqttSecurityException}


class MqttThread extends Thread{
    override def run(): Unit = {
        
        println("Running...")
        
        //val user : String = "bus_gps_data"
        // password : Array[Char] = "ttn-account-v2.AXVZUWtEus1MMpVF8qGf8a7jQEbkU4sUA9sM3WsGkDI".toCharArray
        //val publisher : MqttClient = new MqttClient("tcp://brazil.thethings.network:1883",UUID.randomUUID().toString);
        val publisher : MqttClient = new MqttClient("tcp://localhost:1883",UUID.randomUUID().toString);
    
        //var options = new MqttConnectOptions()
    
        //options.setUserName(user)
        //options.setPassword(password)
    
        try {
        
            //publisher.connect(options)
            publisher.connect()
        
        }catch{
        
            case e: MqttSecurityException =>
                e.printStackTrace()
            case e: MqttException =>
                println("Conection error")
                e.printStackTrace()
        
        }
    
        try {
        
            publisher.subscribe("brk")
        }catch{
        
            case e : MqttException =>
                println("Subscription error")
                e.printStackTrace()
        
        }
    
        val callback = new MqttCallback {
        
        
            @throws(classOf[Exception])
            override def messageArrived(topic: String, message: MqttMessage): Unit = {
                println("Receiving Data, Topic : %s, Message : %s".format(topic, message))
            }
        
            override def connectionLost(cause: Throwable): Unit = {
                println(cause)
            }
        
            override def deliveryComplete(token: IMqttDeliveryToken): Unit = {
            
                println("Complete")
            
            }
        }
    
        publisher.setCallback(callback)
    
    
    }
}
