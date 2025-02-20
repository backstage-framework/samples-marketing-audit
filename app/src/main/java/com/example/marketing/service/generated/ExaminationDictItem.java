package com.example.marketing.service.generated;

import com.backstage.app.dict.domain.DictItem;
import com.backstage.app.dict.service.codegen.client.base.AbstractDictItem;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@Generated(value = "com.backstage.app.dict.service.codegen.server.generator.DictItemModelGenerator", date = "2025-02-20T12:07:50.047211+03:00[Europe/Moscow]")
@Schema(description = "Проверки")
public final class ExaminationDictItem implements AbstractDictItem
{
	public static final String DICT_ID = "examination";

	public static final Long DICT_VERSION = 1L;

	public static final String ID = "id";

	public static final String STORE = "store";

	public static final String MARKETING_ZONE = "marketingZone";

	public static final String USER = "user";

	public static final String TIMESTAMP = "timestamp";

	public static final String PHOTOS = "photos";

	public static final String CREATED = "created";

	public static final String UPDATED = "updated";

	public static final String DELETED = "deleted";

	public static final String DELETION_REASON = "deletionReason";

	public static final String HISTORY = "history";

	public static final String VERSION = "version";

	@Schema(description = "Идентификатор")
	private String id;

	@Schema(description = "Магазин")
	@NotNull
	private String store;

	@Schema(description = "Зона внутри магазина")
	@NotNull
	private String marketingZone;

	@Schema(description = "Пользователь")
	@NotNull
	private String user;

	@Schema(description = "Время проверки")
	@NotNull
	private LocalDateTime timestamp;

	@Schema(description = "Фото")
	private List<String> photos;

	@Schema(description = "Дата создания")
	@NotNull
	private LocalDateTime created;

	@Schema(description = "Дата обновления")
	@NotNull
	private LocalDateTime updated;

	@Schema(description = "Дата удаления")
	private LocalDateTime deleted;

	@Schema(description = "Причина удаления")
	private String deletionReason;

	@Schema(description = "История изменений")
	@NotNull
	private List<Map<String, Object>> history;

	@Schema(description = "Версия")
	@NotNull
	private Long version;

	@Builder
	public ExaminationDictItem(String store, String marketingZone, String user, LocalDateTime timestamp, List<String> photos)
	{
		this.store = store;
		this.marketingZone = marketingZone;
		this.user = user;
		this.timestamp = timestamp;
		this.photos = photos;
	}

	@SuppressWarnings("unchecked")
	public ExaminationDictItem(DictItem dictItem)
	{
		this.id = dictItem.getId();
		this.store = (String) dictItem.getData().get(STORE);
		this.marketingZone = (String) dictItem.getData().get(MARKETING_ZONE);
		this.user = (String) dictItem.getData().get(USER);
		this.timestamp = (LocalDateTime) dictItem.getData().get(TIMESTAMP);
		this.photos = new ArrayList<>((List<String>) Objects.requireNonNullElse(dictItem.getData().get(PHOTOS), List.of()));
		this.created = dictItem.getCreated();
		this.updated = dictItem.getUpdated();
		this.deleted = dictItem.getDeleted();
		this.deletionReason = dictItem.getDeletionReason();
		this.history = dictItem.getHistory();
		this.version = dictItem.getVersion();
	}

	public StoreDictItem fetchStore(StoreDictItemService itemService)
	{
		return itemService.getById(getStore());
	}

	public MarketingZoneDictItem fetchMarketingZone(MarketingZoneDictItemService itemService)
	{
		return itemService.getById(getMarketingZone());
	}

	public UserDictItem fetchUser(UserDictItemService itemService)
	{
		return itemService.getById(getUser());
	}

	@Override
	public Map<String, Object> toMap()
	{
		var dataMap = new HashMap<String, Object>();
		dataMap.put(STORE, getStore());
		dataMap.put(MARKETING_ZONE, getMarketingZone());
		dataMap.put(USER, getUser());
		dataMap.put(TIMESTAMP, getTimestamp());
		dataMap.put(PHOTOS, getPhotos());
		return dataMap;
	}
}
