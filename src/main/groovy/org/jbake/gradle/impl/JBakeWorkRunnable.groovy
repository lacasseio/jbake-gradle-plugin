/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2014-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jbake.gradle.impl

import org.apache.commons.configuration.CompositeConfiguration
import org.apache.commons.configuration.MapConfiguration
import org.gradle.api.logging.Logger
import org.gradle.api.logging.Logging
import org.jbake.app.Oven

import javax.inject.Inject

/**
 * Support for older worker API.
 *
 * Once the minimum supported Gradle version is above 5.6, we can merge JBakeWorkRunnable into JBakeWorkAction.
 */
class JBakeWorkRunnable implements Runnable {
    private static final Logger LOGGER = Logging.getLogger(JBakeWorkRunnable)
    private Oven jbake
    private final Map<String, Object> configuration
    private final File input
    private final File output
    private final boolean clearCache

    @Inject
    JBakeWorkRunnable(File input, File output, boolean clearCache, Map<String, Object> configuration) {
        this.clearCache = clearCache
        this.output = output
        this.input = input
        this.configuration = configuration
    }

    @Override
    void run() {
        jbake = new Oven(input, output, clearCache)
        jbake.setupPaths()
        mergeConfiguration()
        jbake.bake()
        List<String> errors = jbake.getErrors()
        if (errors) {
            errors.each { LOGGER.error(it) }
            throw new IllegalStateException(errors.join('\n'))
        }
    }

    private void mergeConfiguration() {
        def config = new CompositeConfiguration([createMapConfiguration(), jbake.getConfig()])
        jbake.setConfig(config)
    }

    private MapConfiguration createMapConfiguration() {
        return new MapConfiguration(configuration)
    }
}
