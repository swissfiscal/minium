/*
 * Copyright (C) 2015 The Minium Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package minium.web.config;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import minium.web.config.WebDriverProperties.DimensionProperties;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebElementsConfiguration.class, properties = { "spring.main.show_banner=false" })
@ActiveProfiles("test")
public class WebDriverConfigurationTest {

    @Autowired
    private WebDriverProperties webDriverProperties;

    @Test
    public void testWebElementsDriverProperties() throws MalformedURLException {
        DesiredCapabilities expectedDesiredCapabilities = new DesiredCapabilities(BrowserType.CHROME, "39.0", Platform.LINUX);
        assertThat(new DesiredCapabilities(webDriverProperties.getDesiredCapabilities()), equalTo(expectedDesiredCapabilities));
        assertThat(webDriverProperties.isStateful(), equalTo(true));
        assertThat(webDriverProperties.getUrl(), equalTo(new URL("http://localhost:4444/wd/hub")));
        assertThat(webDriverProperties.getWindow().getSize(), equalTo(new DimensionProperties(1280, 1024)));
        assertThat(webDriverProperties.getWindow().getPosition(), nullValue());
    }
}
