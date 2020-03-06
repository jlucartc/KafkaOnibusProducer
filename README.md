# KafkaOnibusService

Projeto de serviço que conecta Kafka ao Flink, consumindo tópico e
alimentando a pipeline. Utiliza Kafka e MQTT.

## Configurando ambiente

Copie as informações presentes no arquivo `Env/envs` e cole dentro de
um arquivo `.sh` dentro de `/etc/profile.d/`, ou em outro local de sua preferência, desde
que o projeto possa detectar as variáveis em ambiente durante sua execução.

**Obs:** lembre-se de fazer log-in/log-out para que as variáveis sejam carregadas.

```
//Utilize as seguintes variáveis de ambiente para configurar os serviços:
// Crie um arquivo .sh em /etc/profile.d/ com as variáveis e faça log-out/log-in para que elas sejam carregadas

export GITHUB_JLUCARTC_BOOTSTRAP_SERVERS=
export GITHUB_JLUCARTC_KEY_SERIALIZER=
export GITHUB_JLUCARTC_VALUE_SERIALIZER=
export GITHUB_JLUCARTC_ACKS=
export GITHUB_JLUCARTC_MQTT_TOPIC=
export GITHUB_JLUCARTC_MQTT_USER=
export GITHUB_JLUCARTC_MQTT_PASSWORD=
export GITHUB_JLUCARTC_MQTT_URI=
```