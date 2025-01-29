create table store['Магазины']
(
	name['Название'] 								text 		    not null,
    latitude['Широта']      					    decimal		    not null,
    longitude['Долгота']      					    decimal		    not null,
    address['Адрес']        	                    text	        not null
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

create table examination['Проверки']
(
    store['Магазин']						        text		    not null	references store,
    marketingZone['Зона внутри магазина']			text		    not null	references marketingZone,
    user['Пользователь']                			text		    not null	references user,
    timestamp['Время проверки']                     timestamp       not null,
    photos['Фото']                                  attachment[]
);
