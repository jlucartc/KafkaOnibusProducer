sys.env.get("GITHUB_JLUCARTC_BOOTSTRAP_SERVERS") match {
    
    case Some(res) => { println(res) }

    case None => { println("None")}
    
}

sys.env.get("GITHUB_JLUCARTC_KEY_SERIALIZER") match {
    
    case Some(res) => { println(res) }
    
    case None => { println("None")}
    
}

sys.env.get("GITHUB_JLUCARTC_VALUE_SERIALIZER") match {
    
    case Some(res) => { println(res) }
    
    case None => { println("None")}
    
}

sys.env.get("GITHUB_JLUCARTC_ACKS") match {
    
    case Some(res) => { println(res) }
    
    case None => { println("None")}
    
}

sys.env.get("GITHUB_JLUCARTC_MQTT_TOPIC") match {
    
    case Some(res) => { println(res) }
    
    case None => { println("None")}
    
}

sys.env.get("GITHUB_JLUCARTC_MQTT_USER") match {
    
    case Some(res) => { println(res) }
    
    case None => { println("None")}
    
}

sys.env.get("GITHUB_JLUCARTC_MQTT_PASSWORD") match {
    
    case Some(res) => { println(res) }
    
    case None => { println("None")}
    
}

sys.env.get("GITHUB_JLUCARTC_MQTT_URI") match {
    
    case Some(res) => { println(res) }
    
    case None => { println("None")}
    
}