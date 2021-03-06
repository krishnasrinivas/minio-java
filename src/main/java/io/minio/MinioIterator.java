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

import io.minio.errors.ClientException;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class MinioIterator<T1> implements Iterator<T1> {
  private final List<T1> items = new LinkedList<T1>();

  public boolean hasNext() {
    try {
      populateIfEmpty();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClientException e) {
      e.printStackTrace();
    }
    return !items.isEmpty();
  }

  public T1 next() {
    try {
      populateIfEmpty();
    } catch (Exception e) {
      NoSuchElementException nse = new NoSuchElementException();
      nse.initCause(e);
    }
    if (items.isEmpty()) {
      throw new NoSuchElementException();
    }
    return items.remove(0);
  }

  @SuppressWarnings("unused")
  public void remove() {
    throw new UnsupportedOperationException();
  }

  private synchronized void populateIfEmpty() throws ClientException, IOException {
    if (items.isEmpty()) {
      List<T1> list = populate();
      this.items.addAll(list);
    }
  }

  protected abstract List<T1> populate() throws ClientException, IOException;
}
