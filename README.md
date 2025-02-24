# Restaurant Review App 🍽️

A web application that allows users to review restaurants based on allergy-friendly ratings for **peanuts, eggs, and dairy**.

---

## 📌 Overview
This is a **Spring Boot** application that allows users to:
- Register and manage their profiles.
- Add restaurants with allergy-friendly ratings.
- Submit and manage reviews for restaurants.
- Retrieve and filter restaurants based on user preferences.

---

## 🚀 Features
✔ User registration and profile management  
✔ Restaurant listing and reviews  
✔ Allergy-specific restaurant ratings  
✔ Pending review management  

---

## 🛠 Tech Stack
- **Backend:** Spring Boot (Java), H2 Database, JPA, Hibernate  
- **Frontend (Optional if applicable):** React / Angular / Thymeleaf  
- **API Testing:** Postman, cURL  
- **Version Control:** Git, GitHub  

---

## 💻 Installation

### 🖥️ 1️⃣ Clone the repository
```sh
git clone https://github.com/sreebhargav/Restaurant-Review-App.git
cd Restaurant-Review-App

🔧 2️⃣ Build & Run
Using Maven
sh
Copy
Edit
mvn clean install
mvn spring-boot:run
CopyEdit
mvn clean install
mvn spring-boot:run
Using Gradle
sh
CopyEdit
./gradlew bootRun

3️⃣ API Testing
You can use Postman or cURL to interact with the API.
🔗 API Endpoints
User Endpoints
POST /users/register → Register a new user
GET /users/{displayName} → Get user details
Restaurant Endpoints
POST /restaurants → Add a restaurant
GET /restaurants/{id} → Get restaurant details
Review Endpoints
POST /reviews → Submit a review
GET /reviews/pending → Get pending reviews

📝 Usage
1️⃣ Register a user
sh
CopyEdit
curl -X POST http://localhost:8080/users/register -H "Content-Type: application/json" -d '{
    "displayName": "JohnDoe",
    "city": "New York",
    "state": "NY",
    "zipcode": "10001",
    "interestedInPeanutAllergy": true,
    "interestedInEggAllergy": false,
    "interestedInDairyAllergy": true
}'
2️⃣ Add a restaurant
sh
CopyEdit
curl -X POST http://localhost:8080/restaurants -H "Content-Type: application/json" -d '{
    "name": "Pasta Palace",
    "zipCode": "90001"
}'
3️⃣ Submit a review
sh
CopyEdit
curl -X POST http://localhost:8080/reviews -H "Content-Type: application/json" -d '{
    "restaurant": {"id": 1},
    "user": {"displayName": "JohnDoe"},
    "peanutScore": 5,
    "eggScore": 4,
    "dairyScore": 3
}'
🤝 Contributing
Pull requests are welcome. Please follow best coding practices and submit a PR.
📜 License
This project is open-source and licensed under the MIT License.
