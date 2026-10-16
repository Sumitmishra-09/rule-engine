package com.act21.impaktapps.rule.engine.api;

import java.io.Closeable;
import java.io.InputStream;

public interface RuleStream extends Closeable {

	public InputStream getInputStream();

}
