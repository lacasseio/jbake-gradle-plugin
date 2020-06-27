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

import org.gradle.workers.WorkAction

/**
 * Wrapper over the old worker API.
 *
 * Once the minimum supported Gradle version is above 5.6, we can merge JBakeWorkRunnable into JBakeWorkAction.
 */
abstract class JBakeWorkAction implements WorkAction<JBakeWorkActionParameters> {
    @Override
    void execute() {
        new JBakeWorkRunnable(parameters.input.get().asFile, parameters.output.get().asFile, parameters.clearCache.get(), parameters.configuration.get()).run()
    }
}