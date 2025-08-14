# 🎵 Web Application for Music Event Management
[![Java](https://img.shields.io/badge/Java-17-red)](https://www.oracle.com/java/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-brightgreen)](https://spring.io/projects/spring-boot)  
[![Angular](https://img.shields.io/badge/Angular-17-dd0031)](https://angular.io/)  
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)](https://www.mysql.com/)  
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

## 📌 Description
Web application developed as a Final Degree Project in Computer Engineering to improve **reservation, customer, and billing management** in the music sector, with a special focus on DJs and event companies.  
It facilitates client-company communication, streamlines event organization, and optimizes administrative control.

---

## 🚀 Features

| Role              | Functionality                                                                 |
|-------------------|-------------------------------------------------------------------------------|
| **Cliente**       | - Book events by selecting date, location, and event type.                    |
|                   | - Send booking requests with music preferences and contact details.           |
|                   | - View history of past events.                                                |
| **Administrador** | - View pending and confirmed reservations.                                    |
|                   | - Accept or reject reservations with automatic notifications.                 |
|                   | - Modify reservation details.                                                 |
|                   | - Create, edit, and delete clients.                                           |
|                   | - Create, modify, and delete invoices.                                        |
|                   | - View invoice history.      
---

## 🛠️ Technologies Used

**Backend**
- Java 17
- Spring Boot 3 (REST API, JWT Security)
- MySQL
- Maven

**Frontend**
- Angular 17
- Bootstrap

**Development Tools**
- Git / GitHub
- Postman (API testing)
- SonarQube (code quality analysis)
- Trello + Kanban (task management)

---

## 📂 Project Structure
📦 project
- ┣ 📂 backend # REST API with Spring Boot
- ┃ ┣ 📂 controllers # Controllers (endpoints)
- ┃ ┣ 📂 services # Business logic
- ┃ ┣ 📂 repositories # Data access
- ┃ ┣ 📂 models # JPA entities
- ┃ ┗ pom.xml
- ┣ 📂 frontend # Angular application
- ┃ ┣ 📂 src
- ┃ ┗ package.json
- ┗ README.md


---

## 📸 Screenshots
*(Add images of your application here so it looks great on GitHub)*  
Example:
- Admin reservations panel.
- Client creation form.
- Invoice view.

---

## 📦 Installation & Execution

### 🔹 Backend
```bash
# Clone repository
git clone <https://github.com/deeeeivid/backTfg.git>

# Enter backend folder
cd backend

# Run the application
mvn spring-boot:run

```
### 🔹 Frontend
```bash
# Enter frontend folder
cd frontend

# Install dependencies
npm install

# Run the application
ng serve

```

API: http://localhost:8080

Frontend: http://localhost:4200

--- 
### 📈 Future Improvements

📬 Automatic confirmation email sending.

📅 Interactive calendar.

🛍️ Merchandising and music store.

🎨 Visual and UX improvements.

---

### 🤝 How to Contribute

Fork the project.

Create a new branch (git checkout -b feature/new-feature).

Make your changes and commit them (git commit -m 'Add new feature').

Push to the branch (git push origin feature/new-feature).

Open a Pull Request.

---

### 📄 License

This project is licensed under the MIT License. See the LICENSE file for details.

### 📜 License Summary (MIT)

This project is open source under the MIT License.

✅ You can use, copy, modify, and distribute it, even for commercial purposes.

📌 You must keep the copyright notice and give credit to the author.

⚠️ The software is provided "as is" without any warranty — use it at your own risk.


### 💡 Developed by David Muñoz Zancada as a Final Degree Project in Computer Engineering.