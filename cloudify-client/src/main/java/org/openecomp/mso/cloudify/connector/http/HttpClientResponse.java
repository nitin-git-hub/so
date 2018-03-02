package org.openecomp.mso.cloudify.connector.http;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.openecomp.mso.cloudify.base.client.CloudifyResponse;
import org.openecomp.mso.logger.MsoLogger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class HttpClientResponse implements CloudifyResponse {

    private static MsoLogger LOGGER = MsoLogger.getMsoLogger (MsoLogger.Catalog.RA);
	
    private HttpResponse response = null;
    private String entityBody = null;

    public HttpClientResponse(HttpResponse response)
    {
        this.response = response;
        
        // Read the body so InputStream can be closed
        if (response.getEntity() == null) {
        	// No body
        	LOGGER.debug ("No Response Body");
        	return;
        }
        
		ByteArrayOutputStream responseBody = new ByteArrayOutputStream();
		try {
			response.getEntity().writeTo(responseBody);
		} catch (IOException e) {
			throw new HttpClientException ("Error Reading Response Body", e);
		}
		entityBody = responseBody.toString();
		LOGGER.debug (entityBody);
    }

    
    @Override
	public <T> T getEntity (Class<T> returnType) {
    	// Get appropriate mapper, based on existence of a root element
		ObjectMapper mapper = HttpClientConnector.getObjectMapper (returnType);

		T resp = null;
		try {
			resp = mapper.readValue(entityBody, returnType);
		} catch (Exception e) {
			throw new HttpClientException ("Caught exception in getEntity", e);
		}
		return resp;
    }

    @Override
    public <T> T getErrorEntity(Class<T> returnType) {
        return getEntity(returnType);
    }

    @Override
    public InputStream getInputStream() {
   		return new ByteArrayInputStream (entityBody.getBytes());
    }

    @Override
    public String getHeader(String name) {
        return response.getFirstHeader(name).getValue();
    }

    @Override
    public Map<String, String> headers() {
        Map<String, String> headers = new HashMap<String, String>();

        Header responseHeaders[] = response.getAllHeaders();
        for (Header h : responseHeaders) {
            headers.put(h.getName(), h.getValue());
        }

        return headers;
    }

}
