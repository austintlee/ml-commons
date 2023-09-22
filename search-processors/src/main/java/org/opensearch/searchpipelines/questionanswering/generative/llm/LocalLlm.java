/*
 * Copyright 2023 Aryn
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
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
package org.opensearch.searchpipelines.questionanswering.generative.llm;

import java.util.List;
import java.util.Random;

public class LocalLlm implements Llm {
    @Override
    public ChatCompletionOutput doChatCompletion(ChatCompletionInput input) {

        long delay = (long) Math.floor(1000 * (4.0 + ((0.001 + new Random().nextFloat()) * 2 - 1)));
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ChatCompletionOutput(List.of("This is a dummy answer."), null);
    }
}
