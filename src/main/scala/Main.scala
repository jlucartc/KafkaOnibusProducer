object Main {
    
    def main(args : Array[String]): Unit ={
        
        val mqtt = new MqttThread()
        mqtt.start()
        
    }
    
}
