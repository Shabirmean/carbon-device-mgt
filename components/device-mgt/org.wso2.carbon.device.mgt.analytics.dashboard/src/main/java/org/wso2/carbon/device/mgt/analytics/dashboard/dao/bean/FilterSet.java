/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * you may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.device.mgt.analytics.dashboard.dao.bean;

public class FilterSet {

    private String connectivityStatus;
    private String potentialVulnerability;
    private String platform;
    private String ownership;

    public String getConnectivityStatus() {
        return connectivityStatus;
    }

    public void setConnectivityStatus(String connectivityStatus) {
        this.connectivityStatus = connectivityStatus;
    }

    public String getPotentialVulnerability() {
        return potentialVulnerability;
    }

    public void setPotentialVulnerability(String potentialVulnerability) {
        this.potentialVulnerability = potentialVulnerability;
    }

    public String getPlatform() {
        return platform;
    }

    @SuppressWarnings("unused")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOwnership() {
        return ownership;
    }

    @SuppressWarnings("unused")
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

}