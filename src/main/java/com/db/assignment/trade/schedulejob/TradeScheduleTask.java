
package com.db.assignment.trade.schedulejob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.db.assignment.trade.service.TradeService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TradeScheduleTask {

	private static final Logger log = LoggerFactory.getLogger(TradeScheduleTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	TradeService tradeService;

	@Scheduled(cron = "${update.expiry.job}")
	public void reportCurrentTime() {
		log.info("Current time of job execution: " + dateFormat.format(new Date()));
		//, dateFormat.format(new Date()));
		tradeService.updateExpiryFlag();
	}
}