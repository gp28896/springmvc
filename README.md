

![Java](https://img.shields.io/badge/Java-8+-orange)
![Spring MVC](https://img.shields.io/badge/Spring-MVC-brightgreen)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-blue)
![Maven](https://img.shields.io/badge/Build-Maven-red)
![License](https://img.shields.io/badge/License-Educational-lightgrey)

A full-stack **Java Spring MVC web application** implementing a basic e-commerce system with user roles, product listings, cart management, and PDF invoice generation.

---

## 🚀 Features

- 👤 User Authentication (Buyer / Seller roles)
- 🛍️ Advert (Product) Management
- 🗂️ Category Management with validation
- 🛒 Shopping Cart functionality
- 🧾 PDF Invoice generation (iText)
- 📧 Email notification on registration
- 🔐 Session-based authentication with interceptor

---

## 🖼️ Screenshots

> 📌 Replace these with actual screenshots from your app

### 🏠 Home Page
![Home](https://via.placeholder.com/900x400?text=Home+Page)

### 🔐 Login / Register
![Login](https://via.placeholder.com/900x400?text=Login+Page)

### 📦 Advert Listing
![Adverts](https://via.placeholder.com/900x400?text=Advert+List)

### 🛒 Cart View
![Cart](https://via.placeholder.com/900x400?text=Shopping+Cart)

### 🧾 Invoice PDF
![Invoice](https://via.placeholder.com/900x400?text=PDF+Invoice)

---

## 🏗️ Tech Stack

| Layer        | Technology |
|-------------|-----------|
| Backend     | Java, Spring MVC |
| ORM         | Hibernate |
| Frontend    | JSP, JSTL |
| Build Tool  | Maven |
| Database    | MySQL |
| Logging     | Log4j |
| PDF Engine  | iText |
| Email       | Apache Commons Email |

---

---

## ⚙️ Setup & Installation

### ✅ Prerequisites

- Java 8+
- Maven
- MySQL
- Apache Tomcat

---

### 📥 Clone Repo

```bash
git clone <your-repo-url>
cd naam

## ⚙️ Configure Database

Update `hibernate.cfg.xml`:

```xml
<property name="connection.url">jdbc:mysql://localhost:3306/your_db</property>
<property name="connection.username">root</property>
<property name="connection.password">password</property>

```🔨 Build
mvn clean install

```🚀 Deploy

WAR file:
target/naam-1.0.0-BUILD-SNAPSHOT.war

Deploy to: <TOMCAT_HOME>/webapps/

Run: http://localhost:8080/naam


## 🔑 Core Modules

### 👤 User Module
- Register (with email confirmation)
- Login / Logout
- Role-based navigation

### 📦 Advert Module
- Create adverts
- Upload product images
- Assign categories

### 🛒 Cart Module
- Add items to cart
- Persist per user

### 🧾 Billing Module
- Generate PDF invoice
- SHA-1 transaction hash
