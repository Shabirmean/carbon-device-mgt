/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.device.mgt.common.sensor.mgt;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DeviceTypeSensor implements Serializable {
    private int typeId;
    private String name;
    private SensorType sensorType;
    private String description;
    private Map<String, Object> staticProperties;
    private String streamDefinition;

    public DeviceTypeSensor() {

    }

    /**
     * Default constructor for the Sensor Object. Requires a SensorType to be passed to indicate to which family of
     * sensors (ex: Camera, GPS, Distance & etc) does this Sensor belong to. By default the stream-definition & the
     * properties of the SensorType are inherited.
     *
     * @param sensorType The SensorType of the Sensor to be created.
     */
    public DeviceTypeSensor(SensorType sensorType) {
        this.sensorType = sensorType;
        this.staticProperties = sensorType.getTypeProperties();
        this.streamDefinition = sensorType.getStreamDefinition();
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getStaticProperties() {
            return staticProperties;
    }

    public void setStaticProperties(Map<String, Object> staticProperties) {
        this.staticProperties = staticProperties;
    }

    public String getStreamDefinition() {
        return streamDefinition;
    }

    public void setStreamDefinition(String streamDefinition) {
        this.streamDefinition = streamDefinition;
    }

    /**
     *
     * @return
     */
    public Map<String, Object> getAllProperties() {
        if (this.staticProperties.keySet().equals(this.sensorType.getTypeProperties().keySet())) {
            return staticProperties;
        } else {
            Map<String, Object> aggregatedProperties = new HashMap<>();
            aggregatedProperties.putAll(staticProperties);
            aggregatedProperties.putAll(this.sensorType.getTypeProperties());
            return aggregatedProperties;
        }
    }

    /**
     * Adds a new static property relevant to the specific DeviceTypeSensor object.
     *
     * @param staticProperty The static property key to be added.
     * @param value    The value of the above newly added static-property.
     */
    public void addStaticProperty(String staticProperty, Object value) {
        this.staticProperties.put(staticProperty, value);
    }

    /**
     * Adds a new metaData property to the existing stream-definition's metaData of the DeviceTypeSensor.
     *
     * @param name The name of new MetaData to be added.
     * @param type The data-type of the newly added MetaData.
     */
    public void addMetaPropertyToStreamDefinition(String name, String type) {
        String newMetaProperty = String.format(SensorStreamDefinitionConstants.STREAM_DEF_NAME_TYPE_PAIR, name, type);
        if (streamDefinition.contains(SensorStreamDefinitionConstants.META_DATA)) {
            int metaDataEndIndex = streamDefinition.indexOf("]");

            streamDefinition = streamDefinition.substring(0, metaDataEndIndex) + "," + newMetaProperty +
                    streamDefinition.substring(metaDataEndIndex, streamDefinition.length());
        } else {
            String metaDataDefinition = String.format(
                    SensorStreamDefinitionConstants.STREAM_DEF_META_TAG, newMetaProperty);
            streamDefinition = streamDefinition + "," + metaDataDefinition;
        }
    }

    /**
     * Adds a new correlationData property to the existing stream-definition's correlationData of the DeviceTypeSensor.
     *
     * @param name The name of new correlationData to be added.
     * @param type The data-type of the newly added CorrelationData.
     */
    public void addCorrelationPropertyToStreamDefinition(String name, String type) {
        String newCorrelationProperty = String.format(
                SensorStreamDefinitionConstants.STREAM_DEF_NAME_TYPE_PAIR, name, type);
        if (streamDefinition.contains(SensorStreamDefinitionConstants.CORRELATION_DATA)) {
            int correlationDataIndex = streamDefinition.indexOf(SensorStreamDefinitionConstants.CORRELATION_DATA);
            int correlationDataEndIndex = streamDefinition.indexOf("]", correlationDataIndex);

            streamDefinition = streamDefinition.substring(0, correlationDataEndIndex) + "," + newCorrelationProperty +
                    streamDefinition.substring(correlationDataEndIndex, streamDefinition.length());
        } else {
            String correlationDataDefinition = String.format(
                    SensorStreamDefinitionConstants.STREAM_DEF_CORRELATION_TAG, newCorrelationProperty);
            streamDefinition = streamDefinition + "," + correlationDataDefinition;
        }
    }

    /**
     * Adds a new payloadData property to the existing stream-definition's payloadData of the DeviceTypeSensor.
     *
     * @param name The name of new payloadData to be added.
     * @param type The data-type of the newly added PayloadData.
     */
    public void addPayloadPropertyToStreamDefinition(String name, String type) {
        String newPayloadProperty = String.format(
                SensorStreamDefinitionConstants.STREAM_DEF_NAME_TYPE_PAIR, name, type);
        if (streamDefinition.contains(SensorStreamDefinitionConstants.PAYLOAD_DATA)) {
            int payloadDataIndex = streamDefinition.indexOf(SensorStreamDefinitionConstants.PAYLOAD_DATA);
            int payloadDataEndIndex = streamDefinition.indexOf("]", payloadDataIndex);

            streamDefinition = streamDefinition.substring(0, payloadDataEndIndex) + "," + newPayloadProperty +
                    streamDefinition.substring(payloadDataEndIndex, streamDefinition.length());
        } else {
            String payloadDataDefinition = String.format(
                    SensorStreamDefinitionConstants.STREAM_DEF_PAYLOAD_TAG, newPayloadProperty);
            streamDefinition = streamDefinition + "," + payloadDataDefinition;
        }
    }


    public static class DAOConstants {
        public static final String SENSOR_ID = "SENSOR_ID";
        public static final String SENSOR_NAME = "SENSOR_NAME";
        public static final String DEVICE_TYPE_ID = "DEVICE_TYPE_ID";
        public static final String DESCRIPTION = "DESCRIPTION";
        public static final String SENSOR_TYPE = "SENSOR_TYPE";
        public static final String STATIC_PROPERTIES = "STATIC_PROPERTIES";
        public static final String STREAM_DEFINITION = "STREAM_DEFINITION";
    }
}
