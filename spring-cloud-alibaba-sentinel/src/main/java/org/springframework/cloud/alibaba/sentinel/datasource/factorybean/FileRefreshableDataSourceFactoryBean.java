package org.springframework.cloud.alibaba.sentinel.datasource.factorybean;

import java.io.File;
import java.nio.charset.Charset;

import org.springframework.beans.factory.FactoryBean;

import com.alibaba.csp.sentinel.datasource.ConfigParser;
import com.alibaba.csp.sentinel.datasource.FileRefreshableDataSource;

/**
 * @author fangjian
 * @see FileRefreshableDataSource
 */
public class FileRefreshableDataSourceFactoryBean
		implements FactoryBean<FileRefreshableDataSource> {

	private String file;
	private String charset;
	private long recommendRefreshMs;
	private int bufSize;
	private ConfigParser configParser;

	@Override
	public FileRefreshableDataSource getObject() throws Exception {
		return new FileRefreshableDataSource(new File(file), configParser,
				recommendRefreshMs, bufSize, Charset.forName(charset));
	}

	@Override
	public Class<?> getObjectType() {
		return FileRefreshableDataSource.class;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public long getRecommendRefreshMs() {
		return recommendRefreshMs;
	}

	public void setRecommendRefreshMs(long recommendRefreshMs) {
		this.recommendRefreshMs = recommendRefreshMs;
	}

	public int getBufSize() {
		return bufSize;
	}

	public void setBufSize(int bufSize) {
		this.bufSize = bufSize;
	}

	public ConfigParser getConfigParser() {
		return configParser;
	}

	public void setConfigParser(ConfigParser configParser) {
		this.configParser = configParser;
	}
}
