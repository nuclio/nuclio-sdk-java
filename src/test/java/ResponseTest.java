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

import io.nuclio.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

public class ResponseTest {
    private long statusCode = 207;
    private String contentType = "application/json";
    private String body = "test body";
    private static Map<String, Object> headers;

    @BeforeAll
    static void setUp() {
        ResponseTest.headers = new HashMap<String, Object>();
        ResponseTest.headers.put("h1", "v1");
        ResponseTest.headers.put("h2", 2);
    }

    @Test
    void testCreate() throws Throwable {
        Response resp = new Response()
                .setHeaders(this.headers)
                .setBody(this.body)
                .setStatusCode(this.statusCode)
                .setContentType(this.contentType);

        assertEquals(this.statusCode, resp.getStatusCode());
        assertEquals(this.body, new String(resp.getBody(), "UTF-8"));
        assertEquals(this.contentType, resp.getContentType());
        assertTrue(this.headers.equals(resp.getHeaders()));
    }

    @Test
    void testCreateDefaults() {
        Response resp = new Response();

        assertEquals("text/plain", resp.getContentType());
        assertEquals(200, resp.getStatusCode());
        assertEquals(0, resp.getBody().length);
        assertEquals(0, resp.getHeaders().size());

    }
}
