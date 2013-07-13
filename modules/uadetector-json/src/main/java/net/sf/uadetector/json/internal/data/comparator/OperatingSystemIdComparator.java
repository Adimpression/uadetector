/*******************************************************************************
 * Copyright 2013 André Rouél
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.sf.uadetector.json.internal.data.comparator;

import javax.annotation.Nonnull;

import net.sf.uadetector.internal.data.domain.OperatingSystem;
import net.sf.uadetector.internal.util.CompareNullSafe;

public final class OperatingSystemIdComparator extends CompareNullSafe<OperatingSystem> {

	private static final long serialVersionUID = -4818486187666820059L;

	public static int compareId(@Nonnull final OperatingSystem b1, @Nonnull final OperatingSystem b2) {
		final int id1 = b1.getId();
		final int id2 = b2.getId();
		return (id1 < id2 ? -1 : (id1 == id2 ? 0 : 1));
	}

	@Override
	public int compareType(@Nonnull final OperatingSystem b1, @Nonnull final OperatingSystem b2) {
		return compareId(b1, b2);
	}

}
