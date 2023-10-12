/*
 * Copyright © 2021 Vector Pro (teamvectorpro@googlegroups.com)
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
package in.vectorpro.dropwizard.swagger;


import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class TestApplication extends Application<TestConfiguration> {

  @Override
  public void initialize(Bootstrap<TestConfiguration> bootstrap) {
    bootstrap.addBundle(
        new SwaggerBundle<TestConfiguration>() {
          @Override
          protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
              TestConfiguration configuration) {
            return configuration.swaggerBundleConfiguration;
          }
        });
  }

  @Override
  public void run(TestConfiguration configuration, Environment environment) {
    environment.jersey().register(new TestResource());
  }
}
