package org.springframework.batch.jsr.chunk;

import java.io.Serializable;
import java.util.List;

import javax.batch.api.chunk.ItemWriter;
import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class LogEntryItemWriter implements ItemWriter {

	@Autowired
	public DataSource dataSource;
	private JdbcBatchItemWriter jdbcBatchItemWriter;

	@Override
	public void open(Serializable checkpoint) throws Exception {
		jdbcBatchItemWriter = new JdbcBatchItemWriter();
		jdbcBatchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider());
		jdbcBatchItemWriter.setSql("INSERT INTO logEntry (ip_address, requested_url, country_code, view_date) VALUES(:ipAddress, :requestedUrl, :countryCode, :viewDate)");
		jdbcBatchItemWriter.setDataSource(dataSource);
		jdbcBatchItemWriter.afterPropertiesSet();
	}

	@Override
	public void close() throws Exception {
	}

	@Override
	public void writeItems(List<Object> items) throws Exception {
		jdbcBatchItemWriter.write(items);
	}

	@Override
	public Serializable checkpointInfo() throws Exception {
		return null;
	}
}
