# Пример приложения "Аудит посещений супермаркетов"

## Локальная отладка
### Запуск
1. Поднять тестовое окружение.
```sh
docker image rm -f git.backstage-platform.ru:5050/backstage/components/dicts-ui-library
docker login git.backstage-platform.ru:5050 -u registry-viewer -p gldt-yyxxD9zddKaWD_QsbVLt
docker-compose -f ./devops/localhost/docker/docker-compose.yml -p backstage-marketing-app up
```

2. Запустить приложение.
```sh
./gradlew bootRun
```

Пользовательский интерфейс доступен по [ссылке](http://localhost/) (логин/пароль: admin/admin). Описание API доступно в [Swagger](http://localhost:8080/swagger-ui/index.html), метрики в [Actuator](http://localhost:8080/actuator).

3. Если в структуру справочников вносятся изменения, то необходимо повторно сгенерировать клиенты для dicts.
```sh
./gradlew app:dictsCodegen
```
После завершения задачи, в пакете com.example.marketing.service.generated появятся обновлённые модели и клиенты к API dicts.
Чтобы изменения отобразились в интерфейсе, перезапускаем приложение.

### Остановка
```sh
docker-compose -p backstage-marketing-app stop
```

## Скриншоты
![Список магазинов](docs/img1.png)
![Добавление новой записи](docs/img2.png)
![Фильтрация](docs/img3.png)
