create table store['Магазины']
(
	name['Название'] 								text 		    not null,
	location['Расположение']						geo_json	    not null,
    address['Адрес']								text	        not null,
	area['Площадь, м2']								decimal,
	actualized['Дата актуализации']					timestamp,
	details['Дополнительные атрибуты']				json
);

create table marketingZone['Зона внутри магазина']
(
	name['Название'] 								text 		    not null
);

create table user['Пользователи']
(
	name['Имя'] 								    text 		    not null
);

alter table user set writePermission = 'ADMIN';

create enum userStatus['Статус пользователя'] for user as ('ACTIVE', 'DISABLED');
alter table user add column status					userStatus		not null	default 'ACTIVE';

create table examination['Проверки']
(
    store['Магазин']						        text		    not null	references store,
    marketingZone['Зона внутри магазина']			text		    not null	references marketingZone,
    user['Пользователь']                			text		    not null	references user,
    timestamp['Время проверки']                     timestamp       not null,
    photos['Фото']                                  attachment[]
);
