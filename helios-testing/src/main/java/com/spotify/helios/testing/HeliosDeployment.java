/*
 * Copyright (c) 2015 Spotify AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.spotify.helios.testing;

import com.spotify.helios.client.HeliosClient;

import java.net.URI;
import java.util.Set;

/**
 * This class represents a Helios cluster, i.e. master, ZooKeeper, and agent nodes.
 */
public interface HeliosDeployment extends AutoCloseable {
  /**
   * @return A helios client connected to the master(s) of this helios deployment.
   */
  HeliosClient client();

  /**
   * Returns the host and port information that the deployment is available at.
   */
  Set<URI> uris();

  /**
   * Cleanup
   */
  // TODO (dxia) Ideally we don't want this. This is only used by ExistingHeliosDeployment.
  void cleanup();

  /**
   * Undeploy (shut down) this Helios deployment.
   */
  void close();
}