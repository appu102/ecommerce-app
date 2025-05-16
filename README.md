# ecommerce-app
# E-Commerce Platform (Java Swing Application)

## Overview

This project is a simple desktop-based E-Commerce platform developed using **Java Swing**. It simulates a basic shopping system where users can log in, browse products with images, place orders, and view order summaries.

---

## Features

- **User Authentication**: Simple login screen for user identification.
- **Product Display**: Products are displayed with associated images, names, prices, and available stock.
- **Order Management**: Users can place orders and view their order summaries.
- **Stock Handling**: Product stock updates automatically after each successful order.
- **Graphical User Interface**: Built using Java Swing components for an interactive experience.

---

## Technologies Used

- **Programming Language**: Java (JDK 8 or higher)
- **GUI Framework**: Java Swing (`javax.swing`, `java.awt`)
- **Image Rendering**: Uses local image files for product display

---

## Folder Structure
src/
├── Product.java # Product class with details and stock management
├── User.java # User class representing logged-in user
├── Order.java # Order class representing a placed order
└── ECommerceUI.java # Main UI class to run the application and handle

---

## Running the Application

### Prerequisites

- Java Development Kit (JDK) 8 or above installed
- An IDE or command line with Java support
- All `.java` files in the same folder or properly packaged

### Compilation and Execution

1. Open terminal or command prompt in the project source directory.

2. Compile all classes:
   ```bash
   javac *.java

