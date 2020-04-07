/*
 * Copyright (C) 2020 Yunify, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this work except in compliance with the License.
 * You may obtain a copy of the License in the LICENSE file, or at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qingstor.sdk.request;

import java.io.IOException;

/** Created by chengww on 2018/1/22. A class defined to cancel data or uploading. */
public interface CancellationHandler {

    /**
     * A sign defined to cancel data or uploading
     *
     * @return is cancelled or not
     */
    boolean isCancelled();

    class CancellationException extends IOException {
        @Override
        public String getMessage() {
            return "Request has been cancelled.";
        }
    }
}