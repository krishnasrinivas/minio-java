/*
 * Minio Java Library for Amazon S3 Compatible Cloud Storage, (C) 2015 Minio, Inc.
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

package io.minio;

import java.util.Date;

@SuppressWarnings("unused")
public class ObjectStat {
  private final String bucket;
  private final String key;
  private final Date createdTime;
  private final long length;
  private final String md5sum;
  private final String contentType;

  public ObjectStat(String bucket, String name, Date createdTime, long length, String md5sum, String contentType) {
    this.bucket = bucket;
    this.key = name;
    this.contentType = contentType;
    this.createdTime = (Date) createdTime.clone();
    this.length = length;
    this.md5sum = md5sum.replaceAll("\"", "");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ObjectStat that = (ObjectStat) o;

    if (length != that.length) {
      return false;
    }    
    if (!bucket.equals(that.bucket)) {
      return false;
    }
    if (!key.equals(that.key)) {
      return false;
    }
    if (!createdTime.equals(that.createdTime)) {
      return false;
    }
    if (!md5sum.equals(that.md5sum)) {
      return false;
    }
    return contentType.equals(that.contentType);

  }

  @Override
  public int hashCode() {
    int result = bucket.hashCode();
    result = 31 * result + key.hashCode();
    result = 31 * result + createdTime.hashCode();
    result = 31 * result + (int) (length ^ (length >>> 32));
    result = 31 * result + md5sum.hashCode();
    result = 31 * result + contentType.hashCode();
    return result;
  }

  public String getKey() {
    return key;
  }

  public Date getCreatedTime() {
    return (Date) createdTime.clone();
  }

  public long getLength() {
    return length;
  }

  public String getBucket() {
    return bucket;
  }

  public String getMd5sum() {
    return md5sum;
  }

  @Override
  public String toString() {
    return "ObjectStat{"
        + "bucket='"
        + bucket
        + '\''
        + ", key='"
        + key + '\''
        + ", contentType='"
        + contentType
        + '\''
        + ", createdTime="
        + createdTime
        + ", length="
        + length
        + ", md5sum='"
        + md5sum
        + '\''
        + '}';
  }
}
