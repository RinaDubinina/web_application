### web_application
Homework for Epam Java AT
## Веб-сервис по работе с объявлениями 
<b> Пользователь может:</b>

1.	Создать объявление.
2.	Удалить объявление.
3.	Искать объявления по уникальному идентификатору.
4.	Вывести все объявления по уникальному идентификатору пользователя.

Все данные хранятся в реляционной базе данных notes, в которой содержатся две связанные таблицы person и notes. В таблице person хранятся данные всех пользователей, разместивших объявления, а именно: уникальный идентификатор (id), Имя, Фамилия, e-mail, категория (Физ. Лицо или юр. лицо). В таблице notes хранятся данные размещенных объявлений: уникальный идентификатор, уникальный идентификатор пользователя, заголовок объявления, тело объявления, категория, мобильный телефон, дата создания.

Сервис разработан по архитектуре REST, выдача данных и сохранение данных осуществляется в формате JSON.

<em> Для получения данных по пользователям посылаются следующие запросы: </em>

При <b> HTTP GET </b> запросе http://localhost:8080/api/persons/ выводятся все пользователи с их данными:
```
{
        "id": 1,
        "firstName": "Ekaterina",
        "lastName": "Dubinina",
        "email": "dubinina1es@gmail.com",
        "categoryPerson": "INDIVIDUAL"
    },
{
        "id": 2,
        "firstName": "Nikolay",
        "lastName": "Ivanov",
        "email": "ivanov.na@gmail.com",
        "categoryPerson": "INDIVIDUAL"
    },
{
        "id": 3,
        "firstName": "Sergey",
        "lastName": "Odinokov",
        "email": "electronic.ads@gmail.com",
        "categoryPerson": "COMPANY"
    },
…

```
При <b> HTTP GET </b> запросе http://localhost:8080/api/persons/id выводится пользователь с указанным id. 
Так, если необходимо узнать информацию по пользователю с id= 4, посылается запрос http://localhost:8080/api/persons/4 :
```
{
        "id": 4,
        "firstName": "Svetlana",
        "lastName": "Minina",
        "email": "nailgroup@gmail.com",
        "categoryPerson": "COMPANY"
    }
```
При <b> HTTP GET </b> запросе http://localhost:8080/api/persons/id/notes выводятся все объявления пользователя:
```
 {
        "id": 4,
        "personId": 4,
        "headline": "Nail art",
        "body": "Nail art and other services",
        "phoneNumber": "+79647870060",
        "createdDate": {
            "month": "JANUARY",
            "year": 2020,
            "dayOfYear": 13,
            "dayOfMonth": 13,
            "hour": 23,
            "minute": 22,
            "monthValue": 1,
            "nano": 192041000,
            "second": 49,
            "dayOfWeek": "MONDAY",
            "chronology": {
                "id": "ISO",
                "calendarType": "iso8601"
            }
        },
        "categoryNotes": "SERVICES"
    }
```
При <b> HTTP POST </b> запросе http://localhost:8080/api/persons/ создается пользователь, необходимо указать данные пользователя:
```
{
    "firstName": "Kira",
    "lastName": "Volkokova",
    "email": "Vvvv12@gmail.com",
    "categoryPerson": "COMPANY"
  }
```
Получаемый ответ: 
```
"Person inserted" 
```
При <b> HTTP DELETE </b> запросе http://localhost:8080/api/persons/ удаляется пользователь с указанным id:

Получаемый ответ:
```
"Person deleted"
```

<em> Если необходимо получить информацию по объявлениям посылаются следующие запросы: </em>

При <b> HTTP GET </b> запросе http://localhost:8080/api/notes/ все созданные объявления:
```
{
        "id": 1,
        "personId": 1,
        "headline": "Car for sale",
        "body": "Car for sale",
        "phoneNumber": "+79312221154",
        "createdDate": {
            "month": "JANUARY",
            "year": 2020,
            "dayOfYear": 13,
            "dayOfMonth": 13,
            "hour": 23,
            "minute": 22,
            "monthValue": 1,
            "nano": 192041000,
            "second": 49,
            "dayOfWeek": "MONDAY",
            "chronology": {
                "id": "ISO",
                "calendarType": "iso8601"
            }
        },
        "categoryNotes": "TRANSPORT"
    },
    {
        "id": 2,
        "personId": 2,
        "headline": "Full-time job",
        "body": "Looking for full-time job",
        "phoneNumber": "+791178981143",
        "createdDate": {
            "month": "JANUARY",
            "year": 2020,
            "dayOfYear": 13,
            "dayOfMonth": 13,
            "hour": 23,
            "minute": 22,
            "monthValue": 1,
            "nano": 192041000,
            "second": 49,
            "dayOfWeek": "MONDAY",
            "chronology": {
                "id": "ISO",
                "calendarType": "iso8601"
            }
        },
        "categoryNotes": "WORK"
    },
    {
        "id": 3,
        "personId": 3,
        "headline": "New laptop for sale",
        "body": "New laptop for sale and other electronics",
        "phoneNumber": "+79894467557",
        "createdDate": {
            "month": "JANUARY",
            "year": 2020,
            "dayOfYear": 13,
            "dayOfMonth": 13,
            "hour": 23,
            "minute": 22,
            "monthValue": 1,
            "nano": 192041000,
            "second": 49,
            "dayOfWeek": "MONDAY",
            "chronology": {
                "id": "ISO",
                "calendarType": "iso8601"
            }
        },
        "categoryNotes": "ELECTRONICS"
    },
…
```
При <b> HTTP GET </b> запросе http://localhost:8080/api/notes/id выводится объявление по указанному идентификатору объявления:
```
{
    "id": 4,
    "personId": 4,
    "headline": "Nail art",
    "body": "Nail art and other services",
    "phoneNumber": "+79647870060",
    "createdDate": {
        "month": "JANUARY",
        "year": 2020,
        "dayOfYear": 13,
        "dayOfMonth": 13,
        "hour": 23,
        "minute": 22,
        "monthValue": 1,
        "nano": 192041000,
        "second": 49,
        "dayOfWeek": "MONDAY",
        "chronology": {
            "id": "ISO",
            "calendarType": "iso8601"
        }
    },
    "categoryNotes": "SERVICES"
}
```
При <b> HTTP POST </b> запросе http://localhost:8080/api/notes/ создается новое объявление, необходимо указать все данные для публикации:
```
{
   "personId": "2",
   "headline": "New phone for sale",
   "body": "New phone for sale and other devices",
   "phoneNumber": "+79893014411",
    "categoryNotes": "ELECTRONICS"
}
```
Получаемый ответ:
```
"Note inserted"
```
При <b> HTTP DELETE </b> запросе http://localhost:8080/api/notes/id/ удаляется объявление  с указанным id:

Получаемый ответ:
```
"Note deleted"
```

### Создано с помощью:
•	<ins> Postgresql: </ins>
База данных была реализована посредством https://www.postgresql.org/ . 
```
URL: jdbc:postgresql://localhost:5432/note

USER=postgres
PASSWORD=1234
```
•	<ins> Maven: </ins>
Управление зависимостями, архитектура и сборка проекта.

•	<ins> Postman: </ins>
Отображение данных при тестировании запросов.


