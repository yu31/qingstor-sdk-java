/*
 * Copyright (C) 2021 Yunify, Inc.
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
package com.qingstor.sdk.service;

import com.qingstor.sdk.annotation.ParamAnnotation;
import com.qingstor.sdk.common.OperationContext;
import com.qingstor.sdk.common.auth.Credentials;
import com.qingstor.sdk.config.ClientConfiguration;
import com.qingstor.sdk.config.EnvContext;
import com.qingstor.sdk.exception.QSException;
import com.qingstor.sdk.model.OutputModel;
import com.qingstor.sdk.model.RequestInputModel;
import com.qingstor.sdk.request.QSRequest;
import com.qingstor.sdk.request.RequestHandler;
import com.qingstor.sdk.request.ResponseCallBack;
import com.qingstor.sdk.service.Types.*;
import java.util.List;

/**
 * QingStorService: QingStor provides low-cost and reliable online storage service with unlimited
 * storage space, high read and write performance, high reliability and data safety, fine-grained
 * access control, and easy to use API.
 */
public class QingStor {
    private String zone;
    private Credentials cred;
    private ClientConfiguration clientCfg;

    public QingStor(EnvContext envContext, String zone) {
        this.cred = envContext;
        this.clientCfg = ClientConfiguration.from(envContext);
        this.zone = zone;
    }

    public QingStor(EnvContext envContext) {
        this.cred = envContext;
        this.clientCfg = ClientConfiguration.from(envContext);
    }

    public Bucket getBucket(String bucketName, String zone) {
        return new Bucket(this.cred, this.clientCfg, zone, bucketName);
    }

    /**
     * @param input input
     * @throws QSException exception
     * @return ListBucketsOutput output stream Documentation URL: <a
     *     href="https://docs.qingcloud.com/qingstor/api/service/get.html">
     *     https://docs.qingcloud.com/qingstor/api/service/get.html </a>
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public ListBucketsOutput listBuckets(ListBucketsInput input) throws QSException {
        if (input == null) {
            input = new ListBucketsInput();
        }

        RequestHandler requestHandler = this.listBucketsRequest(input);

        OutputModel backModel = requestHandler.send();
        if (backModel != null) {
            return (ListBucketsOutput) backModel;
        }
        return null;
    }

    /**
     * @param input input
     * @throws QSException exception
     * @return RequestHandler http request handler Documentation URL: <a
     *     href="https://docs.qingcloud.com/qingstor/api/service/get.html">https://docs.qingcloud.com/qingstor/api/service/get.html</a>
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public RequestHandler<ListBucketsOutput> listBucketsRequest(ListBucketsInput input)
            throws QSException {
        if (input == null) {
            input = new ListBucketsInput();
        }

        OperationContext.OperationContextBuilder builder = OperationContext.builder();
        builder.clientCfg(this.clientCfg)
                .zone(this.zone)
                .credentials(this.cred)
                .operationName("ListBuckets")
                .apiName("ListBuckets")
                .serviceName("Get Service")
                .reqMethod("GET")
                .subSourcePath("/");

        RequestHandler<ListBucketsOutput> requestHandler =
                QSRequest.getRequest(builder.build(), input, ListBucketsOutput.class);

        return requestHandler;
    }

    /**
     * @param input input
     * @param callback response callback
     * @throws QSException exception
     *     <p>Documentation URL: <a
     *     href="https://docs.qingcloud.com/qingstor/api/service/get.html">https://docs.qingcloud.com/qingstor/api/service/get.html</a>
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void listBucketsAsync(
            ListBucketsInput input, ResponseCallBack<ListBucketsOutput> callback)
            throws QSException {
        if (input == null) {
            input = new ListBucketsInput();
        }

        RequestHandler requestHandler = this.listBucketsAsyncRequest(input, callback);

        requestHandler.sendAsync();
    }

    /**
     * @param input the input
     * @param callback response callback
     * @throws QSException exception
     * @return RequestHandler http request handler Documentation URL: <a
     *     href="https://docs.qingcloud.com/qingstor/api/service/get.html">https://docs.qingcloud.com/qingstor/api/service/get.html</a>
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public RequestHandler<ListBucketsOutput> listBucketsAsyncRequest(
            ListBucketsInput input, ResponseCallBack<ListBucketsOutput> callback)
            throws QSException {
        if (input == null) {
            input = new ListBucketsInput();
        }

        OperationContext.OperationContextBuilder builder = OperationContext.builder();
        builder.clientCfg(this.clientCfg)
                .zone(this.zone)
                .credentials(this.cred)
                .operationName("ListBuckets")
                .apiName("ListBuckets")
                .serviceName("Get Service")
                .reqMethod("GET")
                .subSourcePath("/");

        if (callback == null) {
            throw new QSException("callback can't be null");
        }

        RequestHandler<ListBucketsOutput> requestHandler =
                QSRequest.getRequestAsync(
                        builder.build(), input, callback, ListBucketsOutput.class);
        return requestHandler;
    }
    /**
     * ListBucketsInput: an input stream of the bucket.<br>
     * The following is the description of fields.<br>
     * These fields are headers or bodies of the http request.<br>
     * field Location Limits results to buckets that in the location <br>
     * field Limit Results count limit <br>
     * field Offset Limit results to keys that start at this offset <br>
     */
    public static class ListBucketsInput extends RequestInputModel {

        /** Results count limit */
        private Integer limit;

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        @ParamAnnotation(paramType = "query", paramName = "limit")
        public Integer getLimit() {
            return this.limit;
        }
        /** Limit results to keys that start at this offset */
        private Integer offset;

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        @ParamAnnotation(paramType = "query", paramName = "offset")
        public Integer getOffset() {
            return this.offset;
        }

        /** Limits results to buckets that in the location */
        private String location;

        public void setLocation(String location) {
            this.location = location;
        }

        @ParamAnnotation(paramType = "header", paramName = "location")
        public String getLocation() {
            return this.location;
        }

        @Override
        public String validateParam() {

            return null;
        }
    }

    /**
     * ListBucketsOutput: an output stream of the bucket.<br>
     * The following is the desc of fields.<br>
     * These fields are headers or bodies of the http request.<br>
     * field Location Limits results to buckets that in the location <br>
     * field Limit Results count limit <br>
     * field Offset Limit results to keys that start at this offset <br>
     */
    public static class ListBucketsOutput extends OutputModel {

        /** Buckets information */
        private List<BucketModel> buckets;

        public void setBuckets(List<BucketModel> buckets) {
            this.buckets = buckets;
        }

        @ParamAnnotation(paramType = "element", paramName = "buckets")
        public List<BucketModel> getBuckets() {
            return this.buckets;
        }
        /** Bucket count */
        private Integer count;

        public void setCount(Integer count) {
            this.count = count;
        }

        @ParamAnnotation(paramType = "element", paramName = "count")
        public Integer getCount() {
            return this.count;
        }
    }
}
