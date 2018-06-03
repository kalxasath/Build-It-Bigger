package com.udacity.gradle.builditbigger.backend;

import com.aiassoft.javalibrary.JokesProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * Modified to provide a fresh joke via the engine
     * @return
     */
    @ApiMethod(name = "apiAFreshJoke")
    public MyBean getAFreshJoke() {
        MyBean response = new MyBean();
        response.setData(JokesProvider.anotherJoke());

        return response;
    }

}
