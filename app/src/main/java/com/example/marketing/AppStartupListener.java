package com.example.marketing;

import com.example.marketing.service.ExaminationDataGenerator;
import com.example.marketing.service.MarketingZoneDataGenerator;
import com.example.marketing.service.StoreDataGenerator;
import com.example.marketing.service.UserDataGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppStartupListener implements ApplicationListener<ApplicationReadyEvent>
{
	private final StoreDataGenerator storeDataGenerator;
	private final UserDataGenerator userDataGenerator;
	private final ExaminationDataGenerator examinationDataGenerator;
	private final MarketingZoneDataGenerator marketingZoneDataGenerator;

	@Override
	public void onApplicationEvent(@NotNull final ApplicationReadyEvent event)
	{
		log.info("Загрузка данных для базовых справочников.");

		storeDataGenerator.load();
		marketingZoneDataGenerator.load();
		userDataGenerator.load();
		examinationDataGenerator.load();

		log.info("Загрузка данных для базовых справочников завершена.");
	}
}
