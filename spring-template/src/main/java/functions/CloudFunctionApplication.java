/*
 * Copyright 2026 Schwarz Digits Cloud GmbH & Co. KG
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

package functions;

import java.util.function.Function;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

@SpringBootApplication
public class CloudFunctionApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudFunctionApplication.class, args);
  }

  @Bean
  public Function<Message<String>, String> hello() {
    return inputMessage -> {
      return "Hello from STACKIT Functions";
    };
  }
}
