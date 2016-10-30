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

public class SensorStreamDefinitionConstants {
    public static final String NAME = "name";
    public static final String VERSION = "version";
    public static final String NICKNAME = "nickName";
    public static final String DESCRIPTION = "description";
    public static final String META_DATA = "metaData";
    public static final String CORRELATION_DATA = "correlationData";
    public static final String PAYLOAD_DATA = "payloadData";
    public static final String TYPE = "type";

    public static final String DEFAULT_STREAM_DEF_NAME_PREFIX = "org.wso2.iot.devices.sensor.";
    public static final String STREAM_DEF_NAME_TAG = "\"" + NAME + "\": \"%s\",";
    public static final String STREAM_DEF_VERSION_TAG = "\"" + VERSION + "\": \"%s\",";
    public static final String STREAM_DEF_NICKNAME_TAG = "\"" + NICKNAME + "\": \"%s\",";
    public static final String STREAM_DEF_DESCRIPTION_TAG = "\"" + DESCRIPTION + "\": \"%s\",";

    public static final String STREAM_DEF_META_TAG = "\"" + META_DATA + "\": [%s]";
    public static final String STREAM_DEF_CORRELATION_TAG = "\"" + CORRELATION_DATA + "\": [%s]";
    public static final String STREAM_DEF_PAYLOAD_TAG = "\"" + PAYLOAD_DATA + "\": [%s]";
    public static final String STREAM_DEF_NAME_TYPE_PAIR = "{\"" + NAME + "\":\"%s\",\"" + TYPE + "\":\"%s\"}";
}