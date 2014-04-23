/*
 * Copyright 2013 Proofpoint Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.kairosdb.client.serializer;

import com.google.gson.*;
import org.kairosdb.client.builder.DataPoint;
import org.kairosdb.client.builder.DoubleDataPoint;
import org.kairosdb.client.builder.LongDataPoint;

import java.lang.reflect.Type;

public class DataPointSerializer implements JsonSerializer<DataPoint>
{
	@Override
	public JsonElement serialize(DataPoint src, Type typeOfSrc, JsonSerializationContext context)
	{
		JsonArray array = new JsonArray();
		array.add(new JsonPrimitive(src.getTimestamp()));
		if (src instanceof LongDataPoint)
		{
			array.add(new JsonPrimitive(((LongDataPoint) src).getValue()));
		}
		else
		{
			array.add(new JsonPrimitive(((DoubleDataPoint) src).getValue()));
		}

		return array;
	}
}