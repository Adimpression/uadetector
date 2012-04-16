/*******************************************************************************
 * Copyright 2012 André Rouél
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
package net.sf.uadetector;

/**
 * {@code UserAgent} is an immutable entity that represents the informations
 * about web-based client applications like Web browsers, search engines or
 * crawlers (spiders) as well as mobile phones, screen readers and braille
 * browsers.
 * 
 * @author André Rouél
 */
public final class UserAgent implements ReadableUserAgent {

	public static final class Builder implements ReadableUserAgent {

		private String family = EMPTY.family;

		private String name = EMPTY.name;

		private OperatingSystem operatingSystem = OperatingSystem.EMPTY;

		private String producer = EMPTY.producer;

		private String producerUrl = EMPTY.producerUrl;

		private String type = EMPTY.type;

		private String url = EMPTY.url;

		public UserAgent build() {
			return new UserAgent(family, name, operatingSystem, producer, producerUrl, type, url);
		}

		@Override
		public String getFamily() {
			return family;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public OperatingSystem getOperatingSystem() {
			return operatingSystem;
		}

		@Override
		public String getProducer() {
			return producer;
		}

		@Override
		public String getProducerUrl() {
			return producerUrl;
		}

		@Override
		public String getType() {
			return type;
		}

		@Override
		public String getUrl() {
			return url;
		}

		public Builder setFamily(final String family) {
			if (family == null) {
				throw new IllegalArgumentException("Argument 'family' must not be null.");
			}
			this.family = family;
			return this;
		}

		public Builder setName(final String name) {
			if (name == null) {
				throw new IllegalArgumentException("Argument 'name' must not be null.");
			}
			this.name = name;
			return this;
		}

		public Builder setOperatingSystem(final OperatingSystem operatingSystem) {
			if (operatingSystem == null) {
				throw new IllegalArgumentException("Argument 'operatingSystem' must not be null.");
			}
			this.operatingSystem = operatingSystem;
			return this;
		}

		public Builder setOperatingSystem(final ReadableOperatingSystem os) {
			if (os == null) {
				throw new IllegalArgumentException("Argument 'os' must not be null.");
			}
			this.operatingSystem = new OperatingSystem(os.getFamily(), os.getName(), os.getProducer(), os.getProducerUrl(), os.getUrl());
			return this;
		}

		public Builder setProducer(final String producer) {
			if (producer == null) {
				throw new IllegalArgumentException("Argument 'producer' must not be null.");
			}
			this.producer = producer;
			return this;
		}

		public Builder setProducerUrl(final String producerUrl) {
			if (producerUrl == null) {
				throw new IllegalArgumentException("Argument 'producerUrl' must not be null.");
			}
			this.producerUrl = producerUrl;
			return this;
		}

		public Builder setType(final String type) {
			if (type == null) {
				throw new IllegalArgumentException("Argument 'type' must not be null.");
			}
			this.type = type;
			return this;
		}

		public Builder setUrl(final String url) {
			if (url == null) {
				throw new IllegalArgumentException("Argument 'url' must not be null.");
			}
			this.url = url;
			return this;
		}

	}

	public static final UserAgent EMPTY = new UserAgent("unknown", "unknown", OperatingSystem.EMPTY, "", "", "", "");

	private final String family;

	private final String name;

	private final OperatingSystem operatingSystem;

	private final String producer;

	private final String producerUrl;

	private final String type;

	private final String url;

	public UserAgent(final String family, final String name, final OperatingSystem operatingSystem, final String producer,
			final String producerUrl, final String type, final String url) {

		if (family == null) {
			throw new IllegalArgumentException("Argument 'family' must not be null.");
		}
		if (name == null) {
			throw new IllegalArgumentException("Argument 'name' must not be null.");
		}
		if (operatingSystem == null) {
			throw new IllegalArgumentException("Argument 'operatingSystem' must not be null.");
		}
		if (producer == null) {
			throw new IllegalArgumentException("Argument 'producer' must not be null.");
		}
		if (producerUrl == null) {
			throw new IllegalArgumentException("Argument 'producerUrl' must not be null.");
		}
		if (type == null) {
			throw new IllegalArgumentException("Argument 'type' must not be null.");
		}
		if (url == null) {
			throw new IllegalArgumentException("Argument 'url' must not be null.");
		}

		this.family = family;
		this.name = name;
		this.operatingSystem = operatingSystem;
		this.producer = producer;
		this.producerUrl = producerUrl;
		this.type = type;
		this.url = url;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final UserAgent other = (UserAgent) obj;
		if (!family.equals(other.family)) {
			return false;
		}
		if (!name.equals(other.name)) {
			return false;
		}
		if (!operatingSystem.equals(other.operatingSystem)) {
			return false;
		}
		if (!producer.equals(other.producer)) {
			return false;
		}
		if (!producerUrl.equals(other.producerUrl)) {
			return false;
		}
		if (!type.equals(other.type)) {
			return false;
		}
		if (!url.equals(other.url)) {
			return false;
		}
		return true;
	}

	@Override
	public String getFamily() {
		return family;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}

	@Override
	public String getProducer() {
		return producer;
	}

	@Override
	public String getProducerUrl() {
		return producerUrl;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + family.hashCode();
		result = prime * result + name.hashCode();
		result = prime * result + operatingSystem.hashCode();
		result = prime * result + producer.hashCode();
		result = prime * result + producerUrl.hashCode();
		result = prime * result + type.hashCode();
		result = prime * result + url.hashCode();
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("UserAgent [family=");
		builder.append(family);
		builder.append(", name=");
		builder.append(name);
		builder.append(", operatingSystem=");
		builder.append(operatingSystem);
		builder.append(", producer=");
		builder.append(producer);
		builder.append(", producerUrl=");
		builder.append(producerUrl);
		builder.append(", type=");
		builder.append(type);
		builder.append(", url=");
		builder.append(url);
		builder.append("]");
		return builder.toString();
	}

}
