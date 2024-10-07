# Пример приложения "Аудит посещений супермаркетов"

## Локальная отладка
### Запуск
1. Поднять тестовое окружение.
```sh
docker-compose -f ./devops/localhost/docker/docker-compose.yml -p backstage-marketing-app up
```

2. Запустить приложение.
```sh
./gradlew bootRun
```
Эндпоинты доступны в [Swagger](http://localhost:8080/swagger-ui/index.html), метрики в [Actuator](http://localhost:8080/actuator).

3. Сгенерировать клиенты для dicts.
```sh
./gradlew app:dictsCodegen
```
После завершения задачи, в пакете com.example.marketing.service.generated появятся модели и клиенты к API dicts.

### Остановка
```sh
docker-compose -p backstage-marketing-app stop
```
