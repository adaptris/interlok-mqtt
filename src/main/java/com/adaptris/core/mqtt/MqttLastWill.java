/*
    Copyright Adaptris

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.adaptris.core.mqtt;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import com.adaptris.annotation.AdapterComponent;
import com.adaptris.annotation.AdvancedConfig;
import com.adaptris.annotation.ComponentProfile;
import com.adaptris.annotation.DisplayOrder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * MQTT connection last will
 * 
 * @config mqtt-last-will
 * @license STANDARD
 * @since 3.5.0
 */
@XStreamAlias("mqtt-last-will")
@AdapterComponent
@ComponentProfile(summary = "MQTT connection last will", tag = "connections,mqtt", since = "3.5.0")
@DisplayOrder(order = {"topic", "qos", "retained", "payload", "payloadCharEncoding"})
public class MqttLastWill {

  private static final String DEFAULT_ENCODING = "UTF-8";

  @NotNull
  private String topic;
  @Min(0)
  @Max(2)
  @AdvancedConfig
  private Integer qos = MqttConstants.QOS_DEFAULT;
  @AdvancedConfig
  private boolean retained = MqttConstants.RETAINED_DEFAULT;
  // TODO Maybe we need a message factory and encoder for this
  @NotNull
  private String payload;
  @NotNull
  private String payloadCharEncoding = DEFAULT_ENCODING;

  /**
   * The topic to publish to.
   */
  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  /**
   * The payload for the message.
   * 
   * @return payload
   */
  public String getPayload() {
    return payload;
  }

  /**
   * The payload for the message.
   * 
   * @param payload
   */
  public void setPayload(String payload) {
    this.payload = payload;
  }

  /**
   * The payload char encoding
   * 
   * @return payloadCharEncoding
   */
  public String getPayloadCharEncoding() {
    return payloadCharEncoding;
  }

  /**
   * The payload char encoding
   * 
   * @param payloadCharEncoding
   */
  public void setPayloadCharEncoding(String payloadCharEncoding) {
    this.payloadCharEncoding = payloadCharEncoding;
  }

  /**
   * The quality of service to publish the message at (0, 1 or 2).
   * 
   * @return qos
   */
  public int getQos() {
    return qos;
  }

  /**
   * The quality of service to publish the message at (0, 1 or 2).
   * 
   * @param qos
   */
  public void setQos(int qos) {
    this.qos = qos;
  }

  /**
   * Whether or not the message should be retained.
   * 
   * @return retained
   * 
   */
  public boolean getRetained() {
    return retained;
  }

  /**
   * Whether or not the message should be retained.
   * 
   * @param retained
   */
  public void setRetained(boolean retained) {
    this.retained = retained;
  }

}
