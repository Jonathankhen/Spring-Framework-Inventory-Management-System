# Spring-Framework-Inventory-Management-System

This project is a web-based inventory management system using Java and Spring Framework. It features a customized HTML interface, inventory tracking, validation, and unit tests to meet specific customer requirements.

## Introduction

I have been tasked with creating, customizing, and maintaining applications with various features and functionality based on business requirements. This project is a demonstration of my ability to customize a Spring Framework application with an HTML front-end and a Java backend.

## Project Overview

This inventory management system is designed for a customer that sells a product composed of parts. The project includes the following features:

- Customized HTML user interface
- Inventory tracking
- Validation of inventory levels
- Unit tests to ensure functionality

## Requirements

### Customization Tasks

**HTML User Interface Customization**
   - Customized the user interface to include the shop name, product names, and part names.
![image](https://github.com/Jonathankhen/Spring-Framework-Inventory-Management-System/assets/121633526/0dd39b15-fb7a-495d-b84f-fda27ff1e67b)

**About Page**
   - Added an "About" page to describe the customer's company.
   - Included navigation to and from the "About" page and the main screen.

**Sample Inventory**
   - Added a sample inventory appropriate for the chosen store.
   - Included five parts and five products in the sample inventory.
   - Ensured the sample inventory is only added when both part and product lists are empty.

**Buy Now Button**
   - Added a "Buy Now" button next to the buttons that update and delete products.
   - The button decrements the inventory of the product by one and displays a success or failure message.

**Track Maximum and Minimum Inventory**
   - Added fields to the part entity for maximum and minimum inventory.
   - Modified the sample inventory to include these fields.
   - Updated forms to include text inputs for setting maximum and minimum values.
   - Ensured inventory levels are between or at the minimum and maximum values.

**Validation**
   - Added validation to ensure inventory is within the specified range.
   - Displayed error messages for low or high inventory when adding or updating parts.

**Unit Tests**
   - Added unit tests for the maximum and minimum inventory fields in the `PartTest` class.

**Code Cleanup**
   - Removed class files for any unused validators.
