/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2014-2019 the original author or authors.
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
package org.jbake.gradle

/**
 * Created by frank on 12.10.14.
 */
class JBakeExtension {
    String version = '2.6.4'
    String pegdownVersion = '1.6.0'
    String flexmarkVersion = '0.40.8'
    String freemarkerVersion = '2.3.29'
    String asciidoctorJavaIntegrationVersion = '0.1.4'
    String asciidoctorjVersion = '1.5.8.1'
    String groovyTemplatesVersion = '2.5.8'
    String jade4jVersion = '1.2.7'
    String thymeleafVersion = '3.0.11.RELEASE'
    String jettyVersion = '9.4.25.v20191220'
    String srcDirName = 'src/jbake'
    String destDirName = 'jbake'
    String template = 'groovy'
    String templateUrl
    boolean clearCache = false
    Map<String, Object> configuration = [:]
    boolean includeDefaultRepositories = true
}
