package com.example.marketing.service.generated;

import com.backstage.app.dict.domain.DictItem;
import com.backstage.app.dict.service.codegen.client.base.AbstractDictItem;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.geojson.GeoJsonObject;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Generated(value = "com.backstage.app.dict.service.codegen.server.generator.DictItemModelGenerator", date = "2025-02-07T12:10:23.584702+03:00[Europe/Moscow]")
@Schema(description = "Магазины")
public final class StoreDictItem implements AbstractDictItem
{
	public static final String DICT_ID = "store";

	public static final Long DICT_VERSION = 1L;

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String LOCATION = "location";

	public static final String ADDRESS = "address";

	public static final String CREATED = "created";

	public static final String UPDATED = "updated";

	public static final String DELETED = "deleted";

	public static final String DELETION_REASON = "deletionReason";

	public static final String HISTORY = "history";

	public static final String VERSION = "version";

	@Schema(description = "Идентификатор")
	private String id;

	@Schema(description = "Название")
	@NotNull
	private String name;

	@Schema(description = "Расположение")
	@NotNull
	private GeoJsonObject location;

	@Schema(description = "Адрес")
	@NotNull
	private String address;

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
	public StoreDictItem(String name, GeoJsonObject location, String address)
	{
		this.name = name;
		this.location = location;
		this.address = address;
	}

	public StoreDictItem(DictItem dictItem)
	{
		this.id = dictItem.getId();
		this.name = (String) dictItem.getData().get(NAME);
		this.location = (GeoJsonObject) dictItem.getData().get(LOCATION);
		this.address = (String) dictItem.getData().get(ADDRESS);
		this.created = dictItem.getCreated();
		this.updated = dictItem.getUpdated();
		this.deleted = dictItem.getDeleted();
		this.deletionReason = dictItem.getDeletionReason();
		this.history = dictItem.getHistory();
		this.version = dictItem.getVersion();
	}

	@Override
	public Map<String, Object> toMap()
	{
		var dataMap = new HashMap<String, Object>();
		dataMap.put(NAME, getName());
		dataMap.put(LOCATION, getLocation());
		dataMap.put(ADDRESS, getAddress());
		return dataMap;
	}
}
