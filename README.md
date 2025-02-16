# **Java Programming Assignment**

## **Overview**

This repository contains solutions for Java programming assignments related to associative tables, a phone book application, prime number calculations using multithreading, and the dining philosophers problem.

## **Table of Contents**

- Question 1: Association Table - MMN14
  
- Question 2: Phone Book Application - MMN14
  
- Question 3: Prime Numbers with Multithreading - MMN15
  
- Question 4: Dining Philosophers Problem - MMN15



## **Question 1: Association Table**

### **Description**

- Implements a generic associative table (AssociationTable<K, V>) where:
  
- K must implement Comparable<K> for ordering.
  
- V can be any type.
  
- Uses java.util.TreeMap for ordered key-value storage.
  
- Includes methods for adding, removing, retrieving, and iterating keys.
  
- Handles key conflicts by replacing previous values.

#### **Additional Implementations**

  - A Student class is implemented with fields for first name, last name, birth year, and average grade.
    
  - AssociationTable<Student, Integer> stores students mapped to their average grades.
    
  - Demonstrates adding, updating, and removing students.

## **Question 2: Phone Book Application**

### **Description**

#### A JavaFX-based phone book application that:

  - Allows adding, updating, and deleting contacts (name and phone number).
    
  - Displays an ordered list of contacts.
    
  - Uses TreeMap or HashMap for storage.
    
  - Provides a search function to find a phone number by name.

## **Question 3: Prime Numbers with Multithreading**

### **Description**

#### A Java program that:

  - Finds all prime numbers between 1 and m using n concurrent threads.
    
  - Uses a shared task queue where threads fetch numbers to check for primality.
    
  - Ensures all threads finish before printing results.
    
  - Example execution: Finding primes from 1 to 1000 with 10 threads.

## **Question 4: Dining Philosophers Problem**

### **Description**

#### Simulates the classic dining philosophers problem where:

  - Five philosophers sit around a table with shared chopsticks.
    
  - Philosophers alternate between thinking and eating.
    
  - A philosopher needs two chopsticks to eat.
    
  - Deadlock prevention strategies are implemented.
    
  - JavaFX UI displays the philosophers' state (thinking/eating).
