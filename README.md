# 📡 API-автотесты для СОГАЗ (Java + REST Assured + TestNG)

Автоматизация API-тестирования для страховой компании СОГАЗ.

## 🛠️ Стек
- Java 17
- REST Assured
- TestNG
- Allure
- Lombok
- Maven

## 🚀 Запуск
```bash
mvn clean test
mvn allure:serve
📁 Структура

```
client/     # AuthClient, PolicyClient, TravelClient
config/     # ApiConfig
dto/        # Запросы и ответы
tests/      # AuthApiTest, PolicyApiTest, TravelApiTest
utils/      # LoginDataProvider
```

📌 Что тестируется

· ✅ Авторизация (позитивные и негативные сценарии)
· ✅ Расчёт страховки для путешествий
· ✅ Поиск полиса по номеру

👤 Автор

Татьяна — инженер по автоматизации тестирования
