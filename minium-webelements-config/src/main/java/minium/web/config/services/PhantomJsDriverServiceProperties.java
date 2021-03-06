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
package minium.web.config.services;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.phantomjs.PhantomJSDriverService.Builder;
import org.openqa.selenium.remote.service.DriverService;

public class PhantomJsDriverServiceProperties extends DriverServiceProperties {
    private File driverExecutable;
    private File ghostDriver;
    private Integer port;
    private Map<String, String> environment;
    private File logFile;
    private Map<String, Object> proxy;
    private String[] commandLineArguments;
    private String[] ghostDriverCommandLineArguments;

    public File getDriverExecutable() {
        return driverExecutable;
    }

    public void setDriverExecutable(File driverExecutable) {
        this.driverExecutable = driverExecutable;
    }

    public File getGhostDriver() {
        return ghostDriver;
    }

    public void setGhostDriver(File ghostDriver) {
        this.ghostDriver = ghostDriver;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Map<String, String> getEnvironment() {
        return environment;
    }

    public void setEnvironment(Map<String, String> environment) {
        this.environment = environment;
    }

    public File getLogFile() {
        return logFile;
    }

    public void setLogFile(File logFile) {
        this.logFile = logFile;
    }

    public Map<String, Object> getProxy() {
        return proxy;
    }

    public void setProxy(Map<String, Object> proxy) {
        this.proxy = proxy;
    }

    public String[] getCommandLineArguments() {
        return commandLineArguments;
    }

    public void setCommandLineArguments(String[] commandLineArguments) {
        this.commandLineArguments = commandLineArguments;
    }

    public String[] getGhostDriverCommandLineArguments() {
        return ghostDriverCommandLineArguments;
    }

    public void setGhostDriverCommandLineArguments(String[] ghostDriverCommandLineArguments) {
        this.ghostDriverCommandLineArguments = ghostDriverCommandLineArguments;
    }

    @Override
    public DriverService createDriverService() {
        Builder builder = new PhantomJSDriverService.Builder();

        if (driverExecutable != null) builder.usingPhantomJSExecutable(driverExecutable);
        if (ghostDriver != null) builder.usingGhostDriver(ghostDriver);
        if (port != null) builder.usingPort(port);
        if (environment != null) builder.withEnvironment(environment);
        if (logFile != null) builder.withLogFile(logFile);
        if (proxy != null) builder.withProxy(new Proxy(proxy));
        if (commandLineArguments != null) builder.usingCommandLineArguments(commandLineArguments);
        if (ghostDriverCommandLineArguments != null) builder.usingGhostDriverCommandLineArguments(ghostDriverCommandLineArguments);

        return builder.build();
    }
}
