/*
 * Copyright 2016 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb.spark.config

/**
 * Mongo input configurations
 *
 * Configurations used when reading from MongoDB
 *
 * $inputProperties
 *
 * @see [[com.mongodb.spark.config.ReadConfig$]]
 * @since 1.0
 *
 * @define inputProperties
 *
 * == Configuration Properties ==
 *
 * The prefix when using `sparkConf` is: `spark.mongodb.input.` followed by the property name:
 *
 *  - [[databaseNameProperty database]], the database name to read data from.
 *  - [[collectionNameProperty collection]], the collection name to read data from.
 *  - [[readPreferenceNameProperty readPreference.name]], the name of the `ReadPreference` to use.
 *  - [[readPreferenceTagSetsProperty readPreference.tagSets]], the `ReadPreference` TagSets to use.
 *  - [[readConcernLevelProperty readConcern.level]], the `ReadConcern` level to use.
 *  - [[sampleSizeProperty sampleSize]], the sample size to use when inferring the schema.
 *  - [[partitionerProperty partitioner]], the name of the partitioner to use to partition the data.
 *  - [[partitionerOptionsProperty partitionerOptions]], the custom options used to configure the partitioner.
 *  - [[localThresholdProperty localThreshold]], the number of milliseconds used when choosing among multiple MongoDB servers to send a request.
 *  - [[registerSQLHelperFunctionsProperty registerSQLHelperFunctions]], register SQL helper functions allow easy querying of Bson types inside SQL queries.
 *  - [[schemaInferMapTypeEnabledProperty schemaInfer.mapTypes.enabled]], enable schema inference of MapTypes.
 *  - [[schemaInferMapTypeMinimumKeysProperty schemaInfer.mapTypes.minimumKeys]], the minimum number of keys of how large a struct must be before a MapType
 *    should be inferred.
 */
trait MongoInputConfig extends MongoCompanionConfig {

  override val configPrefix: String = "spark.mongodb.input."

  /**
   * The database name property
   */
  val databaseNameProperty: String = "database"

  /**
   * The collection name property
   */
  val collectionNameProperty: String = "collection"

  /**
   * The `ReadPreference` name property
   *
   * Default: `primary`
   * @see [[ReadPreferenceConfig]]
   */
  val readPreferenceNameProperty: String = "readPreference.name".toLowerCase

  /**
   * The `ReadPreference` tags property
   *
   * @see [[ReadPreferenceConfig]]
   */
  val readPreferenceTagSetsProperty: String = "readPreference.tagSets".toLowerCase

  /**
   * The `ReadConcern` level property
   *
   * Default: `DEFAULT`
   * @see [[ReadConcernConfig]]
   */
  val readConcernLevelProperty: String = "readConcern.level".toLowerCase

  /**
   * The sample size property
   *
   * Used when sampling data from MongoDB to determine the Schema.
   * Default: `1000`
   */
  val sampleSizeProperty: String = "sampleSize".toLowerCase

  /**
   * The partition property
   *
   * Represents the name of the partitioner to use when partitioning the data in the collection.
   * Default: `MongoDefaultPartitioner`
   */
  val partitionerProperty: String = "partitioner".toLowerCase

  /**
   * The partitioner options property
   *
   * Represents a map of options for customising the configuration of a partitioner.
   * Default: `Map.empty[String, String]`
   */
  val partitionerOptionsProperty: String = "partitionerOptions".toLowerCase

  /**
   * The localThreshold property
   *
   * The local threshold in milliseconds is used when choosing among multiple MongoDB servers to send a request.
   * Only servers whose ping time is less than or equal to the server with the fastest ping time *plus* the local threshold will be chosen.
   *
   * For example when choosing which MongoS to send a request through a `localThreshold` of 0 would pick the MongoS with the fastest ping time.
   *
   * Default: `15 ms`
   */
  val localThresholdProperty: String = MongoSharedConfig.localThresholdProperty

  /**
   * Register SQL Helper functions
   *
   * The SQL helper functions allow easy querying of Bson types inside SQL queries
   *
   * @since 1.1
   */
  val registerSQLHelperFunctions: String = "registerSQLHelperFunctions".toLowerCase()

  /**
   * The schema inference MapType enabled property
   *
   * A boolean flag to enable or disable MapType infer.
   * If this flag is enabled, large compatible struct types will be inferred to a MapType instead.
   *
   * Default: `true`
   */
  val schemaInferMapTypeEnabledProperty: String = "schemaInfer.mapTypes.enabled".toLowerCase

  /**
   * The schema inference MapType minimum keys property
   *
   * The minimum keys property controls how large a struct must be before a MapType should be inferred.
   *
   * Default: `250`
   */
  val schemaInferMapTypeMinimumKeysProperty: String = "schemaInfer.mapTypes.minimumKeys".toLowerCase

}
