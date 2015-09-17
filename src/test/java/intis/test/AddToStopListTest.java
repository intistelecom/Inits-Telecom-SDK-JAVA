/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Intis Telecom
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddToStopListTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void addToStopList() throws AddToStopListException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        Long id = client.addToStopList("442073238000");
        System.out.println(id);
        assertNotNull(id);
    }

    @Test(expected = AddToStopListException.class)
    public void addToStopListWidthException() throws AddToStopListException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);
        Long id = client.addToStopList("442073238000");
    }

    private String getData()
    {
        return "{\"id\":4}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
