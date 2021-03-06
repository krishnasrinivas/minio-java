/*
 * Minio Java Library for Amazon S3 Compatible Cloud Storage, (C) 2015 Minio, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.minio.examples;

import io.minio.MinioClient;
import io.minio.errors.ClientException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class RemoveObject {
  public static void main(String[] args) throws IOException, XmlPullParserException, ClientException {
    System.out.println("RemoveObject app");

    // Set s3 endpoint, region is calculated automatically
    MinioClient s3Client = new MinioClient("https://s3.amazonaws.com", "YOUR-ACCESSKEYID", "YOUR-SECRETACCESSKEY");

    // remove object
    s3Client.removeObject("mybucket", "my/object");
  }
}
