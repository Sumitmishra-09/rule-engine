package com.act21.impaktapps.rule.engine.cache;

import java.util.Objects;

public class GridIdentifier {

	private String name;
	private Long version;

	public GridIdentifier(String name, Long version) {

		this.name = name;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GridIdentifier other = (GridIdentifier) obj;
		return Objects.equals(name, other.name) && Objects.equals(version, other.version);
	}

}
