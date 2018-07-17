/*
Copyright 2017 The Nuclio Authors.

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

package io.nuclio;

import java.util.Map;
import java.util.Date;

public interface Event {
    /**
     * Event ID
     *
     * @return Event ID
     */
    String getID();

    /**
     * Trigger information
     *
     * @return Information about trigger
     */
    TriggerInfo getTriggerInfo();

    /**
     * Event Content type
     *
     * @return Event content type (e.g. "text/plain")
     */
    String getContentType();

    /**
     * Event body
     *
     * @return Event body
     */
    byte[] getBody();

    /**
     * Event body
     *
     * @return Event body
     */
    Object getBodyObject();

    /**
     * Event header
     *
     * @param key Header name (case insensitive)
     * @return Event header value
     */
    Object getHeader(String key);

    /**
     * Event header string
     *
     * @param key Header name (case insensitive)
     * @return Event header value
     */
    String getHeaderString(String key);

    /**
     * Event header bytes
     *
     * @param key Header name (case insensitive)
     * @return Event header value
     */
    byte[] getHeaderBytes(String key);

    /**
     * Event header long
     *
     * @param key Header name (case insensitive)
     * @return Event header value
     */
    long getHeaderLong(String key);

    /**
     * Event headers
     *
     * @return All event headers
     */
    Map<String, Object> getHeaders();

    /**
     * Event field
     *
     * @param key Field name
     * @return Event field value
     */
    Object getField(String key);

    /**
     * Event field
     *
     * @param key Field name
     * @return Event field value
     */
    String getFieldString(String key);

    /**
     * Event field
     *
     * @param key Field name
     * @return Event field value
     */
    byte[] getFieldBytes(String key);

    /**
     * Event field
     *
     * @param key Field name
     * @return Event field value
     */
    long getFieldLong(String key);

    /**
     * Event fields
     *
     * @return All event fields
     */
    Map<String, Object> getFields();

    /**
     * Event timestamp
     *
     * @return Event timestamp (UTC)
     */
    Date getTimestamp();

    /**
     * Event path
     *
     * @return Event path (e.g. "/api/event")
     */
    String getPath();

    /**
     * Event URL
     *
     * @return Event URL (e.g. "http://nuclio.io")
     */
    String getURL();

    /**
     * Event method
     *
     * @return Event method (e.g. "POST")
     */
    String getMethod();

    /**
     * Shard ID
     *
     * @return the ID of the shard from which this event arrived, if applicable
     */
    long getShardID();

    /**
     * Total number of shards
     *
     * @return The total number of shards, if applicable
     */
    long getTotalNumShards();

    /**
     * Event type
     *
     * @return Event type
     */
    String getType();

    /**
     * Event type version
     *
     * @return Event type version
     */
    String getTypeVersion();

    /**
     * Event version
     *
     * @return Event version
     */
    String getVersion();
}
