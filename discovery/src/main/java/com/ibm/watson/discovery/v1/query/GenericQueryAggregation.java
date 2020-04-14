package com.ibm.watson.discovery.v1.query;

import com.ibm.watson.discovery.v1.model.QueryAggregation;

/**
 * Catch-all class for query aggregations which can't be identified and deserialized to a known
 * class.
 *
 * @deprecated This class is no longer necessary with the built-in deserialization logic in the
 *     QueryAggregation class.
 */
public class GenericQueryAggregation extends QueryAggregation {}
