# 💇‍♀️ Salon Management App (FTI)

A simple **desktop application** built using **Java Swing** to manage salon operational data, including stock management and service bookings.

_**Menu login**_
![login](img/tapbo%20login.png)

_**Menu Home**_
![home](img/tapbo%20home.png)

_**Menu Stok**_
![stok](img/tapbo%20stok.png)
_**Menu Boking**_
![stok](img/tapbo%20boking.png)
_**Menu Data Petugas**_
![stok](img/tapbo%20data%20petugas.png)
_**Menu Transaksi**_
![stok](img/tapbo%20transaksi.png)

---

## 🚀 Main Features

- **Stock Management**
  Perform Create, Read, Update, and Delete (CRUD) operations for salon inventory items.

- **Booking Management**
  Handle CRUD operations for customer bookings and queue data.

- **Automatic Numbering**
  Automatically generate IDs for items and queue numbers.

- **User-Friendly GUI**
  Intuitive graphical interface to easily manage all data.

- **Database Connection**
  Integrated with MySQL for persistent data storage.

---

## 🛠️ Tech Stack

- **Programming Language**: Java
- **GUI Framework**: Java Swing
- **Database**: MySQL
- **IDE**: Apache NetBeans 23
- **Build Tool**: Apache Ant

### External Libraries

- **MySQL Connector/J**: Connect Java app to MySQL database.
- **JCalendar**: Provide date picker component (JDateChooser).

---

## ⚙️ Prerequisites

Before running this application, make sure you have:

- **JDK** (Java Development Kit) version 11 or higher
- **Apache NetBeans IDE** version 11 or higher (recommended: 23)
- **MySQL Database Server** (can use XAMPP, WAMP, or standalone installation)

---

## 🗂️ Installation & Configuration

### 1️⃣ Database Setup

- Start Apache and MySQL servers (e.g., via XAMPP Control Panel).
- Open phpMyAdmin: [http://localhost/phpmyadmin](http://localhost/phpmyadmin).
- Create a new database named `salon`.

```sql
CREATE DATABASE salon;
```

- Select the `salon` database and import the `.sql` file containing table structures (`stok_barang`, `pembookingan`, etc.).
- _(Make sure to include this `.sql` file in your project folder, e.g., `/db`)_

### 2️⃣ Project Setup in NetBeans

- Clone or download this repository.
- Open Apache NetBeans IDE.
- Select **File > Open Project...**, then choose the downloaded project folder.
- Wait until the project is fully loaded.

### 3️⃣ Add Libraries

- In the **Projects** panel, right-click on **Libraries**.
- Select **Add JAR/Folder...**.
- Add `mysql-connector-j-8.x.x.jar`.
- Add `jcalendar-1.4.jar`.

### 4️⃣ Configure Database Connection

- Open `src/Salon/koneksi.java`.
- Check and adjust connection details:

```java
String db = "jdbc:mysql://localhost:3306/salon";
String user = "root";
String pass = "";
```

### 5️⃣ Run the Application

- Right-click the project > **Clean and Build** to ensure no compilation errors.
- After successful build, right-click again > **Run**.
- The login form or main menu should appear.

---

## 📁 Project Structure

```
/GUI
|-- src
|   |-- Salon
|   |   |-- koneksi.java         // Database connection class
|   |   |-- Login.java           // Login form
|   |   |-- stok.java           // Inventory form
|   |   |-- Pembookingan.java    // Booking form
|   |   |-- dl_data_stokbarang.java // Inventory data logic
|   |   |-- ... other Java files
|-- db
|   |-- salon.sql              // Database structure file
|-- lib
|   |-- mysql-connector-j.jar  // MySQL connector
|   |-- jcalendar.jar          // JCalendar library
|-- README.md
```

---

## 👨‍💻 Author

Created by: [pxmelki](https://github.com/pxmelki)

---

✨ Feel free to fork, customize, and use this project to learn or as part of your portfolio! Happy coding! 💻
